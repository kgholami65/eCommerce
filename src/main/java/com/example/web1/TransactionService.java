package com.example.web1;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.util.Date;

@Service
public class TransactionService {
    private User user;
    private Transaction transaction;
    @Autowired
    private TransactionRepository transactionRepository;
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private ItemRepository itemRepository;




    public void setUser(User user) {
        this.user = user;
    }

    public void deposit(double money){
        user.setMoney(user.getMoney() + money);
        userRepository.EditUserByName(user.getMoney(),user.getName());
        transactionRepository.save(new Transaction(TransactionType.DEPOSIT,money,user) );
    }


    public boolean withdrawal(Item item){
        if(item.getPrice() > user.getMoney())
            return false;
        else{
            user.setMoney(user.getMoney() - item.getPrice());
            userRepository.EditUserByName(user.getMoney(),user.getName());
            transactionRepository.save(new Transaction(TransactionType.WITHDRAWAL, item.getPrice(), user));
            itemRepository.delete(item);
            return true;
        }
    }

    public Iterable<Transaction> getAllTransactions(){
        return transactionRepository.findAllByUser(user);
    }
}
