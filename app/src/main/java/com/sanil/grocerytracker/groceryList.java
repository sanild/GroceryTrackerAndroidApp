package com.sanil.grocerytracker;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

public class groceryList extends AppCompatActivity {

    static ListView listView;
    static ArrayList<String> items;
    static ListViewAdapter adapter;
    EditText input;
    ImageView enter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_grocery_list);

        listView = findViewById(R.id.listview);
        items = new ArrayList<>();
        input = findViewById(R.id.input);
        enter = findViewById(R.id.add);

        items.add("Apples");
        items.add("Banana");
        items.add("Oranges");
        items.add("Watermelon");
        items.add("Mango");
        items.add("Kiwis");

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                String name = items.get(i);
                makeToast(name);
            }
        });

        listView.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> adapterView, View view, int i, long l) {
               makeToast("Removed:" + items.get(i));
               removeItem(i);
                return false;
            }
        });

        adapter = new ListViewAdapter(getApplicationContext(),items);
        listView.setAdapter(adapter);

        enter.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String text = input.getText().toString();
                if(text == null || text.length() ==0){
                    makeToast("Enter an item");
                }else{
                    addItem(text);
                    input.setText("");
                    makeToast("Added:"+text);
                }
            }
        });
        }

    public static void addItem(String item){
        items.add(item);
        adapter.notifyDataSetChanged();
    }

    public static void removeItem(int remove){
        items.remove(remove);
        adapter.notifyDataSetChanged();
    }
    Toast t;

    private void makeToast(String s){
        if (t!=null) t.cancel();
        t = Toast.makeText(getApplicationContext(),s,Toast.LENGTH_SHORT);
        t.show();
    }
}