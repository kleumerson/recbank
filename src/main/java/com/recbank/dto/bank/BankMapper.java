package com.kbank.dto.bank;

public class BankMapper {
    public static BankMapper fromBankToResponse;
    public static BankResponse fromBankToResponse(BankDto bankDto){
        return new BankResponse(
                bankDto.getBankName(),
                bankDto.getWebAddress(),
                bankDto.getHeadQuarters()
        );
    }
}
