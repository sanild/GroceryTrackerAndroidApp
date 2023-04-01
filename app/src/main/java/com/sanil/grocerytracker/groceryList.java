package com.sanil.grocerytracker;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;

public class groceryList extends AppCompatActivity {

    ListView listView;
    ArrayList<String> items;
    ArrayAdapter<String> adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_grocery_list);

        listView = findViewById(R.id.listview);
        items = new ArrayList<>();
        items.add("Apples");
        items.add("Banana");
        items.add("Oranges");
        items.add("Watermelon");
        items.add("Mango");
        items.add("Kiwis");

        adapter = new ArrayAdapter<>(getApplicationContext(),android.R.layout.simple_list_item_1,items);
        listView.setAdapter(adapter);
    }
}