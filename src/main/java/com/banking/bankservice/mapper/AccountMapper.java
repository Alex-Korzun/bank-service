package com.banking.bankservice.mapper;

import com.banking.bankservice.model.Account;
import com.banking.bankservice.model.dto.request.AccountRequestDto;
import com.banking.bankservice.model.dto.response.AccountResponseDto;

public interface AccountMapper {
    Account fromDto(AccountRequestDto accountRequestDto);

    AccountResponseDto toDto(Account account);
}
