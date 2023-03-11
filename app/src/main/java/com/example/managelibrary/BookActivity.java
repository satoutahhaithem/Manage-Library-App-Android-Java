package com.example.managelibrary;

import static com.example.managelibrary.BookRecViewAdapter.BOOK_ID_KEY;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

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
}