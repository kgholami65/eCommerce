package com.example.web1;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.stereotype.Service;
import org.springframework.web.context.WebApplicationContext;

@Service
@Scope(value = WebApplicationContext.SCOPE_SESSION,proxyMode = ScopedProxyMode.TARGET_CLASS)
public class UserService {
    UserRepository userRepository;
    User user;
    Transaction transaction;

    @Autowired
    public UserService(UserRepository userRepository,User user,Transaction transaction){
        this.user = user;
        this.userRepository = userRepository;
        this.transaction = transaction;
    }

    public String Showuser(){
        return String.format("%s",user.getName());
    }
    public void setUserByPassword(String password){
        this.user = userRepository.getUserByPassword(password);
    }
    public void EditUserByPassword(String password,String name){
        userRepository.EditUserByPassword(password,name);
        user = new User(name,password,user.getDate(), user.getMoney());
    }

}
