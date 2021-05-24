package pl.sokols.bankbackend.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import pl.sokols.bankbackend.dtos.requests.BankRequest;
import pl.sokols.bankbackend.dtos.responses.BankResponse;
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
    public ResponseEntity<List<BankResponse>> getBanks() {
        List<BankResponse> banks = bankService.getAllBanks();
        return new ResponseEntity<>(banks, HttpStatus.OK);
    }

    @PostMapping("/api/bank")
    public ResponseEntity addBank(@RequestBody BankRequest bankRequest) {
        bankService.addBank(bankRequest);

        return new ResponseEntity(HttpStatus.CREATED);
    }
}
