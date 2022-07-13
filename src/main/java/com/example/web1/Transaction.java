package com.example.web1;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;
import org.springframework.web.context.WebApplicationContext;

@Service
@Scope(value = WebApplicationContext.SCOPE_REQUEST)
public class Transaction {
    private TransactionType transactionType;
    private double amount;
    @Autowired
    private User user;

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public void setTransactionType(TransactionType transactionType) {
        this.transactionType = transactionType;
    }
    public void Deposit(){
        user.setMoney(user.getMoney() + amount);
        transactionType = TransactionType.DEPOSIT;
    }


   public boolean Withdrawal(Item item){
        transactionType = TransactionType.WITHDRAWAL;
        if(item.getPrice() > user.getMoney())
            return false;
        else{
            user.setMoney(user.getMoney() - item.getPrice());
            return true;
        }
    }

    public TransactionType getTransactionType() {
        return transactionType;
    }
}
