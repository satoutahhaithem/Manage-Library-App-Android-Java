package com.example.managelibrary;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
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
        booksRecView.setLayoutManager(new GridLayoutManager(this,2));
        ArrayList<Book> books = new ArrayList<>();
        books.add(new Book(1,"Secret","Author",1350,"https://m.media-amazon.com/images/I/81lA9fSZMZL._CR0,204,1224,1224_UX256.jpg","My short Des","My Long desc"));
        adapter.setBooks(books);
    }
}