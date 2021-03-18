package com.banking.bankservice.mapper.impl;

import com.banking.bankservice.mapper.AccountMapper;
import com.banking.bankservice.model.Account;
import com.banking.bankservice.model.Currency;
import com.banking.bankservice.model.dto.request.AccountRequestDto;
import com.banking.bankservice.model.dto.response.AccountResponseDto;
import com.banking.bankservice.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class AccountMapperImpl implements AccountMapper {
    private final UserService userService;

    @Autowired
    public AccountMapperImpl(UserService userService) {
        this.userService = userService;
    }

    @Override
    public Account fromDto(AccountRequestDto accountRequestDto) {
        Account account = new Account();
        account.setAccountNumber(accountRequestDto.getAccountNumber());
        account.setBalance(accountRequestDto.getBalance());
        account.setCurrencyType(Currency.valueOf(accountRequestDto.getCurrencyType().toString()));
        account.setCurrencyType(accountRequestDto.getCurrencyType());
        account.setUser(userService.getById(accountRequestDto.getUserId()));
        return account;
    }

    @Override
    public AccountResponseDto toDto(Account account) {
        return AccountResponseDto.builder()
                .id(account.getId())
                .accountNumber(account.getAccountNumber())
                .balance(account.getBalance())
                .currency(account.getCurrencyType().toString())
                .isActive(account.isActive())
                .build();
    }
}
