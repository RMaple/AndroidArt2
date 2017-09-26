// IOnNewBookArrivedListener.aidl
package com.ckt.d22400.androidart.second_chapter;
import com.ckt.d22400.androidart.second_chapter.Book;

// Declare any non-default types here with import statements

interface IOnNewBookArrivedListener {
    void onNewBookArrived(in Book book);

}
