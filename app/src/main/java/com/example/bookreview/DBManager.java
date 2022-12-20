package com.example.bookreview;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;

import androidx.room.Room;

import java.util.ArrayList;

public class DBManager {
    interface DataBaseListener{
        void insertingCommentsCompleted();
        void gettingCommentsCompleted(Comments[] list);
    }

    DataBaseListener listener;

    CommentsDatabase commentsDB;
    Handler dbHandler = new Handler(Looper.getMainLooper());

    CommentsDatabase getDB(Context context){
        if (commentsDB == null)
            commentsDB = Room.databaseBuilder(context,CommentsDatabase.class,"comments_db").build();

        return commentsDB;
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

    void getAllComments(String bookID){
        MyApp.executorService.execute(new Runnable() {
            @Override
            public void run() {
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
}
