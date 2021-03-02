package com.banking.bankservice.repository;

import com.banking.bankservice.model.Account;
import com.banking.bankservice.model.Transaction;
import java.util.List;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface TransactionRepository extends JpaRepository<Transaction, Long> {
    @Query(value = "FROM transaction t JOIN FETCH t.accountFrom "
            + "JOIN FETCH t.accountTo WHERE t.accountFrom = ?1 "
            + "AND t.accountTo = ?1")
    List<Transaction> getAllByAccountNumber(Account account, Pageable pageable);
}
