package pl.sokols.bankbackend.repositories;

import org.springframework.data.repository.CrudRepository;
import pl.sokols.bankbackend.entities.UserEntity;

public interface UserRepository extends CrudRepository<UserEntity, Integer> {
    UserEntity findByUsername(String username);

    UserEntity findByEmail(String email);
}