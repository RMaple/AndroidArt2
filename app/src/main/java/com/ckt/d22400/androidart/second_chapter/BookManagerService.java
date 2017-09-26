package com.ckt.d22400.androidart.second_chapter;

import android.app.Service;
import android.content.Intent;
import android.os.Binder;
import android.os.IBinder;
import android.os.RemoteException;

import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

public class BookManagerService extends Service {

    private CopyOnWriteArrayList<Book> mBooks = new CopyOnWriteArrayList<>();

    private Binder mBinder = new IBookManager.Stub() {

        @Override
        public void basicTypes(int anInt, long aLong, boolean aBoolean, float aFloat, double aDouble, String aString) throws RemoteException {

        }

        @Override
        public List<Book> getBookList() throws RemoteException {
            return mBooks;
        }

        @Override
        public void addBook(Book book) throws RemoteException {
            mBooks.add(book);
        }
    };


    @Override
    public void onCreate() {
        super.onCreate();
        mBooks.add(new Book(1, "《无敌》"));
        mBooks.add(new Book(2, "《牛》"));
    }

    @Override
    public IBinder onBind(Intent intent) {
        return mBinder;
    }
}
