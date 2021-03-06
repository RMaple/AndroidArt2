// IBookManager.aidl
package com.ckt.d22400.androidart.second_chapter;

import com.ckt.d22400.androidart.second_chapter.Book;
interface IBookManager {
    /**
     * Demonstrates some basic types that you can use as parameters
     * and return values in AIDL.
     */
    void basicTypes(int anInt, long aLong, boolean aBoolean, float aFloat,
            double aDouble, String aString);

    List<Book> getBookList();

    void addBook(in Book book);

}
