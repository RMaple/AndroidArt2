package com.ckt.d22400.androidart;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.Button;

import com.ckt.d22400.androidart.first_chapter.AActivity;
import com.ckt.d22400.androidart.second_chapter.IPCActivity;

import butterknife.ButterKnife;
import butterknife.OnClick;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
    }


    @OnClick({R.id.btn_first_chapter,R.id.btn_second_chapter})
    public void onButtonClicked(Button button) {
        switch (button.getId()) {
            case R.id.btn_first_chapter:
                startActivity(new Intent(this, AActivity.class));
                break;
            case R.id.btn_second_chapter:
                startActivity(new Intent(this, IPCActivity.class));
                break;
        }
    }
}
