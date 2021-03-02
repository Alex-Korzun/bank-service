package com.banking.bankservice.service;

import com.banking.bankservice.model.Account;
import com.banking.bankservice.model.Transaction;
import java.util.List;

public interface TransactionService {
    List<Transaction> getAllByAccount(int page, int size, Account account);

    void transfer(Account accountFrom, Account accountTo, Double amount);
}
