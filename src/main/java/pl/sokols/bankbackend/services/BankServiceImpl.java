package pl.sokols.bankbackend.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.sokols.bankbackend.dtos.requests.BankRequest;
import pl.sokols.bankbackend.dtos.responses.BankResponse;
import pl.sokols.bankbackend.entities.BankEntity;
import pl.sokols.bankbackend.repositories.BankRepository;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@Service
public class BankServiceImpl implements BankService {

    private final BankRepository bankRepository;

    @Autowired
    public BankServiceImpl(BankRepository bankRepository) {
        this.bankRepository = bankRepository;
    }

    @Override
    public List<BankResponse> getAllBanks() {
        return StreamSupport.stream(bankRepository.findAll().spliterator(), false)
                .map(entity -> new BankResponse(entity.getBankName(), entity.getSwiftCode(), entity.getCountryCode()))
                .collect(Collectors.toList());
    }

    @Override
    public void addBank(BankRequest bankRequest) {
        BankEntity entity = new BankEntity();
        entity.setBankName(bankRequest.getBankName());
        entity.setSwiftCode(bankRequest.getSwiftCode());
        entity.setCountryCode(bankRequest.getCountryCode());
        bankRepository.save(entity);
    }
}
