package org.example.ejerciciomongospringboot.repositories;

import org.bson.types.ObjectId;
import org.example.ejerciciomongospringboot.entities.Item;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface ItemRepository extends MongoRepository<Item, ObjectId> {
    Item findItemById(int id);
    List<Item> findByCategory(String category);
}
