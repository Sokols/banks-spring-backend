package pl.sokols.bankbackend.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.sokols.bankbackend.entities.AccountEntity;
import pl.sokols.bankbackend.repositories.AccountRepository;

import java.util.List;
import java.util.Optional;
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
    public List<AccountEntity> getAccountsByUserAndBankId(String userId, String bankId) {
        return StreamSupport.stream(accountRepository.findAll().spliterator(), false)
                .filter(account -> account.getUserId() == Integer.parseInt(userId) && account.getBank().getId() == Integer.parseInt(bankId))
                .map(entity -> new AccountEntity(entity.getId(), entity.getOwnerName(), entity.getOwnerSurname(), entity.getAccountNumber(), entity.getBank(), entity.getUserId()))
                .collect(Collectors.toList());
    }

    @Override
    public void addAccount(AccountEntity accountDto) {
        AccountEntity entity = new AccountEntity();
        entity.setId(accountDto.getId());
        entity.setOwnerName(accountDto.getOwnerName());
        entity.setOwnerSurname(accountDto.getOwnerSurname());
        entity.setAccountNumber(accountDto.getAccountNumber());
        entity.setBank(accountDto.getBank());
        entity.setUserId(accountDto.getUserId());
        accountRepository.save(entity);
    }

    @Override
    public void removeAccount(String accountId) {
        Optional<AccountEntity> entity = accountRepository.findById(Integer.parseInt(accountId));
        entity.ifPresent(accountRepository::delete);
    }
}
