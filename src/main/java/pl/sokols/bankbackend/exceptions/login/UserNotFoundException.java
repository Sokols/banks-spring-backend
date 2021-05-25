package pl.sokols.bankbackend.exceptions.login;

public class UserNotFoundException extends LoginException {
    public UserNotFoundException(String message) {
        super(message);
    }
}
