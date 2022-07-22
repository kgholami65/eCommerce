package com.example.web1;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    UserRepository userRepository;
    User user;
    Transaction transaction;


    @Autowired
    public void setUserRepository(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

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
