package com.example.managelibrary;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {
    private Button btnAllBooks,btnCurrentlyRead,btnAlreadyRead,btnWantToRead,btnFavorite,btnAbout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initViews();

        btnAllBooks.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(MainActivity.this,AllBooksActivity.class);
                startActivity(intent);
            }
        });
    }

    private void initViews() {
        btnAllBooks=findViewById(R.id.btnAllBooks);
        btnCurrentlyRead=findViewById(R.id.btnCurrentlyReading);
        btnAlreadyRead=findViewById(R.id.btnAlreadyRead);
        btnWantToRead=findViewById(R.id.btnWantToRead);
        btnFavorite=findViewById(R.id.btnFavorite);
        btnAbout=findViewById(R.id.btnAbout);
    }
}