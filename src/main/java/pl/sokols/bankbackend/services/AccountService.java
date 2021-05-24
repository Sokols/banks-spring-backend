package pl.sokols.bankbackend.services;

import pl.sokols.bankbackend.dtos.requests.AccountRequest;
import pl.sokols.bankbackend.dtos.responses.AccountResponse;

import java.util.List;

public interface AccountService {

    List<AccountResponse> getAllAccounts();

    void addAccount(AccountRequest accountRequest);
}
