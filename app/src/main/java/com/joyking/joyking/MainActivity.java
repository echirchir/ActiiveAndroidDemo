package com.joyking.joyking;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

import com.joyking.joyking.models.Item;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private List<Item> allItems = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        /* Here you can add to your db and later query the database for your data */

        initDB();

        allItems = Item.fetchAll();

        if (allItems.size() != 0){
            /* perhaps add to your adapter here to display in the view as expected */
            for (Item i : allItems){
            /* do whatever you need with your data here */
                Toast.makeText(this, i.name, Toast.LENGTH_LONG).show();
            }
        }
    }

    /* Here, you can add all your data from your array inside your strings.xml file */
    private void initDB(){
        Item item = new Item("Pepsi", 2.99, "Drink");
        item.save();
        Item item2 = new Item("Cake", 12.99, "Food");
        item2.save();
        Item item3 = new Item("Toyota", 2099, "Automobile");
        item3.save();
        Item item4 = new Item("Pen", 2.99, "Stationary");
        item4.save();
    }

    /* In a NUTSHELL */
    /*
    * ADD THE COMPILE LINE TO BUILD,GRADLE FILE AS I DID BELOW; THEN
    * YOU INITIALIZE YOUR ANDROID MANIFEST FILE AS I DID
    * THEN EXTEND ACTIVE ANDROID APPLICATION IN YOUR APPLICATION SUBCLASS
    * CREATE YOUR MODEL CLASS AND SPECIFY A TABLE NAME AS SHOWN IN THE ITEMS CLASS
    * ADD COLUMNS YOU WANT; YOU CAN ALSO ADD RELATIONSHIPS TO OTHER TABLES/MODELS
    * ADD AN EMPTY REQUIRED CONSTRUCTOR, WITH A CALL TO SUPER() METHOD
    * ADD A NON-EMPTY CONSTRUCTOR IF YOU WANT OR JUST USE SETTERS AND GETTERS METHODS
    * ADD OPERATION METHODS LIKE THOSE USED TO FETCH ALL DATA, FETCH BY ID, DELETE, TRUNCATE TABLE ETC
    * IN YOUR OTHER PARTS OF THE CODE, YOU SIMPLE CREATE INSTANCES OF YOUR MODELS, SET THE VALUES AND SAVE
    * THAT IS VERY STRAIGHT-FORWARD
    * THEN TO QUERY THE DATA, YOU SIMPLY USE THE STATIC METHODS YOU WROTE INSIDE YOUR MODEL TO FETCH ALL
    * OR FETCH BY ID AND STORE THEM IN YOUR ARRAY LIST IN YOUR ACTIVITY OR FRAGMENT CLASS!
    *
    * THIS WILL MAKE YOUR LIFE SO MUCH EASIER THAN USING PLAIN OLD SQLITE DATABASE FOR ANDROID
    * ESPECIALLY WORRY ABOUT MAINTENANCE AND EVERYTHING THAT GOES WITH DATABASES;
    *
    * */

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

}
