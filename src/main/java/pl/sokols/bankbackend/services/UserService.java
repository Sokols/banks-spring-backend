package pl.sokols.bankbackend.services;

import pl.sokols.bankbackend.dtos.requests.UserRequest;
import pl.sokols.bankbackend.dtos.responses.UserResponse;
import pl.sokols.bankbackend.entities.UserEntity;
import pl.sokols.bankbackend.exceptions.login.UserNotFoundException;
import pl.sokols.bankbackend.exceptions.login.WrongPasswordException;
import pl.sokols.bankbackend.exceptions.register.UserExistsException;

import java.util.List;

public interface UserService {

    List<UserResponse> getAllUsers();
    UserEntity getUser(String username, String password) throws UserNotFoundException, WrongPasswordException;
    UserEntity registerUser(UserRequest userRequest) throws UserExistsException;

    UserEntity loginUser(UserRequest userRequest);
    void deleteUser(UserRequest userRequest);
}
