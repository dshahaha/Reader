package com.example.dhruv.reader;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;

/**
 * Created by dhruv on 3/26/15.
 */
public class MonitoringService extends Service{

    public int onStartCommand(Intent intent, int flags, int startId) {
        //TODO do something useful
        return Service.START_STICKY;
    }

    @Override
    public IBinder onBind(Intent intent) {
        //TODO for communication return IBinder implementation
        return null;
    }
}