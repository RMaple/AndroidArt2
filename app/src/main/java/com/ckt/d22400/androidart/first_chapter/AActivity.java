package com.ckt.d22400.androidart.first_chapter;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.ckt.d22400.androidart.R;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class AActivity extends FirstBaseActivity {

    @BindView(R.id.btn_jump_b)
    Button mButtonJumpB;
    @BindView(R.id.btn_jump_implicit)
    Button mButtonJumpImplicit;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_a);
        ButterKnife.bind(this);
    }

    @Override
    protected String getActivityName() {
        return "A_Activity";
    }

    @OnClick({R.id.btn_jump_b,R.id.btn_jump_implicit})
    public void onViewClicked(View v) {
        switch (v.getId()) {
            case R.id.btn_jump_b:
                startActivity(new Intent(this, BActivity.class));
                break;
            case R.id.btn_jump_implicit:
                Intent i = new Intent("1");
                i.addCategory("1");
                startActivity(i);
                break;
        }
    }
}
