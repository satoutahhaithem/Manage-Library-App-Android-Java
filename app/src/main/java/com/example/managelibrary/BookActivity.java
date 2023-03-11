package com.example.managelibrary;

import androidx.appcompat.app.AppCompatActivity;

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
        Book book=new Book(1,"Secret","Jhon Smith",1350,
                "https://m.media-amazon.com/images/I/81lA9fSZMZL._CR0,204,1224,1224_UX256.jpg",
                "My short Des of the secret ","My Long desc of the secret" +
                "____________________________________________________________________" +
                "______________________________________________________________________" +
                "________________________________________________________________________" +
                "aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa" +
                "bbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbb" +
                "cccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccc" +
                "ddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddd");
        setData(book);
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