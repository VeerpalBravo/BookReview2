package com.example.bookreview;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.Html;
import android.text.method.LinkMovementMethod;
import android.text.method.ScrollingMovementMethod;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

public class PerformFunctionOnSelectedBookActivity extends AppCompatActivity {
    TextView hyperTextLink;
    TextView title;
    TextView subtitle;
    TextView author;
    TextView amount;
    TextView publisher;
    TextView publishedDate;
    TextView category;
    TextView description;
    ImageView img;
    Button buyBtn;
    Button reviewbtn;
    Button bookRatingBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_perform_function_on_selected_book);
        setTitle("Book Description");
        Intent intent = getIntent();
        int position = intent.getExtras().getInt("position");
        title=findViewById(R.id.titlePerformFunc);
        subtitle=findViewById(R.id.subtitlePerformFunc);
        author=findViewById(R.id.authorPerformFunc);
        category=findViewById(R.id.categoryPerformFunc);
        description=findViewById(R.id.descriptionPerformFunc);
        description.setMovementMethod(new ScrollingMovementMethod());
        amount=findViewById(R.id.pricePerformFunc);
        publisher=findViewById(R.id.publisherPerformFunc);
        publishedDate=findViewById(R.id.publishDatePerformFunc);
        img=findViewById(R.id.imgPerformFunc);
        buyBtn=findViewById(R.id.buyThisBookBtn);
        reviewbtn=findViewById(R.id.ReviewCommentsBtn);
        bookRatingBtn=findViewById(R.id.RateBookBtn);
        hyperTextLink=findViewById(R.id.hyperTextLinkPerformFunc);
        showBookDescription(position);
        bookRatingBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent reviewActivityLink = new Intent(PerformFunctionOnSelectedBookActivity.this,
                        ReviewBookActivity.class);
                reviewActivityLink.putExtra("title",title.getText().toString());
                startActivity(reviewActivityLink);
            }
        });
    }
    public void showBookDescription(int pos){
        String linkUrl=((MyApp)getApplication()).sb.getFullDescBookList().get(pos).getThumbnail();
        String url ="<a href=\"link\">"+linkUrl+"</a>";
        title.setText("Title: "+((MyApp)getApplication()).sb.getFullDescBookList().get(pos).getTitle());
        subtitle.setText("Subtitle: "+((MyApp)getApplication()).sb.getFullDescBookList().get(pos).getSubtitle());
        publisher.setText("Publisher name: "+((MyApp)getApplication()).sb.getFullDescBookList().get(pos).getPublisher());
        publishedDate.setText("Published on: "+((MyApp)getApplication()).sb.getFullDescBookList().get(pos).getPublishedDate());
        hyperTextLink.setText(Html.fromHtml(url));
        hyperTextLink.setMovementMethod(LinkMovementMethod.getInstance());
        description.setText("Description Of Book: "+((MyApp)getApplication()).sb.getFullDescBookList().get(pos).getDescription());
        if(((MyApp)getApplication()).sb.getFullDescBookList().get(pos).getSaleability().equals("FOR_SALE")) {
            amount.setText("Price of Book: "+((MyApp) getApplication()).sb.getFullDescBookList().get(pos).getAmount() +
                    ((MyApp) getApplication()).sb.getFullDescBookList().get(pos).getCurrencyCode());
        }
        else
        {
            amount.setText("Not for Sale");
        }
        int categorySize=((MyApp)getApplication()).sb.getFullDescBookList().get(pos).getCategory().size();
        for(int i=0;i<categorySize;i++){
            category.setText("Genre: "+((MyApp)getApplication()).sb.getFullDescBookList().get(pos).getCategory().get(i));
        }
        int No_of_authors=((MyApp)getApplication()).sb.getFullDescBookList().get(pos).getAuthors().size();
        for(int i=0;i<No_of_authors;i++){
            author.setText("Author: "+((MyApp)getApplication()).sb.getFullDescBookList().get(pos).getAuthors().get(i));
        }
        Glide.with(this).load(((MyApp)getApplication()).sb.getFullDescBookList().get(pos).
                getThumbnail()).into(img);


    }
}