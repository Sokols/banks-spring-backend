package pl.sokols.bankbackend.controllers.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import pl.sokols.bankbackend.dtos.requests.UserRequest;
import pl.sokols.bankbackend.entities.UserEntity;
import pl.sokols.bankbackend.exceptions.register.UserExistsException;
import pl.sokols.bankbackend.services.UserService;

@RestController
public class UserController {

    private final UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping("/api/loginUser")
    public UserEntity loginUser(@RequestBody UserRequest userRequest) {
        return userService.loginUser(userRequest);
    }

    @PostMapping("/api/registerUser")
    public UserEntity registerUser(@RequestBody UserRequest userRequest) throws UserExistsException {
        return userService.registerUser(userRequest);
    }

}
