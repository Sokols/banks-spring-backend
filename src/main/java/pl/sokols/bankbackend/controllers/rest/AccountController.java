package pl.sokols.bankbackend.controllers.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pl.sokols.bankbackend.entities.AccountEntity;
import pl.sokols.bankbackend.services.AccountService;

import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:3000/")
public class AccountController {

    private final AccountService accountService;

    @Autowired
    public AccountController(AccountService accountService) {
        this.accountService = accountService;
    }

    @GetMapping("/api/account")
    public ResponseEntity<List<AccountEntity>> getAccounts() {
        List<AccountEntity> accounts = accountService.getAllAccounts();
        return new ResponseEntity<>(accounts, HttpStatus.OK);
    }

    @GetMapping("/api/account/{bankId}")
        public ResponseEntity<List<AccountEntity>> getAccountsByBankId(@PathVariable String bankId) {
        List<AccountEntity> accounts = accountService.getAccountsByBankId(bankId);
        return new ResponseEntity<>(accounts, HttpStatus.OK);
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
