package com.recbank.service.bank;

import com.recbank.dto.bank.BankDto;
import com.recbank.exception.BankNotFoundException;
import com.recbank.model.bank.Bank;
import com.recbank.repository.bank.BankRegisterRepository;
import com.recbank.specification.BankSpecification;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class BankRegisterService {
    @Autowired
    private BankRegisterRepository bankRepository;

    @Autowired
    private ModelMapper modelMapper;

    public BankDto saveBank(BankDto bankDto) {
        Bank bank = modelMapper.map(bankDto, Bank.class);
        if (existBankName(bank.getBankName())) {
            System.out.println("Bank already exists, please enter another bank name.");
        }else {
            bankRepository.save(bank);
        }
        return modelMapper.map(bank, BankDto.class);
    }

    public BankDto updateBank(BankDto bankDto, int id){
        Bank bank = modelMapper.map(bankDto, Bank.class);
        bankRepository.findById(id)
                .orElseThrow(() -> new BankNotFoundException());
        bank.setId(id);
        bankRepository.save(bank);
        return modelMapper.map(bank, BankDto.class);
    }

    public void deleteBank(int id){
        bankRepository.findById(id)
                .orElseThrow(() -> new BankNotFoundException());
        bankRepository.deleteById(id);
    }

    public List<BankDto> getBank(){
        return bankRepository.findAll()
                .stream().map(m -> modelMapper.map(m,BankDto.class))
                .collect(Collectors.toList());
    }

    public List<BankDto> getBankAndBranch(int id) {
        bankRepository.findById(id)
                .orElseThrow(() -> new BankNotFoundException());
        return bankRepository.findByBankAndBranch(id)
                .stream().map(m -> modelMapper.map(m,BankDto.class))
                .collect(Collectors.toList());
    }

    public List<BankDto> getBankSearchDynamic(String nome){
        List<Bank> bankList = bankRepository.findAll(Specification.
                where(BankSpecification.headQuarters(nome)));
        return bankList.stream().map(m -> modelMapper.map(m,BankDto.class))
                .collect(Collectors.toList());
    }

    public boolean existBankName(String bankName){
        Optional<Bank> optional = bankRepository.findByBankName(bankName);
        return optional.isPresent();
    }
}
