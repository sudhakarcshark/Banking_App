package info.techsploit.BankingApp.service;

import info.techsploit.BankingApp.entity.Account;
import info.techsploit.BankingApp.mapper.AccountMapper;
import info.techsploit.BankingApp.repository.AccountRepos;
import info.techsploit.BankingApp.request.AccountRequest;
import info.techsploit.BankingApp.response.APIResponse;
import info.techsploit.BankingApp.response.AccountResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class AccountServiceImpl implements AccountService{

    private final AccountRepos accountRepos;


    @Override
    public ResponseEntity<APIResponse> createAccount(AccountRequest accountRequest) {

            Account account = accountRepos.save(AccountMapper.requestToAccount(accountRequest));

        return ResponseEntity.ok(
                APIResponse.builder()
                        .errorCode(0)
                        .errorMessage("Account Details Added")
                        .data(AccountMapper.responseToAccount(account))
                        .build()
        );
    }

    @Override
    public ResponseEntity<APIResponse> getAccountById(Long id) {
     Account account  = accountRepos.findById(id)
                                    .orElseThrow(() -> new RuntimeException("Account Doest Not Exist"));
        return ResponseEntity.ok(APIResponse
                .builder()
                .errorCode(0)
                .errorMessage("Sucessfully Reterived")
                .data(AccountMapper.responseToAccount(account))
                .build());
    }

    @Override
    public ResponseEntity<APIResponse> depositToAccount(Long id, double amount) {

      Account account = accountRepos.findById(id)
                .orElseThrow(() -> new RuntimeException("Account Does not Exist"));

      double total = account.getBalance()+amount;
      account.setBalance(total);
      Account savedAccount =  accountRepos.save(account);

        return ResponseEntity.ok(APIResponse
                .builder()
                .errorCode(0)
                .errorMessage("Deposited Sucussfully")
                .data(AccountMapper.responseToAccount(savedAccount))
                .build());
    }

    @Override
    public ResponseEntity<APIResponse> withdrawFromAccount(Long id, double amount) {

      Account account =  accountRepos.findById(id)
                .orElseThrow(() -> new RuntimeException("Account Does Not Exist"));

      if (account.getBalance() < 50000){
          throw new RuntimeException("Insufficient Balance");
      }

    double total =  account.getBalance()-amount;
                    account.setBalance(total);
                    Account withdrawAccount  = accountRepos.save(account);

        return ResponseEntity.ok(
                APIResponse.builder()
                        .errorCode(0)
                        .errorMessage("WithDrawed")
                        .data(AccountMapper.responseToAccount(withdrawAccount))
                        .build());
    }

    @Override
    public ResponseEntity<APIResponse> getAllAccountDetails() {

        List<Account> accountList = accountRepos.findAll();
        List<AccountResponse> accountResponses =  accountList.stream().map(account -> AccountMapper.responseToAccount(account)).toList();
        return ResponseEntity.ok(APIResponse
                .builder()
                .errorCode(0)
                .errorMessage("All Accounts Details")
                .data(accountResponses)
                .build()
        );
    }

    @Override
    public ResponseEntity<APIResponse> deletedAccountById(Long id) {

      Optional<Account>  findAccount  = accountRepos.findById(id);
      if (!findAccount.isPresent()){
          return ResponseEntity.ok(
                  APIResponse.builder()
                          .errorCode(200)
                          .errorMessage("Account Not Found")
                          .data(List.of())
                          .build()
          );
      }

        accountRepos.deleteById(id);
        return ResponseEntity.ok(
                APIResponse.builder()
                        .errorCode(0)
                        .errorMessage("Account Deleted")
                        .data(List.of())
                        .build()
        );

    }
}
