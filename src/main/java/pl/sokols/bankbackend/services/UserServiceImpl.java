package pl.sokols.bankbackend.services;

import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import pl.sokols.bankbackend.entities.UserEntity;
import pl.sokols.bankbackend.exceptions.login.UserNotFoundException;
import pl.sokols.bankbackend.exceptions.login.WrongPasswordException;
import pl.sokols.bankbackend.exceptions.register.UserExistsException;
import pl.sokols.bankbackend.repositories.UserRepository;

@Service
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    public UserServiceImpl(UserRepository userRepository, PasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
    }

    @Override
    public UserEntity registerUser(UserEntity userDto) throws UserExistsException {
        if (userRepository.findByUsername(userDto.getUsername()) != null) {
            throw new UserExistsException("User " + userDto.getUsername() + " already exists!");
        }

        if (userRepository.findByEmail(userDto.getEmail()) != null) {
            throw new UserExistsException("E-mail " + userDto.getEmail() + " is already in use!");
        }

        UserEntity entity = new UserEntity();
        entity.setId(userDto.getId());
        entity.setUsername(userDto.getUsername());
        entity.setEmail(userDto.getEmail());
        entity.setPassword(passwordEncoder.encode(userDto.getPassword()));
        return userRepository.save(entity);
    }

    @Override
    public UserEntity getUser(String email, String password) throws UserNotFoundException, WrongPasswordException {
        UserEntity entity = userRepository.findByEmail(email);
        if (entity == null) {
            throw new UserNotFoundException(email + " not found.");
        } else if (!passwordEncoder.matches(password, entity.getPassword())) {
            throw new WrongPasswordException("Invalid password.");
        }
        return entity;
    }
}
