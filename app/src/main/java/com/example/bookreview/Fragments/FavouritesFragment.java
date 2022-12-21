package com.example.bookreview.Fragments;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.bookreview.Book;
import com.example.bookreview.BookInfoRecyclerView;
import com.example.bookreview.Comments;
import com.example.bookreview.DBManager;
import com.example.bookreview.MainActivity;
import com.example.bookreview.MyApp;
import com.example.bookreview.R;

import java.util.ArrayList;
import java.util.Arrays;


public class FavouritesFragment extends Fragment implements  BookInfoRecyclerView.ItemClickListener,
        DBManager.DataBaseListener {

    RecyclerView favBookList;
    BookInfoRecyclerView adapter;
    ArrayList<Book> favBookArrayList = new ArrayList<>();
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        ((MyApp)getActivity().getApplication()).db.getAllFavBooks();
        adapter = new BookInfoRecyclerView(favBookArrayList, container.getContext());
        adapter.listener=this;
        favBookList.setAdapter(adapter);
        LinearLayoutManager linearLayoutManager=new LinearLayoutManager(container.getContext());
        favBookList.setLayoutManager(linearLayoutManager);
        return inflater.inflate(R.layout.fragment_favourites, container, false);
    }

    @Override
    public void onItemClick(int pos) {

    }

    @Override
    public void insertingCommentsCompleted() {

    }

    @Override
    public void gettingCommentsCompleted(Comments[] list) {

    }

    @Override
    public void insertingBooksCompleted() {

    }

    @Override
    public void gettingFavBooksCompleted(Book[] list) {
        favBookArrayList = new ArrayList( Arrays.asList(list));
        adapter.book_list = favBookArrayList;
        adapter.notifyDataSetChanged();
    }
}