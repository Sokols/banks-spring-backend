package pl.sokols.bankbackend.controllers.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pl.sokols.bankbackend.entities.BankEntity;
import pl.sokols.bankbackend.services.BankService;

import java.util.List;

@RestController
public class BankController {

    private final BankService bankService;

    @Autowired
    public BankController(BankService bankService) {
        this.bankService = bankService;
    }

    @GetMapping("/api/bank")
    public ResponseEntity<List<BankEntity>> getBanks() {
        List<BankEntity> banks = bankService.getAllBanks();
        return new ResponseEntity<>(banks, HttpStatus.OK);
    }

    @PostMapping("/api/bank")
    public ResponseEntity addBank(@RequestBody BankEntity bankDto) {
        bankService.addBank(bankDto);
        return new ResponseEntity(HttpStatus.CREATED);
    }

    @DeleteMapping("/api/bank")
    public ResponseEntity deleteBank(@RequestBody BankEntity bankDto) {
        bankService.deleteBank(bankDto);
        return new ResponseEntity(HttpStatus.OK);
    }
}
