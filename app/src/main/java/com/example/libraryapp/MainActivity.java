package com.example.libraryapp;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    // ريكويست كود عشان لما يظهرلي شااشة الصلاحية يعرف يرجع ع نفس الشاشة
    public static final int WRITE_EX_REQ_CODE = 1 ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        CardView cv1 = findViewById(R.id.cv1) ;
        CardView cv2 = findViewById(R.id.cv2) ;
        CardView cv3 = findViewById(R.id.cv3) ;
        CardView cv4 = findViewById(R.id.cv4) ;

        // بدي افحص هل تم اخذ الصلاحية و لا لا
        if(ContextCompat.checkSelfPermission(this , Manifest.permission
                .WRITE_EXTERNAL_STORAGE) != PackageManager.PERMISSION_GRANTED) {
            // الصلاحية لم يتم الحصور عليها
            ActivityCompat.requestPermissions(this , new String[]{Manifest.permission
                    .WRITE_EXTERNAL_STORAGE} , WRITE_EX_REQ_CODE);
        }
        else {
            // الصلاحية تم الحصول عليها

        }



        cv1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(MainActivity.this , Library.class);
                startActivity(i);
            }
        });

        cv2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(MainActivity.this , Favorites.class);
                startActivity(i);
            }
        });

        cv3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(MainActivity.this , addnewbook.class);
                startActivity(i);
            }
        });

        cv4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(MainActivity.this , craateNewCatogary.class);
                startActivity(i);
            }
        });

    }


    // يتم استداعائها عند الضغط على مربع الحوار سواء سماح او رفض
    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        switch (requestCode) {
            case WRITE_EX_REQ_CODE:
                if (grantResults.length>0 && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                    Toast.makeText(this, " تم الحصول على الصلاحية", Toast.LENGTH_SHORT).show();
                }
                return;
        }

    }
}