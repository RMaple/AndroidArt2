package com.ckt.d22400.androidart.first_chapter;

import android.content.Intent;
import android.content.res.Configuration;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;

/**
 * Created by D22400 on 2017/9/22.
 * 父类
 */

public abstract class FirstBaseActivity extends AppCompatActivity {

    public static final String TAG = "FIRST_CHAPTER";

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setTitle(getActivityName());
        Log.i(TAG, getActivityName() + " onCreate: " + System.currentTimeMillis());
    }

    @Override
    protected void onNewIntent(Intent intent) {
        super.onNewIntent(intent);
        Log.i(TAG, getActivityName() + " onNewIntent: " + System.currentTimeMillis());
    }

    @Override
    public void onConfigurationChanged(Configuration newConfig) {
        super.onConfigurationChanged(newConfig);
        Log.i(TAG, getActivityName() + " onConfigurationChanged: " + System.currentTimeMillis());
    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        Log.i(TAG, getActivityName() + " onSaveInstanceState: " + System.currentTimeMillis());
    }

    @Override
    protected void onRestoreInstanceState(Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);
        Log.i(TAG, getActivityName() + " onRestoreInstanceState: " + System.currentTimeMillis());
    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.i(TAG, getActivityName() + " onStart: " + System.currentTimeMillis());
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.i(TAG, getActivityName() + " onResume: " + System.currentTimeMillis());

    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.i(TAG, getActivityName() + " onPause: " + System.currentTimeMillis());

    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.i(TAG, getActivityName() + " onStop: " + System.currentTimeMillis());

    }

    @Override
    protected void onRestart() {
        super.onRestart();
        Log.i(TAG, getActivityName() + " onRestart: " + System.currentTimeMillis());

    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.i(TAG, getActivityName() + " onDestroy: " + System.currentTimeMillis());

    }

    protected abstract String getActivityName();

}
