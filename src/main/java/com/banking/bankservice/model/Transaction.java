package com.banking.bankservice.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import java.time.LocalDateTime;
import lombok.Data;

@Entity(name = "transaction")
@Data
public class Transaction {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @ManyToOne
    @Column(name = "account_from")
    private Account accountFrom;
    @ManyToOne
    @Column(name = "account_to")
    private Account accountTo;
    private Double amount;
    private LocalDateTime date;
    @Enumerated(EnumType.STRING)
    private TypeOfOperation type;

    public enum TypeOfOperation {
        INCOMING, OUTCOMING
    }
}
