package pl.sokols.bankbackend.repositories;

import org.springframework.data.repository.CrudRepository;
import pl.sokols.bankbackend.entities.AccountEntity;

import java.util.List;

public interface AccountRepository extends CrudRepository<AccountEntity, Integer> {
    List<AccountEntity> findAllByBankId(String bankId);
}
