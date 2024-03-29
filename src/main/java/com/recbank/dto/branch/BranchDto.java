package com.recbank.dto.branch;

import com.recbank.dto.bank.BankDto;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class BranchDto {
    private int id;
    private String address;
    private int code;
    private String name;
    private String phone;
    private BankDto bank;
}
