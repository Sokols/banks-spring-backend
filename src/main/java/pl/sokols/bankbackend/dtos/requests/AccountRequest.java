package pl.sokols.bankbackend.dtos.requests;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import pl.sokols.bankbackend.entities.BankEntity;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class AccountRequest {
    private String ownerName;
    private String ownerSurname;
    private String accountNumber;
    private BankEntity bank;
}
