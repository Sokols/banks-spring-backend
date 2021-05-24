package pl.sokols.bankbackend.dtos.requests;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class BankRequest {
    private String bankName;
    private String swiftCode;
    private String countryCode;
}
