package com.banking.bankservice.model.dto.response;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class AccountResponseDto {
    private Long id;
    private String accountNumber;
    private String currency;
    private Double balance;
    private boolean isActive;
}
