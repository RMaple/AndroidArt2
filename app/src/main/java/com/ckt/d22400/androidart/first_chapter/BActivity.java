package com.ckt.d22400.androidart.first_chapter;

import android.os.Bundle;

import com.ckt.d22400.androidart.R;

public class BActivity extends FirstBaseActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_b);
    }

    @Override
    protected String getActivityName() {
        return "B_Activity";
    }
}
