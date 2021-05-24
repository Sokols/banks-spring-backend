package pl.sokols.bankbackend.dtos.responses;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class BankResponse {
    private String bankName;
    private String swiftCode;
    private String countryCode;
}
