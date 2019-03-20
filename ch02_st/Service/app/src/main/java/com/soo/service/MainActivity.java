package com.soo.service;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    static final String TAG = "SOO";
    Intent serviceIntent = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button startBtn = (Button) findViewById(R.id.button);
        Button stopBtn = (Button) findViewById(R.id.button2);

        startBtn.setOnClickListener(this);
        stopBtn.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch(v.getId()) {
            case R.id.button :
                Log.i(TAG, "StartService Button Clicked!!");
                serviceIntent = new Intent(this, MyService.class);
               startService(serviceIntent);
                break;
            case R.id.button2 :
                Log.i(TAG, "StopService Button Clicked!!");
                if(serviceIntent != null) stopService(serviceIntent);
                serviceIntent = null;
                break;
        }
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        if(serviceIntent != null) stopService(serviceIntent);
    }
}
