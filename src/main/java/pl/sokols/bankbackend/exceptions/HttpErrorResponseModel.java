package pl.sokols.bankbackend.exceptions;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class HttpErrorResponseModel {
    private int statusCode;
    private String message;
    private String details;
}
