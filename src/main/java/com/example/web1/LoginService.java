package com.example.web1;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.Date;

@Service
public class LoginService {
    @Autowired
    UserRepository userRepository;
    public boolean ValidateUser(String password, String name){
        return userRepository.existsUserByPassword(password) && userRepository.existsUserByName(name);
    }
    public void AddUser(String name, String password, Date date){
        userRepository.save(new User(name,password,date, 0));
    }
}
