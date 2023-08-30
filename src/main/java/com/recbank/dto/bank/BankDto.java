package com.kbank.dto.bank;

import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class BankDto {
    private int id;

    @NotBlank(message = "Bank name is mandatory")
    private String bankName;

    @NotBlank(message = "Web Address is mandatory")
    private String webAddress;

    @NotBlank(message = "Head Quarters is mandatory")
    private String headQuarters;

}
