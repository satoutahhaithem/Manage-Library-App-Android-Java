package com.example.managelibrary;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import java.util.ArrayList;

public class AllBooksActivity extends AppCompatActivity {
    private RecyclerView booksRecView;
    private BookRecViewAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_all_books);

        booksRecView =findViewById(R.id.booksRecyclerView);
        adapter=new BookRecViewAdapter(this);
        booksRecView.setAdapter(adapter);
        booksRecView.setLayoutManager(new LinearLayoutManager(this ));
        ArrayList<Book> books = new ArrayList<>();
        books.add(new Book(1,"Secret","Jhon Smith",1350,"https://m.media-amazon.com/images/I/81lA9fSZMZL._CR0,204,1224,1224_UX256.jpg","My short Des of the secret ","My Long desc of the secret"));
        books.add(new Book(2,"Harry Potter","Jhonny Dib",1350,"http://prodimage.images-bn.com/pimages/9780545139700_p0_v5_s1200x630.jpg","My short Des of harry potter","My Long desc of harry potter"));
        adapter.setBooks(books);
    }
}