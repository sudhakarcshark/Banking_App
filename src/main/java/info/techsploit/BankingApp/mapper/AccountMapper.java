package info.techsploit.BankingApp.mapper;

import info.techsploit.BankingApp.entity.Account;
import info.techsploit.BankingApp.request.AccountRequest;
import info.techsploit.BankingApp.response.AccountResponse;

public class AccountMapper {

    public static Account requestToAccount(AccountRequest accountRequest){

        return Account.builder()
                .accountHolderName(accountRequest.getAccountHolderName())
                .balance(accountRequest.getBalance())
                .build();
    }

    public static AccountResponse responseToAccount(Account account){
        return AccountResponse.builder()
                .id(account.getId())
                .accountHolderName(account.getAccountHolderName())
                .balance(account.getBalance())
                .build();
    }
}
