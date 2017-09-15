// IMyAidlInterface.aidl
package com.example.suts.mytestapplication1;

// Declare any non-default types here with import statements

import com.example.suts.mytestapplication1.Book;

interface IMyAidlInterface {

    /**
     * Demonstrates some basic types that you can use as parameters
     * and return values in AIDL.
     */
    void basicTypes(int anInt, long aLong, boolean aBoolean, float aFloat,
            double aDouble, String aString);

    List<Book> getBooks();
    int getBookCount();
    Book getBook();

    void setBookPrice(in Book book, int price);
    void setBookName(in Book book, String name);
    void addBookIn(in Book book);
    void addBookOut(out Book book);
    void addBookInOut(inout Book book);

}
