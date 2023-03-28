package com.example.managelibrary;

import static com.example.managelibrary.BookRecViewAdapter.BOOK_ID_KEY;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;

import java.util.ArrayList;

public class BookActivity extends AppCompatActivity {
    private TextView txtAuthor,txtBookName,txtPages,txtDesc;
    private Button btnAlreadyReading,btnWantToRead,btnFavorite,btnCurrentlyReading;
    private ImageView imageBook;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_book);
        initViews();
        //TODO Get the data from the recycler view


        Intent intent =getIntent();
        if (null != intent){
            int bookId=intent.getIntExtra(BOOK_ID_KEY,-1);
            if (bookId != -1){
                Book incomingBook=Utils.getInstance().getBookById(bookId);
                if (null != incomingBook){
                    setData(incomingBook);
                    handleAlreadyRead(incomingBook);
                    handleWantToReadBook(incomingBook);
                    handleFavoriteBook(incomingBook);
                    handleCurrentlyReadingBook(incomingBook);
                }
            }
        }
    }



    private void setData(Book book){
        txtBookName.setText(book.getName());
        txtAuthor.setText(book.getAuthor());
        txtPages.setText(String.valueOf(book.getPages()));
        txtDesc.setText(book.getLongDesc());
        Glide.with(this)
                .asBitmap().load(book.getImageUrl())
                .into(imageBook);
    }

    private void initViews() {
        txtAuthor=findViewById(R.id.txtAuthorName);
        txtBookName=findViewById(R.id.txtBookName);
        txtPages=findViewById(R.id.txtPages);
        txtDesc=findViewById(R.id.txtBookDesc);

        btnAlreadyReading=findViewById(R.id.btnBookAlradyRead);
        btnCurrentlyReading=findViewById(R.id.btnBookCurrentlyReading);
        btnFavorite=findViewById(R.id.btnBookFavorite);
        btnWantToRead=findViewById(R.id.btnBookWantToRead);

        imageBook=findViewById(R.id.imageBook);
    }


    private void handleAlreadyRead(Book book){
        ArrayList<Book> alreadyReadBook = Utils.getInstance().getAlreadyReadBook();
        boolean existAlreadyReadBook =false;
        for (Book b : alreadyReadBook){
            if (b.getId()==book.getId()){
                existAlreadyReadBook=true;
            }
        }
        if (existAlreadyReadBook){
            btnAlreadyReading.setEnabled(false);
        }else{
            btnAlreadyReading.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if (Utils.getInstance().addToAlreadyRead(book)){
                        Toast.makeText(BookActivity.this, "Added to already Read book array list ", Toast.LENGTH_SHORT).show();
                        Intent intent = new Intent(BookActivity.this,AlreadyReadBookActivity.class);
                        startActivity(intent);
                    }else {
                        Toast.makeText(BookActivity.this, "Something wrong happen", Toast.LENGTH_SHORT).show();
                    }
                }
            });
        }
    }

    private void handleCurrentlyReadingBook(Book incomingBook) {
        ArrayList<Book> currentlyReadingBook = Utils.getInstance().getCurrentlyReadBook();
        boolean existCurrentlyReadingBook =false;
        for (Book b : currentlyReadingBook){
            if (b.getId()==incomingBook.getId()){
                existCurrentlyReadingBook=true;
            }
        }
        if (existCurrentlyReadingBook){
            btnCurrentlyReading.setEnabled(false);
        }else{
            btnCurrentlyReading.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if (Utils.getInstance().addToCurretlyReadingBook(incomingBook)){
                        Toast.makeText(BookActivity.this, "Added to currenttly Read book array list ", Toast.LENGTH_SHORT).show();
                        Intent intent = new Intent(BookActivity.this,CurrentlyReadingBookActivity.class);
                        startActivity(intent);
                    }else {
                        Toast.makeText(BookActivity.this, "Something wrong happen", Toast.LENGTH_SHORT).show();
                    }
                }
            });
        }
    }

    private void handleFavoriteBook(Book incomingBook) {
        ArrayList<Book> favoriteBooks = Utils.getInstance().getFavoriteBook();
        boolean existFavorite =false;
        for (Book b : favoriteBooks){
            if (b.getId()==incomingBook.getId()){
                existFavorite=true;
            }
        }
        if (existFavorite){
            btnFavorite.setEnabled(false);
        }else{
            btnFavorite.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if (Utils.getInstance().addToFavorite(incomingBook)){
                        Toast.makeText(BookActivity.this, "Added to currenttly Read book array list ", Toast.LENGTH_SHORT).show();
                        Intent intent = new Intent(BookActivity.this,FavoriteActivity.class);
                        startActivity(intent);
                    }else {
                        Toast.makeText(BookActivity.this, "Something wrong happen", Toast.LENGTH_SHORT).show();
                    }
                }
            });
        }
    }

    private void handleWantToReadBook(Book incomingBook) {
        ArrayList<Book> wantToReadBooks = Utils.getInstance().getWantToReadBook();
        boolean existWantToRead =false;
        for (Book b : wantToReadBooks){
            if (b.getId()==incomingBook.getId()){
                existWantToRead=true;
            }
        }
        if (existWantToRead){
             btnWantToRead.setEnabled(false);
        }else{
            btnWantToRead.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if (Utils.getInstance().addToWantToRead(incomingBook)){
                        Toast.makeText(BookActivity.this, "Added to currenttly Read book array list ", Toast.LENGTH_SHORT).show();
                        Intent intent = new Intent(BookActivity.this,WantToReadActivity.class);
                        startActivity(intent);
                    }else {
                        Toast.makeText(BookActivity.this, "Something wrong happen", Toast.LENGTH_SHORT).show();
                    }
                }
            });
        }
    }
}