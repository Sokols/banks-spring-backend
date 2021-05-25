package pl.sokols.bankbackend.services;

import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import pl.sokols.bankbackend.dtos.requests.UserRequest;
import pl.sokols.bankbackend.dtos.responses.UserResponse;
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
    public List<UserResponse> getAllUsers() {
        return StreamSupport.stream(userRepository.findAll().spliterator(), false)
                .map(entity -> new UserResponse(entity.getUsername(), entity.getEmail(), entity.getPassword()))
                .collect(Collectors.toList());
    }

    @Override
    public UserEntity registerUser(UserRequest userRequest) throws UserExistsException {
        if (userRepository.findByUsername(userRequest.getUsername()) != null) {
            throw new UserExistsException("User " + userRequest.getUsername() + " already exists.");
        }
        UserEntity entity = new UserEntity();
        entity.setUsername(userRequest.getUsername());
        entity.setEmail(userRequest.getEmail());
        entity.setPassword(passwordEncoder.encode(userRequest.getPassword()));
        return userRepository.save(entity);
    }

    @Override
    public UserEntity getUser(String username, String password) throws UserNotFoundException, WrongPasswordException {
        UserEntity entity = userRepository.findByUsername(username);
        if (entity == null) {
            throw new UserNotFoundException(username + " not found.");
        } else if (!passwordEncoder.matches(password, entity.getPassword())) {
            throw new WrongPasswordException("Invalid password.");
        }
        return entity;
    }

    @Override
    public UserEntity loginUser(UserRequest userRequest) {
        UserEntity entity = new UserEntity();
        entity.setUsername(userRequest.getUsername());
        entity.setEmail(userRequest.getEmail());
        entity.setPassword(userRequest.getPassword());
        return userRepository.save(entity);
    }

    @Override
    public void deleteUser(UserRequest userRequest) {
        UserEntity entity = userRepository.findByUsername(userRequest.getUsername());
        userRepository.delete(entity);
    }
}
