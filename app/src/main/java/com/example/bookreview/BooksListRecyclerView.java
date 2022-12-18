package com.example.bookreview;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.util.Log;

public class BooksListRecyclerView extends AppCompatActivity implements NetworkingServiceForBooks.NetworkingListener,
        BookInfoRecyclerView.ItemClickListener {

    RecyclerView bookList;
    BookInfoRecyclerView adapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_books_list_recycler_view);
        ((MyApp)getApplication()).networkingServiceForBooks.listener=this;
        setTitle("Book List");
        ((MyApp)getApplication()).sb.getBookList().clear();
        ((MyApp)getApplication()).sb.getFullDescBookList().clear();
        ((MyApp)getApplication()).query="";
        setAdapterFunc();

   }
   protected void setAdapterFunc(){
       //Intent intent = getIntent();
       String query = ((MyApp)getApplication()).query;
       ((MyApp)getApplication()).networkingServiceForBooks.getAllBooks(query);
       bookList = findViewById(R.id.book_list);
       adapter = new
               BookInfoRecyclerView(((MyApp)getApplication()).sb
               .getBookList(), this);
       //Log.d("NewValue", ((MyApp)getApplication()).sb.getBookList().get(0).getTitle());
       adapter.listener=this;
       bookList.setAdapter(adapter);
       LinearLayoutManager linearLayoutManager=new LinearLayoutManager(this);
       bookList.setLayoutManager(linearLayoutManager);
   }

    @Override
    protected void onResume() {
        super.onResume();

    }

    @Override
    public void onItemClick(int pos) {
        Intent intent=new Intent(BooksListRecyclerView.this,PerformFunctionOnSelectedBookActivity.class);
        intent.putExtra("position",pos);
        startActivity(intent);
    }

    @Override
    public void jsonValuesFetched(String jsonString) {
        ((MyApp)getApplication()).jsonService.getBookTitles(jsonString, this);
        adapter.book_list=((MyApp)getApplication()).sb.getBookList();
        int size=adapter.book_list.size();
        Log.d("NewValues:", String.valueOf(size));
        adapter.notifyDataSetChanged();
    }

    @Override
    public void gettingImageIsCompleted(Bitmap image) {

    }
}