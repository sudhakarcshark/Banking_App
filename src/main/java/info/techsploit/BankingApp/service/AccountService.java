package info.techsploit.BankingApp.service;

import info.techsploit.BankingApp.request.AccountRequest;
import info.techsploit.BankingApp.response.APIResponse;
import org.springframework.aop.framework.AopProxyUtils;
import org.springframework.http.ResponseEntity;

public interface AccountService {

    ResponseEntity<APIResponse> createAccount(AccountRequest accountRequest);
    ResponseEntity<APIResponse> getAccountById(Long id);
    ResponseEntity<APIResponse> depositToAccount(Long id, double amount);
    ResponseEntity<APIResponse> withdrawFromAccount(Long id, double amount);
    ResponseEntity<APIResponse> getAllAccountDetails();
    ResponseEntity<APIResponse> deletedAccountById(Long id);
}
