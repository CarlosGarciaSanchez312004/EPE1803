package org.example.ejerciciomongospringboot.services;

import org.example.ejerciciomongospringboot.entities.Item;
import org.example.ejerciciomongospringboot.repositories.ItemRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ItemService {
    private final ItemRepository itemRepository;
    public ItemService(ItemRepository itemRepository) {
        this.itemRepository = itemRepository;
    }

    public Item save(Item item){
        return itemRepository.save(item);
    }

    public void deleteItemById(int id){
        Item item = findById(id);
        itemRepository.delete(item);
    }

    public Item findById(int id){
        return itemRepository.findItemById(id);
    }
    public List<Item> findByCategory(String category){
        return itemRepository.findByCategory(category);
    }
    public  List<Item> findAll(){
        return itemRepository.findAll();
    }
}
