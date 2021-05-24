package pl.sokols.bankbackend.repositories;

import org.springframework.data.repository.CrudRepository;
import pl.sokols.bankbackend.entities.AccountEntity;

public interface AccountRepository extends CrudRepository<AccountEntity, Integer> {
}
