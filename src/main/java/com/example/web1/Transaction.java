package com.example.web1;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import org.springframework.web.context.WebApplicationContext;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.Date;

@Scope(value = WebApplicationContext.SCOPE_REQUEST,proxyMode = ScopedProxyMode.TARGET_CLASS)
@Entity
public class Transaction {
    private TransactionType transactionType;
    private double amount;
    private LocalDateTime creationDate;
    @ManyToOne(fetch = FetchType.EAGER)
    private User user;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;



    public Transaction(TransactionType transactionType,double amount,User user){
        this.transactionType = transactionType;
        this.user = user;
        this.creationDate = java.time.LocalDateTime.now();
        this.amount = amount;
    }
    public Transaction(){}


    public void setCreationDate(LocalDateTime creationDate) {
        this.creationDate = creationDate;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public User getUser() {
        return user;
    }

    public LocalDateTime getCreationDate() {
        return creationDate;
    }

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
