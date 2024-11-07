package info.techsploit.BankingApp.controller;

import info.techsploit.BankingApp.request.AccountRequest;
import info.techsploit.BankingApp.response.APIResponse;
import info.techsploit.BankingApp.service.AccountService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/account")
public class AccountController {

    private final AccountService accountService;

    @PostMapping("/create")
    ResponseEntity<APIResponse> createAccount (@RequestBody AccountRequest accountRequest){

        return accountService.createAccount(accountRequest);
    }

    @GetMapping("/getById/{id}")
    ResponseEntity<APIResponse> getAccountById (@PathVariable Long id){

        return  accountService.getAccountById(id);

    }

    @PutMapping("{id}/deposit")
    ResponseEntity<APIResponse> depositToAccount(@PathVariable Long id, @RequestBody Map<String,Double> request){
      Double amount = request.get("amount");
      return accountService.depositToAccount(id,amount);
    }

    @PutMapping("{id}/withdrawal")
    ResponseEntity<APIResponse> withdrawFromAccount(@PathVariable Long id, @RequestBody Map<String,Double> request){
       Double amount = request.get("amount");
       return accountService.withdrawFromAccount(id,amount);
    }

    @GetMapping("/allaccountdetails")
    ResponseEntity<APIResponse> allAccountDetails(){
        return accountService.getAllAccountDetails();
    }

    @DeleteMapping("{id}/delete")
    ResponseEntity<APIResponse> deleteAccount(@PathVariable Long id){
        return accountService.deletedAccountById(id);
    }
}
