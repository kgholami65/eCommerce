package com.example.web1;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.Optional;
@Repository
public interface UserRepository extends CrudRepository<User,Long> {
    boolean existsUserByPassword(String password);
    boolean existsUserByName(String name);
    User getUserByPassword(String password);
}
