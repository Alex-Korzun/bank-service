package com.banking.bankservice.service;

import com.banking.bankservice.model.Account;

import java.util.List;

public interface AccountService {
    Account save(Account account);

    Account getAccountByAccountNumber(String accountNumber);

    List<Account> findAccountsByPhoneNumber(String phoneNumber);

    void blockAccount(String accountNumber);
}
