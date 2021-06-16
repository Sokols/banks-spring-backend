package pl.sokols.bankbackend.services;

import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import pl.sokols.bankbackend.entities.UserEntity;
import pl.sokols.bankbackend.exceptions.login.UserNotFoundException;
import pl.sokols.bankbackend.exceptions.login.WrongPasswordException;
import pl.sokols.bankbackend.exceptions.register.UserExistsException;
import pl.sokols.bankbackend.repositories.UserRepository;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@Service
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    public UserServiceImpl(UserRepository userRepository, PasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
    }

    @Override
    public List<UserEntity> getAllUsers() {
        return StreamSupport.stream(userRepository.findAll().spliterator(), false)
                .map(entity -> new UserEntity(entity.getId(), entity.getUsername(), entity.getEmail(), entity.getPassword()))
                .collect(Collectors.toList());
    }

    @Override
    public UserEntity registerUser(UserEntity userDto) throws UserExistsException {
        if (userRepository.findByUsername(userDto.getUsername()) != null) {
            throw new UserExistsException("User " + userDto.getUsername() + " already exists.");
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

    @Override
    public void deleteUser(UserEntity userDto) {
        UserEntity entity = userRepository.findByUsername(userDto.getUsername());
        userRepository.delete(entity);
    }
}
