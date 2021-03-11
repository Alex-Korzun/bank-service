package com.banking.bankservice.mapper.impl;

import com.banking.bankservice.mapper.TransactionMapper;
import com.banking.bankservice.model.Transaction;
import com.banking.bankservice.model.dto.response.TransactionResponseDto;
import org.springframework.stereotype.Component;

@Component
public class TransactionMapperImpl implements TransactionMapper {
    @Override
    public TransactionResponseDto toDto(Transaction transaction) {
        return TransactionResponseDto.builder()
                .id(transaction.getId())
                .accountFrom(transaction.getAccountFrom().getAccountNumber())
                .accountTo(transaction.getAccountTo().getAccountNumber())
                .amount(transaction.getAmount())
                .date(transaction.getDate().toString())
                .type(transaction.getType().toString())
                .build();
    }
}
