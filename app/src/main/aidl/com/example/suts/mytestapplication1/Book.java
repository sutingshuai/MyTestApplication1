package com.example.suts.mytestapplication1;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * Created by suts on 2017/9/4.
 */

public class Book implements Parcelable {
    private int price;
    private String name;
    private String author;

    public Book() {}

    public Book(int price, String name, String author) {
        this.price = price;
        this.name = name;
        this.author = author;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(this.price);
        dest.writeString(this.name);
        dest.writeString(this.author);
    }

    protected Book(Parcel in) {
        this.price = in.readInt();
        this.name = in.readString();
        this.author = in.readString();
    }

    public void readFromParcel(Parcel dest){
        this.price = dest.readInt();
        this.name = dest.readString();
        this.author = dest.readString();
    }

    public static final Parcelable.Creator<Book> CREATOR = new Parcelable.Creator<Book>() {
        @Override
        public Book createFromParcel(Parcel source) {
            return new Book(source);
        }

        @Override
        public Book[] newArray(int size) {
            return new Book[size];
        }
    };

    @Override
    public String toString() {
        return "Book{" +
                "price=" + price +
                ", name='" + name + '\'' +
                ", author='" + author + '\'' +
                '}';
    }
}
