package com.example.bookreview;

import android.graphics.Bitmap;

import java.util.ArrayList;

public class SearchedBooks {

    ArrayList<Book> bookList = new ArrayList<>();
    public void setBookList(String title, String img){

        bookList.add(new Book(title,img));
    }
    public ArrayList<Book> getBookList(){
        return bookList;
    }
}
