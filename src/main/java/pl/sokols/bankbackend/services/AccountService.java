package pl.sokols.bankbackend.services;


import pl.sokols.bankbackend.entities.AccountEntity;

import java.util.List;

public interface AccountService {

    List<AccountEntity> getAccountsByUserAndBankId(String userId, String bankId);

    void addAccount(AccountEntity accountDto);

    void removeAccount(String accountId);
}
