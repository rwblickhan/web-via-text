package com.example.rwblickhan.webviatextserver;


import android.os.Handler;
import android.os.Message;
import android.os.Looper;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity {

    private static MainActivity inst;
    private static final int URL_PARSED = 1;
    Handler mHandler = new SMSHandler();

    static private class SMSHandler extends Handler {
        public void handleMessage(Message msg) {
            sendSMS(parseAndFetchContent(msg));
        }
    }

    public static MainActivity instance() {
        return inst;
    }

    @Override
    protected void onStart() {
        super.onStart();
        inst = this;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Looper.prepare();
        Looper.loop();
    }

    static public String parseAndFetchContent(Message msg)
    {
        //TODO
        return "";
    }

    static public void sendSMS(String str)
    {
        //TODO
    }

    public void onUrlParse(Object url) {
        Message msg = Message.obtain();

        msg.setTarget(mHandler);
        msg.what = URL_PARSED;
        msg.obj = url;

        msg.sendToTarget();
    }

}
