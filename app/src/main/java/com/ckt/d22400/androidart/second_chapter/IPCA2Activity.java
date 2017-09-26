package com.ckt.d22400.androidart.second_chapter;

import android.os.Bundle;
import android.os.Environment;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.TextView;

import com.ckt.d22400.androidart.R;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;

import butterknife.BindView;
import butterknife.ButterKnife;

public class IPCA2Activity extends AppCompatActivity {

    @BindView(R.id.tv_show)
    TextView mShowTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ipca2);
        ButterKnife.bind(this);
        new Thread(new Runnable() {
            @Override
            public void run() {
                File cachedFile = new File(getExternalCacheDir() + File.separator + "IPC" + File.separator + "1");
                ObjectInputStream ois = null;
                try {
                    ois = new ObjectInputStream(new FileInputStream(cachedFile));
                    final User user = (User) ois.readObject();
                    Log.i(IPCActivity.TAG, "我叫" + user.getName() + "，今年" + user.getAge());
                    runOnUiThread(new Runnable() {
                        @Override
                        public void run() {
                            mShowTextView.setText("我叫" + user.getName() + "，今年" + user.getAge());
                        }
                    });
                } catch (IOException | ClassNotFoundException e) {
                    e.printStackTrace();
                } finally {
                    if (ois != null) {
                        try {
                            ois.close();
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                    }
                }
            }
        }).start();
    }


}
