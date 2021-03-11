package com.banking.bankservice.model.dto.request;

import com.banking.bankservice.model.Currency;
import lombok.Data;

@Data
public class AccountRequestDto {
    private String accountNumber;
    private Long userID;
    private Currency currencyType;
    private Double balance;
}
