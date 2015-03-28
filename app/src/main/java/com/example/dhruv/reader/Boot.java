package com.example.dhruv.reader;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.util.Log;

/**
 * Created by dhruv on 3/27/15.
*/
public class Boot extends BroadcastReceiver {

    @Override
    public void onReceive(Context context, Intent intent) {
        Log.i("ReaderDebug","BootCompleted");
        if("android.intent.action.BOOT_COMPLETED".equals(intent.getAction())){
            Intent background = new Intent(context, MonitoringService.class);
            Log.i("ReaderDebug","Started Service");
            context.startService(background);
        }
    }



}