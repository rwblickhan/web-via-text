package com.example.rwblickhan.webviatextserver;

import android.os.Handler;
import android.os.Message;
import android.os.Looper;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity {

    private static final int RECEIVE_SMS = 1;
    Handler mHandler = new SMSHandler();

    static class SMSHandler extends Handler
    {
        public void handleMessage(Message msg)
        {
            sendSMS(parseAndFetchContent(msg));
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Looper.prepare();
        Looper.loop();
    }

    public void onResult(Object result)
    {
        Message msg = Message.obtain();

        msg.setTarget(mHandler);
        msg.what = RECEIVE_SMS;
        msg.obj = result;

        msg.sendToTarget();
    }

    static public String parseAndFetchContent(Message msg)
    {
        return "";
    }

    static public void sendSMS(String str)
    {

    }
}
