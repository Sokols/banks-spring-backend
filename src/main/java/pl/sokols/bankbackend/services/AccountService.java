package pl.sokols.bankbackend.services;


import pl.sokols.bankbackend.entities.AccountEntity;

import java.util.List;

public interface AccountService {

    List<AccountEntity> getAllAccounts();

    List<AccountEntity> getAccountsByBankId(String bankId);

    void addAccount(AccountEntity accountDto);
}
