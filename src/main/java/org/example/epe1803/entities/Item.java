package org.example.ejerciciomongospringboot.entities;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

@Data
@NoArgsConstructor
@Document(collection = "items")
public class Item {
    @Id
    private ObjectId _id;
    @Field("id")
    private int id;
    @Field("title")
    private String title;
    @Field("price")
    private double price;
    @Field("category")
    private String category;
    @Field("description")
    private String description;
    @Field("rate")
    private double rate;
    @Field("count")
    private int count;
    @Field("color")
    private String color;
    @Field("manufacturer")
    private String manufacturer;
    @Field("EAN")
    private String EAN;
    @Field("image")
    private String image;
}
