package pl.sokols.bankbackend.exceptions.register;

public class UserExistsException extends RegisterException {
    public UserExistsException(String message) {
        super(message);
    }
}
