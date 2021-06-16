package pl.sokols.bankbackend.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
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
    public List<BankEntity> getAllBanksByUserId(String userId) {
        return StreamSupport.stream(bankRepository.findBankEntitiesByUserId(Integer.parseInt(userId)).spliterator(), false)
                .map(entity -> new BankEntity(entity.getId(), entity.getBankName(), entity.getSwiftCode(), entity.getCountryCode(), entity.getUserId(), entity.getBankImageUrl()))
                .collect(Collectors.toList());
    }

    @Override
    public void addBank(BankEntity bankDto) {
        BankEntity entity = new BankEntity();
        entity.setId(bankDto.getId());
        entity.setBankName(bankDto.getBankName());
        entity.setSwiftCode(bankDto.getSwiftCode());
        entity.setCountryCode(bankDto.getCountryCode());
        entity.setUserId(bankDto.getUserId());
        entity.setBankImageUrl(bankDto.getBankImageUrl());
        bankRepository.save(entity);
    }

    @Override
    public void deleteBank(BankEntity bankDto) {
        BankEntity entity = bankRepository.findByBankName(bankDto.getBankName());
        bankRepository.delete(entity);
    }
}
