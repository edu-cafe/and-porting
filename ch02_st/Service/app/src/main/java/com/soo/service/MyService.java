package com.soo.service;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.util.Log;

public class MyService extends Service implements Runnable {
    static final String TAG = "SOO";
    private Thread myThread;
    private boolean isRunning = false;
    private int count=0;

    public MyService() {
    }

    @Override
    public void onCreate() {
        super.onCreate();
        Log.w(TAG, "onCreate..");
        myThread = new Thread(this);
        isRunning = true;
        myThread.start();
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        Log.d(TAG, "onDestroy..");
        isRunning = false;
//        myThread.interrupt();
    }

    @Override
    public boolean onUnbind(Intent intent) {
        Log.w(TAG, "onUnbind..");
        return super.onUnbind(intent);
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        Log.e(TAG, "onStartCommand..");
        return super.onStartCommand(intent, flags, startId);
    }

    @Override
    public IBinder onBind(Intent intent) {
        // TODO: Return the communication channel to the service.
        Log.i(TAG, "onBind..");
        throw new UnsupportedOperationException("Not yet implemented");
    }

    @Override
    public void run() {
        while(isRunning) {
//        while(!Thread.currentThread().isInterrupted()) {
            count++;
            Log.d(TAG, "MyService Doinng_" + count);
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}