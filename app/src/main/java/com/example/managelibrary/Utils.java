package com.example.managelibrary;

import java.util.ArrayList;

public class Utils {

    private static Utils instance;

    private static ArrayList<Book> allBooks;
    private static ArrayList<Book> currentlyReadBook;
    private static ArrayList<Book> wantToReadBook;
    private static ArrayList<Book> favoriteBook;
    private static ArrayList<Book> alreadyReadingBook;

    private Utils() {
        if (null==allBooks){
            allBooks=new ArrayList<>();
            initData();
        }
        if (null==currentlyReadBook){
            currentlyReadBook=new ArrayList<>();

        }
         if (null==favoriteBook){
             favoriteBook=new ArrayList<>();

        }
         if (null==wantToReadBook){
            wantToReadBook=new ArrayList<>();

        }
         if (null==alreadyReadingBook){
            alreadyReadingBook=new ArrayList<>();

        }
    }

    private void initData() {
        //TODO add initial data
        allBooks.add(new Book(1,"Secret","Jhon Smith",1350,"https://m.media-amazon.com/images/I/81lA9fSZMZL._CR0,204,1224,1224_UX256.jpg","My short Des of the secret ","My Long desc of the secret"));
        allBooks.add(new Book(2,"Harry Potter","Jhonny Dib",1350,"https://i.pinimg.com/474x/7e/79/1d/7e791da660ab1d2c7b2f5c4039d4d54c.jpg","My short Des of harry potter","My Long desc of harry potter"));

    }

    public static Utils getInstance() {
        if (null != instance){
            return instance;
        }else {
            instance = new Utils();
            return instance;
        }
    }

    public static ArrayList<Book> getAllBooks() {
        return allBooks;
    }

    public static ArrayList<Book> getCurrentlyReadBook() {
        return currentlyReadBook;
    }

    public static ArrayList<Book> getWantToReadBook() {
        return wantToReadBook;
    }

    public static ArrayList<Book> getFavoriteBook() {
        return favoriteBook;
    }

    public static ArrayList<Book> getAlreadyReadingBook() {
        return alreadyReadingBook;
    }

    public Book getBookById(int id){
        for (Book b : allBooks){
            if (b.getId()==id){
                return b;
            }
        }
        return null;
    }
}
