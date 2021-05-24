package pl.sokols.bankbackend.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.sokols.bankbackend.dtos.requests.AccountRequest;
import pl.sokols.bankbackend.dtos.responses.AccountResponse;
import pl.sokols.bankbackend.entities.AccountEntity;
import pl.sokols.bankbackend.repositories.AccountRepository;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@Service
public class AccountServiceImpl implements AccountService {

    private final AccountRepository accountRepository;

    @Autowired
    public AccountServiceImpl(AccountRepository accountRepository) {
        this.accountRepository = accountRepository;
    }

    @Override
    public List<AccountResponse> getAllAccounts() {
        return StreamSupport.stream(accountRepository.findAll().spliterator(), false)
                .map(entity -> new AccountResponse(entity.getOwnerName(), entity.getOwnerSurname(), entity.getAccountNumber(), entity.getBank()))
                .collect(Collectors.toList());
    }

    @Override
    public void addAccount(AccountRequest accountRequest) {
        AccountEntity entity = new AccountEntity();
        entity.setOwnerName(accountRequest.getOwnerName());
        entity.setOwnerSurname(accountRequest.getOwnerSurname());
        entity.setAccountNumber(accountRequest.getAccountNumber());
        entity.setBank(accountRequest.getBank());
        accountRepository.save(entity);
    }
}
