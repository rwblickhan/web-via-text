package com.example.rwblickhan.webviatextserver;


import android.os.Handler;
import android.os.Message;
import android.os.Looper;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import java.net.HttpURLConnection;
import java.util.HashMap;
import java.util.Map;

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

        HashMap<String, String> urlMap = (HashMap<String, String>) msg.obj;
        for (Map.Entry<String, String> entry : urlMap.entrySet())
        {
            String phoneNumber = entry.getKey();
            String url = entry.getValue();

            if (phoneNumber == null || url == null)
            {
                return null;

            }
        }

        return null;
    }

    static public void sendSMS(String str)
    {
        //TODO
    }

    public void onUrlParse(HashMap<String, String> url) {
        Message msg = Message.obtain();

        msg.setTarget(mHandler);
        msg.what = URL_PARSED;
        msg.obj = url;

        msg.sendToTarget();
    }

}
