package com.banking.bankservice.mapper;

import com.banking.bankservice.model.Transaction;
import com.banking.bankservice.model.dto.response.TransactionResponseDto;

public interface TransactionMapper {
    TransactionResponseDto toDto(Transaction transaction);
}
