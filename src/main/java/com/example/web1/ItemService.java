package com.example.web1;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ItemService {
    private ItemRepository itemRepository;

    @Autowired
    public  ItemService(ItemRepository itemRepository){
        this.itemRepository = itemRepository;
    }

    public Item getItem(long id){
        return itemRepository.findItemById(id);
    }

    public Iterable<Item> getAllItems(){
        return itemRepository.findAll();
    }

    public void save(Item item){
        itemRepository.save(item);
    }
}
