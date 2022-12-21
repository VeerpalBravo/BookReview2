package com.example.bookreview;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.util.Log;

import androidx.room.Room;

import java.util.ArrayList;

public class DBManager {
    public interface DataBaseListener{
        void insertingCommentsCompleted();
        void gettingCommentsCompleted(Comments[] list);
        void insertingBooksCompleted();
        void gettingFavBooksCompleted(Book[] list);
    }

    DataBaseListener listener;

    CommentsDatabase commentsDB;
    BookDatabase bookDB;
    Handler dbHandler = new Handler(Looper.getMainLooper());

    CommentsDatabase getDB(Context context){
        if (commentsDB == null)
            commentsDB = Room.databaseBuilder(context,CommentsDatabase.class,"comments_db").build();

        return commentsDB;
    }
    BookDatabase getBookDB(Context context){
        if (bookDB == null)
            bookDB = Room.databaseBuilder(context,BookDatabase.class,"book_db").build();

        return bookDB;
    }

    void insertNewCommentAsync(Comments comments){

        MyApp.executorService.execute(new Runnable() {
            @Override
            public void run() {
                commentsDB.getDao().addComment(comments);
                dbHandler.post(new Runnable() {
                    @Override
                    public void run() {
                        // notify main thread
                        listener.insertingCommentsCompleted();
                    }
                });
            }
        });
    }

    void insertNewFavBookAsync(Book book){

        MyApp.executorService.execute(new Runnable() {
            @Override
            public void run() {
                bookDB.getDao().insertFavBook(book);
                dbHandler.post(new Runnable() {
                    @Override
                    public void run() {
                        // notify main thread
                        listener.insertingBooksCompleted();
                    }
                });
            }
        });
    }

    void getAllComments(String bookID){
        MyApp.executorService.execute(new Runnable() {
            @Override
            public void run() {
                Log.d("bookID: ",bookID);
                Comments[] list = commentsDB.getDao().getAllComments(bookID);
                dbHandler.post(new Runnable() {
                    @Override
                    public void run() {
                        // notify main thread
                        listener.gettingCommentsCompleted(list);
                    }
                });
            }
        });
    }

    public void getAllFavBooks(){
        MyApp.executorService.execute(new Runnable() {
            @Override
            public void run() {
                Book[] list = bookDB.getDao().getAllFavBooks();
                dbHandler.post(new Runnable() {
                    @Override
                    public void run() {
                        // notify main thread
                        listener.gettingFavBooksCompleted(list);
                    }
                });
            }
        });
    }
}
