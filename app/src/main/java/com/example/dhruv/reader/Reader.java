package com.example.dhruv.reader;

/**
 * Created by dhruv on 3/25/15.
 */

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.telephony.SmsMessage;
import android.util.Log;
import android.widget.Toast;

public class Reader extends BroadcastReceiver {
    public void onReceive(Context context, Intent intent) {
        Log.i("ReaderDebug","Message Read");
        Bundle myBundle = intent.getExtras();
        SmsMessage[] messages = null;
        String output = "";
        Log.i("ReaderDebug", "Reading message");

        if (myBundle != null) {
            Sender sender = new Sender(context);
            Object[] pdus = (Object[]) myBundle.get("pdus");
            messages = new SmsMessage[pdus.length];

            for (int i = 0; i < messages.length; i++) {
                messages[i] = SmsMessage.createFromPdu((byte[]) pdus[i]);
                output += "SMS From: " + messages[i].getOriginatingAddress();
                output += " : ";
                output += messages[i].getMessageBody();
                output += "\n";
            }
            //sender.send(strMessage);
            Toast.makeText(context, output, Toast.LENGTH_LONG).show();
        }

    }
}
