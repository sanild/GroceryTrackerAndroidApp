package com.sanil.grocerytracker;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        TextView myTextView = findViewById(R.id.sign_up_text);
        Button sign_in_btn = findViewById(R.id.sign_in_button);

        myTextView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, sign_up_page.class);
                startActivity(intent);
            }
        });

        sign_in_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                EditText edittext_email = findViewById(R.id.editTextTextEmailAddress);
                String email = edittext_email.getText().toString();
                EditText edittext_password = findViewById(R.id.editTextTextPassword);
                String password = edittext_password.getText().toString();

//                if (email.equals("sanildhamija@gmail.com") && password.equals("nahibataunga")){
//                    Intent intent = new Intent(MainActivity.this, groceryList.class);
//                    startActivity(intent);
//                }
                Intent intent = new Intent(MainActivity.this, groceryList.class);
                 startActivity(intent);



            }
        });

    }
}