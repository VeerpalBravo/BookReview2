package com.example.bookreview;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.Toast;

public class ReviewBookActivity extends AppCompatActivity implements View.OnClickListener{

    ImageButton starbtn1;
    ImageButton starbtn2;
    ImageButton starbtn3;
    ImageButton starbtn4;
    ImageButton starbtn5;
    Button save;
    Button cancel;
    EditText comment;
    int rating;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_review_book);
        Intent intent=getIntent();
        String title=intent.getStringExtra("title").replace("Title: "," ");
        setTitle(title);
        starbtn1=findViewById(R.id.star1);
        starbtn2=findViewById(R.id.star2);
        starbtn3=findViewById(R.id.star3);
        starbtn4=findViewById(R.id.star4);
        starbtn5=findViewById(R.id.star5);
        starbtn1.setOnClickListener(this);
        starbtn2.setOnClickListener(this);
        starbtn3.setOnClickListener(this);
        starbtn4.setOnClickListener(this);
        starbtn5.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.star1:
                rating=1;
                break;
            case R.id.star2:
                rating=2;
                break;
            case R.id.star3:
                rating=3;
                break;
            case R.id.star4:
                rating=4;
                break;
            case R.id.star5:
                rating=5;
//                starbtn1.setImageResource(R.drawable.ic_baseline_star_24);
//                starbtn2.setImageResource(R.drawable.ic_baseline_star_24);
//                starbtn3.setImageResource(R.drawable.ic_baseline_star_24);
//                starbtn4.setImageResource(R.drawable.ic_baseline_star_24);
//                starbtn5.setImageResource(R.drawable.ic_baseline_star_24);
                break;
            default:
                break;

        }
        Toast.makeText(this,"rating value: "+rating, Toast.LENGTH_SHORT).show();
    }
}