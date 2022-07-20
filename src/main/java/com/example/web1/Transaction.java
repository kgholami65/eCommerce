package com.example.web1;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.stereotype.Service;
import org.springframework.web.context.WebApplicationContext;

import javax.persistence.*;
import java.util.Date;

@Service
@Scope(value = WebApplicationContext.SCOPE_REQUEST,proxyMode = ScopedProxyMode.TARGET_CLASS)
@Entity
public class Transaction {
    private TransactionType transactionType;
    private double amount;
    private Date creationDate;
    @ManyToOne(fetch = FetchType.LAZY)
    private User user;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public void setTransactionType(TransactionType transactionType) {
        this.transactionType = transactionType;
    }

    public TransactionType getTransactionType() {
        return transactionType;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }

    public double getAmount() {
        return amount;
    }
}
