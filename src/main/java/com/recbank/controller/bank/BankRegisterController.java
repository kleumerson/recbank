package com.recbank.controller.bank;

import com.recbank.dto.bank.BankDto;
import com.recbank.service.bank.BankRegisterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "api/v1/")
public class BankRegisterController {
    @Autowired
    BankRegisterService bankService;
    @PostMapping(path = "banks")
    public ResponseEntity<BankDto> saveBank(@Validated @RequestBody BankDto bankDto){
        BankDto createBankDto = bankService.saveBank(bankDto);
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(createBankDto);
    }
    @PutMapping(path = "banks")
    public ResponseEntity<BankDto> updateBank(@RequestBody BankDto bankDto, @PathVariable int id){
        return ResponseEntity.status(HttpStatus.OK)
                .body(bankService.updateBank(bankDto, id));
    }
    @DeleteMapping(path = "banks/{id}")
    public void deleteBank(@PathVariable int id){
        bankService.deleteBank(id);
    }
    @GetMapping(path = "/banks")
    public List<BankDto> getBank(){
        return bankService.getBank();
    }
    @GetMapping(path = "banks/{id}")
    public List<BankDto> getBankAndBranch(@PathVariable int id){
        return bankService.getBankAndBranch(id);
    }
    @GetMapping(path = "/banks/")
    public List<BankDto> getBankSearchDynamic(@RequestParam String name){
        return bankService.getBankSearchDynamic(name);
    }
}
