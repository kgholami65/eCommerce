package com.example.web1;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TransactionService {
    private User user;
    private Transaction transaction;
    private TransactionRepository transactionRepository;
    private UserRepository userRepository;


    @Autowired
    public TransactionService(User user,Transaction transaction,TransactionRepository transactionRepository,
    UserRepository userRepository){
        this.transaction = transaction;
        this.user = user;
        this.transactionRepository = transactionRepository;
        this.userRepository = userRepository;
    }
    public void deposit(double money){
        transaction.setAmount(money);
        user.setMoney(user.getMoney() + transaction.getAmount());
        transaction.setTransactionType(TransactionType.DEPOSIT);
        userRepository.EditUserById(user.getMoney(),user.getId());
    }


    public boolean withdrawal(Item item){
        transaction.setTransactionType(TransactionType.WITHDRAWAL);
        if(item.getPrice() > user.getMoney())
            return false;
        else{
            user.setMoney(user.getMoney() - item.getPrice());
            return true;
        }
    }
}
