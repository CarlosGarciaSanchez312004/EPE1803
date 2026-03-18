package org.example.ejerciciomongospringboot.controllers;

import org.example.ejerciciomongospringboot.entities.Item;
import org.example.ejerciciomongospringboot.services.ItemService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class ItemController {
    private final ItemService itemService;

    public ItemController(ItemService itemService) {
        this.itemService = itemService;
    }

    @GetMapping("/items")
    public List<Item> findAll() {
        return itemService.findAll();
    }

    @PostMapping("/items")
    public ResponseEntity<Item> save(@RequestBody Item item) {
        Item saved = itemService.save(item);
        return ResponseEntity.ok(saved);
    }

    @DeleteMapping("/items/{id}")
    public ResponseEntity<Void> deleteItemById(@PathVariable int id) {
        itemService.deleteItemById(id);
        return ResponseEntity.noContent().build();

    }
    @GetMapping("/items/{id}")
    public Item findOne(@PathVariable int id) {
        return  itemService.findById(id);
    }

}
