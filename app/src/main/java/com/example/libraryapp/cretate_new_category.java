package com.example.libraryapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.util.Stack;
import java.util.jar.Attributes;

public class craateNewCatogary extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_craate_new_catogary);

        EditText Category = findViewById(R.id.CategoryName);
        MyDatabase db = new MyDatabase(this);
        Button btn = findViewById(R.id.add_cat);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String name = Category.getText().toString();
                if (name.isEmpty()) {
                    Toast.makeText(getBaseContext(), " Category Name Can't be Empty ", Toast.LENGTH_SHORT).show();
                    return;
                } else {
                    db.insertCategory(name);
                    Toast.makeText(getBaseContext(), "Category Created ", Toast.LENGTH_SHORT).show();
                    Intent intent = new Intent(getApplicationContext(), MainActivity.class);
                    startActivity(intent);
                }

            }
        });


    }
}