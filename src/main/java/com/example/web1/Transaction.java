package com.example.web1;


import javax.persistence.*;
import java.time.LocalDateTime;

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
