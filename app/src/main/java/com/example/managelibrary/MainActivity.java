package com.example.managelibrary;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.webkit.WebView;
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
        btnAlreadyRead.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this,AlreadyReadBookActivity.class);
                startActivity(intent);
            }
        });
        btnCurrentlyRead.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent =new Intent(MainActivity.this,CurrentlyReadingBookActivity.class);
                startActivity(intent);
            }
        });
        btnWantToRead.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent =new Intent (MainActivity.this,WantToReadActivity.class);
                startActivity(intent);
            }
        });
        btnFavorite.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this,FavoriteActivity.class);
                startActivity(intent);
            }
        });
        btnAbout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);
                builder.setTitle(getString(R.string.app_name));
                builder.setMessage("This Application is developed by Haithem Satoutah i wish it help you if interest of mobile developement");
                builder.setNegativeButton("Dismiss", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {

                    }
                });
                builder.setPositiveButton("Visit", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        //Todo naviagte the user to website
                        Intent intent = new Intent(MainActivity.this , WebSiteActivity.class);
                        intent.putExtra("url","https://google.com");
                        startActivity(intent);
                    }
                });
                builder.create().show();
            }
        });
        Utils.getInstance();
    }

    private void initViews() {
        btnAllBooks=findViewById(R.id.btnAllBooks);
        btnCurrentlyRead=findViewById(R.id.btnBookCurrentlyReading);
        btnAlreadyRead=findViewById(R.id.btnAlreadyRead);
        btnWantToRead=findViewById(R.id.btnBookWantToRead);
        btnFavorite=findViewById(R.id.btnFavorite);
        btnAbout=findViewById(R.id.btnAbout);
    }
}