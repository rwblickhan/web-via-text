package com.example.rwblickhan.webviatextserver;

import android.os.Message;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity {

    private static MainActivity inst;
    private static final int URL_PARSED = 1;

    public static MainActivity instance() {
        return inst;
    }

    @Override
    protected void onStart() {
        super.onStart();
        inst = this;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void onUrlParse(Object url) {
        Message msg = Message.obtain();

        //TODO add handler
        msg.setTarget(/*handler here*/);
        msg.what = URL_PARSED;
        msg.obj = url;

        msg.sendToTarget();
    }

}
