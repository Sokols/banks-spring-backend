package pl.sokols.bankbackend.controllers.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pl.sokols.bankbackend.entities.AccountEntity;
import pl.sokols.bankbackend.services.AccountService;

import java.util.List;

@RestController
public class AccountController {

    private final AccountService accountService;

    @Autowired
    public AccountController(AccountService accountService) {
        this.accountService = accountService;
    }

    @GetMapping("/api/account/{userId}/{bankId}")
    public ResponseEntity<List<AccountEntity>> getAccountsByUserAndBankId(@PathVariable String userId, @PathVariable String bankId) {
        List<AccountEntity> accounts = accountService.getAccountsByUserAndBankId(userId, bankId);
        return new ResponseEntity<>(accounts, HttpStatus.OK);
    }

    @DeleteMapping("/api/account/{accountId}")
    public ResponseEntity removeAccountById(@PathVariable String accountId) {
        accountService.removeAccount(accountId);
        return new ResponseEntity(HttpStatus.OK);
    }

    @PostMapping("/api/account")
    public ResponseEntity addAccount(@RequestBody AccountEntity accountDto) {
        accountService.addAccount(accountDto);
        return new ResponseEntity(HttpStatus.CREATED);
    }

    @PutMapping("/api/account")
    public ResponseEntity editAccount(@RequestBody AccountEntity accountDto) {
        accountService.addAccount(accountDto);
        return new ResponseEntity(HttpStatus.OK);
    }
}
