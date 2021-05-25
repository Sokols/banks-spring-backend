package pl.sokols.bankbackend.exceptions.login;

public class WrongPasswordException extends LoginException {
    public WrongPasswordException(String message) {
        super(message);
    }
}
