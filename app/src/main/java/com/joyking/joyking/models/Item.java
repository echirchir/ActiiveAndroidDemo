package com.joyking.joyking.models;

import com.activeandroid.Model;
import com.activeandroid.annotation.Column;
import com.activeandroid.annotation.Table;
import com.activeandroid.query.Select;

import java.util.List;

/*
* This class could be anything you want to represent
* In your database; it is clearly a model to use in your db
* In ActiveAndroid, each model subclass maps to a table like this
*/

@Table(name = "items")
public class Item extends Model {

    /* Now add your columns like this; primary ids are automatic here */
    @Column(name = "Name")
    public String name;

    @Column(name = "Price")
    public double price;

    @Column(name = "Type")
    public String type;


    /* required empty constructor */
    public Item(){
        super();
    }

    /* non-empty constructor */
    public Item(String name, double price, String type){
        this.name = name;
        this.price = price;
        this.type = type;
    }

    /* It is also a good idea to add static methods here to query your database for the data */
    public static List<Item> fetchAll(){
        return new Select()
                .from(Item.class)
                .execute();

    }

    public static Item getItemById(long id){
        return new Select()
                .from(Item.class)
                .where("id = ?", id)
                .executeSingle();
    }

    public static Item getRandom() {
        return new Select().from(Item.class).orderBy("RANDOM()").executeSingle();
    }

}
