package com.banking.bankservice.service.impl;

import com.banking.bankservice.model.Account;
import com.banking.bankservice.model.Transaction;
import com.banking.bankservice.repository.TransactionRepository;
import com.banking.bankservice.service.AccountService;
import com.banking.bankservice.service.TransactionService;
import java.time.LocalDateTime;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class TransactionServiceImpl implements TransactionService {
    private final TransactionRepository transactionRepository;
    private final AccountService accountService;
    private final Converter converter;

    @Autowired
    public TransactionServiceImpl(TransactionRepository transactionRepository,
                                  AccountService accountService, Converter converter) {
        this.transactionRepository = transactionRepository;
        this.accountService = accountService;
        this.converter = converter;
    }

    @Override
    public List<Transaction> getAllByAccount(int page, int size, Account account) {
        Pageable pageable = PageRequest.of(page, size, Sort.by("date").descending());
        return transactionRepository.getAllByAccountNumber(account, pageable);
    }

    @Override
    @Transactional
    public void transfer(Account accountFrom, Account accountTo, Double amount) {
        Transaction transactionFromAccount = new Transaction();
        transactionFromAccount.setAccountFrom(accountFrom);
        transactionFromAccount.setAccountTo(accountTo);
        if (accountFrom.getCurrencyType() != accountTo.getCurrencyType()) {
            amount = converter.convert(accountFrom.getCurrencyType(),
                    accountTo.getCurrencyType(), amount);
        }
        transactionFromAccount.setAmount(amount);
        transactionFromAccount.setDate(LocalDateTime.now());
        transactionFromAccount.setType(Transaction.TypeOfOperation.OUTCOMING);
        if (amount < accountFrom.getBalance()) {
            accountFrom.setBalance(accountFrom.getBalance() - amount);
        } else {
            throw new RuntimeException("Can't provide this transaction. "
                    + "Not enough money on your account.");
        }
        transactionRepository.save(transactionFromAccount);
        accountService.save(accountFrom);

        Transaction transactionToAccount = new Transaction();
        transactionToAccount.setAccountFrom(accountFrom);
        transactionToAccount.setAccountTo(accountTo);
        transactionToAccount.setAmount(amount);
        transactionToAccount.setDate(LocalDateTime.now());
        transactionToAccount.setType(Transaction.TypeOfOperation.INCOMING);
        accountTo.setBalance(accountTo.getBalance() + amount);
        transactionRepository.save(transactionToAccount);
        accountService.save(accountTo);
    }
}
