package com.example.dhruv.reader;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;

/**
 * Created by dhruv on 3/27/15.
 */
public class Main extends BroadcastReceiver {

    @Override
    public void onReceive(Context context, Intent intent) {
        if("android.intent.action.BOOT_COMPLETED".equals(intent.getAction())){
            Intent background = new Intent(context, MonitoringService.class);
            context.startService(background);
        }
    }


}
