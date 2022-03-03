package com.example.libraryapp;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.Toast;

import java.util.ArrayList;

import de.hdodenhof.circleimageview.CircleImageView;

public class Add_New_Book extends AppCompatActivity {
    CircleImageView img;
    Button create;
    EditText name, author, release, pages;
    ImageView image;
    Spinner spinner;
    Uri uri;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_addnewbook);
        create = findViewById(R.id.btn2);
        img = findViewById(R.id.img2);
        image = findViewById(R.id.img2);
        name = findViewById(R.id.name);
        author = findViewById(R.id.author);
        release = findViewById(R.id.release);
        pages = findViewById(R.id.page);
        spinner = findViewById(R.id.Spinner);

        MyDatabase db = new MyDatabase(this);
        ArrayList<Category> category = db.getAllCategory();
        ArrayList<String> categories = new ArrayList<>();
        for (int i = 0; i < category.size(); i++) {
            String name = category.get(i).getName();
            categories.add(i, name);
        }


        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, categories);
        spinner.setAdapter(adapter);


        create.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String image = String.valueOf(uri);
                int sp = spinner.getSelectedItemPosition()+1 ;
                String nameBook = name.getText().toString();
                String nameAuthor = author.getText().toString();
                String rel = release.getText().toString();
                String page = pages.getText().toString();
                book book = new book(image ,nameBook,nameAuthor,rel ,page ,sp);
                if (nameBook == null) {
                    Toast.makeText(getBaseContext(), " Invalid Book Name ", Toast.LENGTH_LONG).show();
                } else if (nameAuthor.isEmpty()) {
                    Toast.makeText(getBaseContext(), " Invalid Author Name ", Toast.LENGTH_LONG).show();
                } else if (rel == null) {
                    Toast.makeText(getBaseContext(), " Invalid Release Year ", Toast.LENGTH_LONG).show();
                } else if (page == null) {
                    Toast.makeText(getBaseContext(), " Invalid Pages Number ", Toast.LENGTH_LONG).show();
                } else if (uri == null) {
                    Toast.makeText(getBaseContext(), " Invalid Image , Please select valid image ", Toast.LENGTH_LONG).show();
                } else {
                    db.addBook(book);
                    Intent intent = new Intent(getBaseContext(), MainActivity.class);
                    startActivity(intent);
                }
            }

        });


    }


    public void pick_photo(View view) {
        Intent i = new Intent(Intent.ACTION_PICK,
                MediaStore.Images.Media.INTERNAL_CONTENT_URI);
        startActivityForResult(i, 100);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == 100 && resultCode == RESULT_OK) {
            uri = data.getData();
            img.setImageURI(uri);
        } else {
            Toast.makeText(this, "invalid image , please select valid image", Toast.LENGTH_SHORT).show();
        }
    }
}








