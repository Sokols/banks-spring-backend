package pl.sokols.bankbackend.exceptions;

public class InvalidJsonException extends Throwable {
    public InvalidJsonException(String message) {
        super(message);
    }
}
