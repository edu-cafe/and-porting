package com.hello.soo.hello;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class DisplatMessageActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_displat_message);

        Intent intent = getIntent();
        String msg = intent.getStringExtra("NAME");

        TextView textView = findViewById(R.id.textView2);
        textView.setText(msg);
    }
}
