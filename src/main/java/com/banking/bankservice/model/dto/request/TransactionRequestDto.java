package com.banking.bankservice.model.dto.request;

import lombok.Data;

@Data
public class TransactionRequestDto {
    private String accountFrom;
    private String accountTo;
    private Double amount;
}
