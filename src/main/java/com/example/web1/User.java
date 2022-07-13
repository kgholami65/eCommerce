package com.example.web1;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.*;
import java.util.Date;

@Entity
@Repository
@Transactional
//@Scope(value = WebApplicationContext.SCOPE_SESSION,proxyMode = ScopedProxyMode.TARGET_CLASS)
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @Column(unique = true)
    private String name;
    @Column(unique = true)
    private String password;
    private Date date;
    private double money;
    public User(String name, String password, Date date, double money){
        this.name = name;
        this.password = password;
        this.date = date;
        this.money = money;
    }

    public User() {}


    public Long getId() {
        return id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getName(){
        return name;
    }
    public String getPassword(){
        return password;
    }
    public Date getDate(){
        return date;
    }

    public double getMoney() {
        return money;
    }
    public void setMoney(double money){
        this.money = money;
    }
}
