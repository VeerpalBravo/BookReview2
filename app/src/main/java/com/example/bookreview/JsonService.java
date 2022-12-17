package com.example.bookreview;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.util.Log;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;

public class JsonService {
    public void getBookTitles(String stringValue, Context context){
        JSONObject jsonObject = null;
        try {
            jsonObject = new JSONObject(stringValue);
            JSONArray totalBooks = jsonObject.getJSONArray("items");
            Log.d("NumberOFBooks", String.valueOf(totalBooks.length()));

            for(int i=0; i<totalBooks.length(); i++)
            {
                JSONObject bookInfo = totalBooks.getJSONObject(i);
                JSONObject volumeInfo = bookInfo.getJSONObject("volumeInfo");
                String bookTitle=volumeInfo.getString("title");
                JSONObject imageLinks = volumeInfo.getJSONObject("imageLinks");
                String imageUrl = imageLinks.getString("thumbnail");
                ((MyApp)context.getApplicationContext()).sb.setBookList(bookTitle,imageUrl);
                Log.d("NumberOFBooks",((MyApp)context.getApplicationContext()).sb.getBookList().get(i).getThumbnail()+" "+
                        ((MyApp)context.getApplicationContext()).sb.getBookList().get(i).getTitle());

            }
        } catch (JSONException e) {
            e.printStackTrace();
        }
       // return ((MyApp)context.getApplicationContext()).sb.getBookList();
    }
    public Bitmap convertImage(String url) {
        try {
            URL connection = new URL(url);
            InputStream in=  connection.openStream();
            Bitmap imageData = BitmapFactory.decodeStream(in);
            return imageData;
        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

}
