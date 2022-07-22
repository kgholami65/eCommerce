package com.example.web1;

import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.context.WebApplicationContext;

import javax.persistence.*;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

@Entity
@Transactional
@Scope(value = WebApplicationContext.SCOPE_SESSION,proxyMode = ScopedProxyMode.TARGET_CLASS)
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column
    private Long id;
    @Column(unique = true)
    private String name;
    private String password;
    private Date date;
    private double money;
    @OneToMany(mappedBy = "user")
    private Set<Transaction> transactions = new HashSet<>();


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
