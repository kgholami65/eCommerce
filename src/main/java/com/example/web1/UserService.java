package com.example.web1;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.stereotype.Service;
import org.springframework.web.context.WebApplicationContext;

@Service
//@Scope(value = WebApplicationContext.SCOPE_SESSION,proxyMode = ScopedProxyMode.TARGET_CLASS)
public class UserService {
    @Autowired
    UserRepository userRepository;
    User user;
    Transaction transaction;


    public User getUser() {
        return user;
    }

    public User Showuser(){
        return userRepository.findUserById(user.getId());
    }


    public void setUserByPassword(String password){
        this.user = userRepository.getUserByPassword(password);
    }


    public void EditUserByPassword(String password,String name){
        userRepository.EditUserByPassword(password,name);
        user.setName(name);
    }

}
