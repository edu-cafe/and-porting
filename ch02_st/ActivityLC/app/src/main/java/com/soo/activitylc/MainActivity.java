package com.soo.activitylc;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    @Override
    protected void onPause() {
        super.onPause();
        Toast.makeText(MainActivity.this, "onPause()...", Toast.LENGTH_SHORT).show();
    }

    @Override
    protected void onResume() {
        super.onResume();
        Toast.makeText(MainActivity.this, "onResume()...", Toast.LENGTH_SHORT).show();
    }

    @Override
    protected void onStart() {
        super.onStart();
        Toast.makeText(MainActivity.this, "onStart()...", Toast.LENGTH_SHORT).show();
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        Toast.makeText(MainActivity.this, "onRestart()...", Toast.LENGTH_SHORT).show();
    }

    @Override
    protected void onStop() {
        super.onStop();
        Toast.makeText(MainActivity.this, "onStop()...", Toast.LENGTH_SHORT).show();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Toast.makeText(MainActivity.this, "onDestroy()...", Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onClick(View v) {
        Intent view = new Intent(this, NextActivity.class);
//        view.setAction(Intent.ACTION_VIEW);
        startActivity(view);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button btn = (Button) findViewById(R.id.button);
        btn.setOnClickListener(this);

        Toast.makeText(MainActivity.this, "onCreate()...", Toast.LENGTH_SHORT).show();
    }
}
