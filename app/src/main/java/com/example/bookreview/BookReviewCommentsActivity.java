package com.example.bookreview;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;

import java.util.ArrayList;
import java.util.Arrays;

public class BookReviewCommentsActivity extends AppCompatActivity implements
        DBManager.DataBaseListener, BookReviewRecyclerView.ItemClickListener{

    RecyclerView commentList;
    BookReviewRecyclerView adapter;
    ArrayList<Comments> clist = new ArrayList<>(0);
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_book_review_comments);
        int pos = ((MyApp) getApplication()).pos;
        setTitle("Comments for Book: "+((MyApp)getApplication()).sb.getFullDescBookList().
                get(pos).getTitle());
        String bookID=((MyApp)getApplication()).sb.getFullDescBookList().get(pos).getId();
        commentList = findViewById(R.id.comment_list);
        ((MyApp)getApplication()).db.getAllComments(bookID);
        adapter = new BookReviewRecyclerView(clist,this);
        commentList.setAdapter(adapter);
        adapter.listener=this;
        LinearLayoutManager linearLayoutManager=new LinearLayoutManager(this);
        commentList.setLayoutManager(linearLayoutManager);
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
        clist = new ArrayList( Arrays.asList(list));
        adapter.comment_list = clist;
        adapter.notifyDataSetChanged();

    }

    @Override
    public void insertingBooksCompleted() {

    }

    @Override
    public void gettingFavBooksCompleted(Book[] list) {

    }

    @Override
    public void onItemClick(int pos) {

    }
}