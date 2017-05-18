package com.example.rwblickhan.webviatextserver;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.telephony.SmsMessage;

import java.util.HashMap;

/**
 * Created by rwblickhan on 5/17/17.
 */

public class SmsBroadcastReceiver extends BroadcastReceiver {

    public static final String SMS_BUNDLE = "pdus";
    public static final String FORMAT = "format";

    public void onReceive(Context context, Intent intent) {
        Bundle intentExtras = intent.getExtras();

        String url = "";
        String address = "";
        if (intentExtras != null) {
            Object[] sms = (Object[]) intentExtras.get(SMS_BUNDLE);
            if (sms != null) {
                for (Object item : sms) {
                    String format = intentExtras.getString(FORMAT);
                    SmsMessage smsMessage = SmsMessage.createFromPdu((byte[]) item, format);

                    url = smsMessage.getMessageBody();
                    address = smsMessage.getOriginatingAddress();
                }
            }
            //TODO error handling
        }

        //TODO check that sms body is a valid url
        MainActivity inst = MainActivity.instance();
        HashMap<String, String> obj = new HashMap<>();
        obj.put(address, url);
        inst.onUrlParse(obj);
    }
}
