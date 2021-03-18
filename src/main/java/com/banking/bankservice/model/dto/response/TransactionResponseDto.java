package com.banking.bankservice.model.dto.response;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class TransactionResponseDto {
    private Long id;
    private String accountFrom;
    private String accountTo;
    private Double amount;
    private String date;
    private String type;
}
