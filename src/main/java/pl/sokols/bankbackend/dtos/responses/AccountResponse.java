package pl.sokols.bankbackend.dtos.responses;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import pl.sokols.bankbackend.entities.BankEntity;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class AccountResponse {
    private String ownerName;
    private String ownerSurname;
    private String accountNumber;
    private BankEntity bank;
}
