package com.soo.br1;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.util.Log;

public class MySMSReceiver extends BroadcastReceiver {
    public MySMSReceiver() {
    }

    @Override
    public void onReceive(Context context, Intent intent) {
        Log.i("SOO", "----->onReceive");
        if(intent.getAction().equals("android.provider.Telephony.SMS_RECEIVED")){
            Log.i("SOO", "----->SMS Event received!");

            abortBroadcast();

            Intent myIntent = new Intent(context,BRActivity.class);
            myIntent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
            context.startActivity(myIntent);
        }
    }
}
