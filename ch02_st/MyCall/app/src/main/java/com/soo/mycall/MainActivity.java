package com.soo.mycall;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void callPhone(View view) {
        Uri uri = Uri.parse("tel:010-1111-2222");
        Intent intent = new Intent(Intent.ACTION_DIAL, uri);

//        Uri location = Uri.parse("geo:37.4976648,127.0265556?z=14"); // z param is zoom level
//        Intent intent = new Intent(Intent.ACTION_VIEW, location);

//        Uri webpage = Uri.parse("http://www.naver.com");
//        Intent intent = new Intent(Intent.ACTION_VIEW, webpage);

        startActivity(intent);
    }
}
