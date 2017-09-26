package com.ckt.d22400.androidart.second_chapter;

import java.io.Serializable;

/**
 * Created by D22400 on 2017/9/26.
 * 可序列化与序列化
 */

public class User implements Serializable {
    //手动指定可以避免反序列化的失败
    private static final long serialVersionUID = 1L;

    private String mName;
    private int mAge;

    public User(String name,int age) {
        mName=name;
        mAge = age;
    }

    public String getName() {
        return mName;
    }

    public void setName(String name) {
        mName = name;
    }

    public int getAge() {
        return mAge;
    }

    public void setAge(int age) {
        mAge = age;
    }
}
