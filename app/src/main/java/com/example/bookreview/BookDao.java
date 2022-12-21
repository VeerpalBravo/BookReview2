package com.example.bookreview;

import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;

@Dao
public interface BookDao {
    @Insert
    public void insertFavBook(Book book);
    @Query("Select title,thumbnail from book")
    public Book[] getAllFavBooks();
}
