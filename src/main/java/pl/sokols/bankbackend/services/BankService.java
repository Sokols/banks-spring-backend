package pl.sokols.bankbackend.services;

import pl.sokols.bankbackend.entities.BankEntity;

import java.util.List;

public interface BankService {

    List<BankEntity> getAllBanksByUserId(String userId);

    void addBank(BankEntity bankDto);

    void deleteBank(BankEntity bankDto);
}
