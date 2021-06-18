package pl.sokols.bankbackend.repositories;

import org.springframework.data.repository.CrudRepository;
import pl.sokols.bankbackend.entities.BankEntity;

public interface BankRepository extends CrudRepository<BankEntity, Integer> {

    BankEntity findByBankName(String name);
}
