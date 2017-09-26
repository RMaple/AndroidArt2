package com.ckt.d22400.androidart;

import android.app.Application;
import android.util.Log;

/**
 * Created by D22400 on 2017/9/25.
 */

public class MyApplication extends Application {

    public static final String TAG = "AndroidArt";

    @Override
    public void onCreate() {
        super.onCreate();
        Log.i(TAG, "onCreate: ");
    }
}
