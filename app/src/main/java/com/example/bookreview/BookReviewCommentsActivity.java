package com.example.bookreview;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;

import java.util.ArrayList;
import java.util.Arrays;

public class BookReviewCommentsActivity extends AppCompatActivity implements
        DBManager.DataBaseListener{

    RecyclerView commentList;
    BookReviewRecyclerView adapter;
    ArrayList<Comments> clist;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_book_review_comments);
        int pos = ((MyApp) getApplication()).pos;
        setTitle("Comments for Book: "+((MyApp)getApplication()).sb.getFullDescBookList().
                get(pos).getTitle());
        String bookID=((MyApp)getApplication()).sb.getFullDescBookList().get(pos).getId();
        commentList = findViewById(R.id.comment_list);
        adapter = new BookReviewRecyclerView(clist,this);
    }
    @Override
    protected void onResume() {
        super.onResume();
        ((MyApp)getApplication()).db.listener=this;
        ((MyApp)getApplication()).db.getDB(BookReviewCommentsActivity.this);
    }

    @Override
    public void insertingCommentsCompleted() {

    }

    @Override
    public void gettingCommentsCompleted(Comments[] list) {
        ArrayList<Comments> clist = new ArrayList( Arrays.asList(list));

    }
}