package pl.sokols.bankbackend.controllers.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import pl.sokols.bankbackend.entities.UserEntity;
import pl.sokols.bankbackend.exceptions.InvalidJsonException;
import pl.sokols.bankbackend.exceptions.login.UserNotFoundException;
import pl.sokols.bankbackend.exceptions.login.WrongPasswordException;
import pl.sokols.bankbackend.exceptions.register.UserExistsException;
import pl.sokols.bankbackend.services.UserService;

@RestController
@CrossOrigin(origins = "http://localhost:3000/")
public class UserController {

    private final UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping("/api/loginUser")
    public UserEntity loginUser(@RequestBody UserEntity userDto) throws UserNotFoundException, WrongPasswordException, InvalidJsonException {
        if (userDto == null || userDto.getEmail() == null || userDto.getPassword() == null) {
            throw new InvalidJsonException("Data is not correct.");
        }
        return userService.getUser(userDto.getEmail(), userDto.getPassword());
    }

    @PostMapping("/api/registerUser")
    public UserEntity registerUser(@RequestBody UserEntity userDto) throws UserExistsException {
        return userService.registerUser(userDto);
    }

}
