package com.example.web1;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
@Transactional
public interface UserRepository extends CrudRepository<User,Long> {
    boolean existsUserByPassword(String password);
    boolean existsUserByName(String name);
    User getUserByPassword(String password);
    User findUserById(Long id);
    @Modifying
    @Query("UPDATE User u SET u.name = :name WHERE u.password = :password")
    int EditUserByPassword(@Param(value = "password") String password,@Param("name") String name);

    @Modifying
    @Query("UPDATE User u SET u.money = :money WHERE u.name = :name")
    void EditUserByName(@Param(value = "money") double money,@Param("name") String name);
}
