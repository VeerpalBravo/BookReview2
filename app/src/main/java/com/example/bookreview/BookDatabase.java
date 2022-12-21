package com.example.bookreview;

import androidx.room.Database;
import androidx.room.RoomDatabase;

@Database(version = 1,entities = {Book.class})
public abstract class BookDatabase extends RoomDatabase {
    public abstract BookDao getDao();
}
