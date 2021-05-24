package pl.sokols.bankbackend.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import pl.sokols.bankbackend.dtos.requests.AccountRequest;
import pl.sokols.bankbackend.dtos.responses.AccountResponse;
import pl.sokols.bankbackend.services.AccountService;

import java.util.List;

@RestController
public class AccountController {

    private final AccountService accountService;

    @Autowired
    public AccountController(AccountService accountService) {
        this.accountService = accountService;
    }

    @GetMapping("/api/account")
    public ResponseEntity<List<AccountResponse>> getAccounts() {
        List<AccountResponse> accounts = accountService.getAllAccounts();
        return new ResponseEntity<>(accounts, HttpStatus.OK);
    }

    @PostMapping("/api/account")
    public ResponseEntity addAccount(@RequestBody AccountRequest accountRequest) {
        accountService.addAccount(accountRequest);
        return new ResponseEntity(HttpStatus.CREATED);
    }
}
