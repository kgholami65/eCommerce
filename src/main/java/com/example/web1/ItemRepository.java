package com.example.web1;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ItemRepository extends CrudRepository<Item,Long> {

    Item findItemById(long id);

    Iterable<Item> findAll();
}
