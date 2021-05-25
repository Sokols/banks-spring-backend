package pl.sokols.bankbackend.controllers.advice;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import pl.sokols.bankbackend.exceptions.HttpErrorResponseModel;

@ControllerAdvice
public class AdviceController {

    @ExceptionHandler
    public ResponseEntity<HttpErrorResponseModel> handleException(Exception e) {

        HttpErrorResponseModel model = new HttpErrorResponseModel();

        model.setStatusCode(HttpStatus.NOT_ACCEPTABLE.value());
        model.setMessage(HttpStatus.NOT_ACCEPTABLE.name());
        model.setDetails(e.getMessage());

        return new ResponseEntity<>(model, HttpStatus.NOT_ACCEPTABLE);
    }
}
