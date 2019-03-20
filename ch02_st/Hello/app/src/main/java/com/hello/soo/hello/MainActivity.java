package com.hello.soo.hello;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void sendMessage(View view) {
        Log.d("SOO", "Button Clicked!!");
//        Toast.makeText(this, "Button Clicked!!", Toast.LENGTHLONG).show();
        Intent intent = new Intent(this, DisplatMessageActivity.class);
        EditText editText = findViewById(R.id.editText);
        String msg = editText.getText().toString();
        intent.putExtra("NAME", msg);
        startActivity(intent);
    }
}
