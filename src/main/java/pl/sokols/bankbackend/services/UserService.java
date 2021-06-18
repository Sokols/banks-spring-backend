package pl.sokols.bankbackend.services;

import pl.sokols.bankbackend.entities.UserEntity;
import pl.sokols.bankbackend.exceptions.login.UserNotFoundException;
import pl.sokols.bankbackend.exceptions.login.WrongPasswordException;
import pl.sokols.bankbackend.exceptions.register.UserExistsException;

public interface UserService {
    UserEntity getUser(String email, String password) throws UserNotFoundException, WrongPasswordException;

    UserEntity registerUser(UserEntity userDto) throws UserExistsException;
}

