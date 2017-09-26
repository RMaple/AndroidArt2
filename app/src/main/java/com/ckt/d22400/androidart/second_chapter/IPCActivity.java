package com.ckt.d22400.androidart.second_chapter;

import android.content.ComponentName;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Bundle;
import android.os.IBinder;
import android.os.RemoteException;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;

import com.ckt.d22400.androidart.R;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.List;

import butterknife.ButterKnife;
import butterknife.OnClick;

public class IPCActivity extends AppCompatActivity {


    public static final String TAG = "IPC";

    private ServiceConnection mServiceConnection = new ServiceConnection() {
        @Override
        public void onServiceConnected(ComponentName name, IBinder service) {
            IBookManager bookManager = IBookManager.Stub.asInterface(service);
            try {
                List<Book> books = bookManager.getBookList();
                Log.i(TAG, books.get(0).mBookName);
                Book book = new Book(3, "《Java从入门到放弃》");
                bookManager.addBook(book);
            } catch (RemoteException e) {
                e.printStackTrace();
            }
        }

        @Override
        public void onServiceDisconnected(ComponentName name) {

        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ipc);
        ButterKnife.bind(this);

    }

    @OnClick({R.id.btn_ipc2, R.id.btn_bind})
    public void onViewClicked(View v) {
        switch (v.getId()) {
            case R.id.btn_ipc2:
                new Thread(new Runnable() {
                    @Override
                    public void run() {
                        User user = new User("邱丹枫", 22);
                        File dir = new File(getExternalCacheDir() + File.separator + "IPC");
                        Log.i(TAG, dir.getPath());
                        if (!dir.exists()) {
                            dir.mkdir();
                        }
                        File cachedFile = new File(dir.getPath() + File.separator + "1");
                        Log.i(TAG, cachedFile.getPath());
                        ObjectOutputStream oos = null;
                        try {
                            oos = new ObjectOutputStream(new FileOutputStream(cachedFile));
                            oos.writeObject(user);
                        } catch (IOException e) {
                            e.printStackTrace();
                        } finally {
                            if (oos != null) {
                                try {
                                    oos.close();
                                } catch (IOException e) {
                                    e.printStackTrace();
                                }
                            }
                            startActivity(new Intent(IPCActivity.this, IPCA2Activity.class));
                        }
                    }
                }).start();
                break;
            case R.id.btn_bind:
                Intent service = new Intent(this, BookManagerService.class);
                bindService(service, mServiceConnection,BIND_AUTO_CREATE);
                break;
        }
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        unbindService(mServiceConnection);
    }
}
