package com.example.bookreview;

import android.graphics.Bitmap;
import android.os.Parcel;
import android.os.Parcelable;

import org.json.JSONArray;

import java.util.ArrayList;

public class Book implements Parcelable {
            // creating string, int and array list
        // variables for our book details

        private String title;
        private String subtitle;
        private ArrayList<String> authors;
        private String publisher;
        private String publishedDate;
        private String description;
        private int pageCount;
        private ArrayList<String> category;
        private String thumbnail;
        private String previewLink;
        private String infoLink;
        private String buyLink;
        private String saleability;
        private String currencyCode;
        private double amount;
        private String id;

    public Book(String title, String subtitle, ArrayList<String> authors, String publisher,
                String publishedDate, String description, int pageCount, ArrayList<String> category,
                String thumbnail,String infoLink, String buyLink, String saleability,
                String currencyCode,double amount, String id) {
        this.title = title;
        this.subtitle = subtitle;
        this.authors = authors;
        this.publisher = publisher;
        this.publishedDate = publishedDate;
        this.description = description;
        this.pageCount = pageCount;
        this.category = category;
        this.thumbnail = thumbnail;
        this.infoLink = infoLink;
        this.buyLink = buyLink;
        this.saleability = saleability;
        this.currencyCode = currencyCode;
        this.amount = amount;
        this.id = id;
    }

    protected Book(Parcel in) {
        id = in.readString();
        title = in.readString();
        subtitle = in.readString();
        authors = in.createStringArrayList();
        publisher = in.readString();
        publishedDate = in.readString();
        description = in.readString();
        pageCount = in.readInt();
        category = in.createStringArrayList();
        thumbnail = in.readString();
        previewLink = in.readString();
        infoLink = in.readString();
        buyLink = in.readString();
        saleability = in.readString();
        currencyCode = in.readString();
        amount = in.readDouble();

    }

    public static final Creator<Book> CREATOR = new Creator<Book>() {
        @Override
        public Book createFromParcel(Parcel in) {
            return new Book(in);
        }

        @Override
        public Book[] newArray(int size) {
            return new Book[size];
        }
    };

    // creating getter and setter methods
public double getAmount() {
    return amount;
}

    public void setAmount(double category) {
        this.amount = amount;
    }
    public String getSaleability() {
        return saleability;
    }

    public void setSaleability(String  saleability) {
        this.saleability = saleability;
    }

    public String getCurrencyCode() {
        return currencyCode;
    }

    public void setCurrencyCode(String  currencyCode) {
        this.currencyCode = currencyCode;
    }
    public String getinfoLink() {
        return infoLink;
    }

    public void setinfoLink(String  infoLink) {
        this.infoLink = infoLink;
    }
    public String getBuyLink() {
        return buyLink;
    }

    public void setBuyLink(String  buyLink) {
        this.buyLink = buyLink;
    }
        public ArrayList<String> getCategory() {
            return category;
        }

        public void setCategory(ArrayList category) {
            this.category = category;
        }
        public String getTitle() {
            return title;
        }

        public void setTitle(String title) {
            this.title = title;
        }
        public String getId() {
            return id;
        }

        public void setId(String id) {
            this.id = id;
        }

        public String getSubtitle() {
            return subtitle;
        }

        public void setSubtitle(String subtitle) {
            this.subtitle = subtitle;
        }

        public ArrayList<String> getAuthors() {
            return authors;
        }

        public void setAuthors(ArrayList<String> authors) {
            this.authors = authors;
        }

        public String getPublisher() {
            return publisher;
        }

        public void setPublisher(String publisher) {
            this.publisher = publisher;
        }

        public String getPublishedDate() {
            return publishedDate;
        }

        public void setPublishedDate(String publishedDate) {
            this.publishedDate = publishedDate;
        }

        public String getDescription() {
            return description;
        }

        public void setDescription(String description) {
            this.description = description;
        }

        public int getPageCount() {
            return pageCount;
        }

        public void setPageCount(int pageCount) {
            this.pageCount = pageCount;
        }

        public String getThumbnail() {
            return thumbnail;
        }

        public void setThumbnail(String thumbnail) {
            this.thumbnail = thumbnail;
        }

        public String getPreviewLink() {
            return previewLink;
        }

        public void setPreviewLink(String previewLink) {
            this.previewLink = previewLink;
        }

    public Book(String title, String subtitle, ArrayList<String> authors,
                String publisher, String publishedDate, String description,
                int pageCount, String thumbnail, String previewLink, String infoLink,
                String buyLink) {
        this.title = title;
        this.subtitle = subtitle;
        this.authors = authors;
        this.publisher = publisher;
        this.publishedDate = publishedDate;
        this.description = description;
        this.pageCount = pageCount;
        this.thumbnail = thumbnail;
        this.previewLink = previewLink;
        this.infoLink = infoLink;
        this.buyLink = buyLink;
    }
    public Book(String title, String thumbnail, String subtitle,String id){
            this.title = title;
            this.thumbnail = thumbnail;
    }

    @Override
    public int describeContents() {
        return 0;
    }
    @Override
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(id);
        parcel.writeString(title);
        parcel.writeString(subtitle);
        parcel.writeStringList(authors);
        parcel.writeString(publisher);
        parcel.writeString(publishedDate);
        parcel.writeString(description);
        parcel.writeInt(pageCount);
        parcel.writeStringList(category);
        parcel.writeString(thumbnail);
        parcel.writeString(previewLink);
        parcel.writeString(infoLink);
        parcel.writeString(buyLink);
        parcel.writeString(saleability);
        parcel.writeString(currencyCode);
        parcel.writeDouble(amount);
    }
}
