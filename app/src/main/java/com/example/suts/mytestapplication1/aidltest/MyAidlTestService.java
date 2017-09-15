package com.example.suts.mytestapplication1.aidltest;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.os.RemoteException;

import com.example.suts.mytestapplication1.Book;
import com.example.suts.mytestapplication1.IMyAidlInterface;
import com.orhanobut.logger.Logger;

import java.util.ArrayList;
import java.util.List;

public class MyAidlTestService extends Service {

    public final String TAG = this.getClass().getSimpleName();

    private List<Book> books = new ArrayList<>();

    private final IMyAidlInterface.Stub mAidlStub = new IMyAidlInterface.Stub(){

        @Override
        public void basicTypes(int anInt, long aLong, boolean aBoolean, float aFloat, double aDouble, String aString) throws RemoteException {}

        @Override
        public List<Book> getBooks() throws RemoteException {
            if (books == null){
                return new ArrayList<>();
            }
            return books;
        }

        @Override
        public int getBookCount() throws RemoteException {
            if (books != null){
                return books.size();
            }
            return 0;
        }

        @Override
        public Book getBook() throws RemoteException {
            if (books != null){
                return books.get(0);
            }
            return null;
        }

        @Override
        public void setBookPrice(Book book, int price) throws RemoteException {
            if (books == null){
                Logger.e("books list is null");
                books = new ArrayList<>();
            }
            if (book == null){
                Logger.e("book instance is null");
                return;
            }

            if (!books.contains(book)){
                Logger.e("there is not this book, so can't modify its price");
            } else {
                //查找book并修改price
                for (Book book1 : books){
                    if (book.getName().equals(book1.getName())){
                        book.setPrice(price);
                        Logger.e("book has reset price");
                    }
                }
            }

        }

        @Override
        public void setBookName(Book book, String name) throws RemoteException {
            if (books == null){
                Logger.e("books list is null");
                books = new ArrayList<>();
            }
            if (book == null){
                Logger.e("book instance is null");
                return;
            }

            if (!books.contains(book)){
                Logger.e("there is not this book, so can't modify its price");
            } else {
                //查找book并修改price
                for (Book book1 : books){
                    if (book.getName().equals(book1.getName())){
                        book.setName(name);
                        Logger.e("book has reset name");
                    }
                }
            }
        }

        @Override
        public void addBookIn(Book book) throws RemoteException {
            if (books == null){
                Logger.e("books list is null");
                books = new ArrayList<>();
            }
            if (book == null){
                Logger.e("book instance is null");
                return;
            }

            if (!books.contains(book)){
                Logger.e("there is not this book, add success");
                books.add(book);
            } else {
                Logger.e("there is this book, add failed");
            }
        }

        @Override
        public void addBookOut(Book book) throws RemoteException {
            if (books == null){
                Logger.e("books list is null");
                books = new ArrayList<>();
            }
            if (book == null){
                Logger.e("book instance is null");
                return;
            }

            if (!books.contains(book)){
                Logger.e("there is not this book, add success");
                books.add(book);
            } else {
                Logger.e("there is this book, add failed");
            }
        }

        @Override
        public void addBookInOut(Book book) throws RemoteException {
            if (books == null){
                Logger.e("books list is null");
                books = new ArrayList<>();
            }
            if (book == null){
                Logger.e("book instance is null");
                return;
            }

            if (!books.contains(book)){
                Logger.e("there is not this book, add success");
                books.add(book);
            } else {
                Logger.e("there is this book, add failed");
            }
        }
    };

    public MyAidlTestService() {}

    @Override
    public void onCreate() {
        super.onCreate();
        books.add(new Book(100, "android设计模式", "何红辉&关爱民"));
    }

    @Override
    public IBinder onBind(Intent intent) {
        // TODO: Return the communication channel to the service.
        Logger.e(String.format("on bind,intent = %s", intent.toString()));
        return mAidlStub;
    }


    @Override
    public boolean onUnbind(Intent intent) {
        return super.onUnbind(intent);
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
    }
}
