package pl.sokols.bankbackend.services;

import pl.sokols.bankbackend.dtos.requests.BankRequest;
import pl.sokols.bankbackend.dtos.responses.BankResponse;

import java.util.List;

public interface BankService {

    List<BankResponse> getAllBanks();

    void addBank(BankRequest bankRequest);
}
