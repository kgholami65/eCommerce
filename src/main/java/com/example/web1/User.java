package com.example.web1;

import org.springframework.boot.WebApplicationType;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.context.WebApplicationContext;

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
    public User(String name,String password,Date date){
        this.name = name;
        this.password = password;
        this.date = date;
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
}
