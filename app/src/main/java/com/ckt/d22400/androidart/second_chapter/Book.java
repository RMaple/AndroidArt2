package com.ckt.d22400.androidart.second_chapter;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * Created by D22400 on 2017/9/25.
 *
 */

public class Book implements Parcelable {

    private int mBookId;
    public String mBookName;

    Book(int bookId,String bookName){
        mBookId = bookId;
        mBookName = bookName;
    }

    private Book(Parcel in) {
        mBookId = in.readInt();
        mBookName = in.readString();
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

    /**
     * 内容描述
     * @return 仅当当前对象中存在文件描述符时才返回1，否则返回0
     */
    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel out, int flags) {
        out.writeInt(mBookId);
        out.writeString(mBookName);
    }
}
