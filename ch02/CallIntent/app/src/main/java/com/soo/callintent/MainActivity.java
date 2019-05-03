package com.soo.callintent;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {
    EditText et;
    Button btn;
    String TAG="SOO";
    
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        et = (EditText) findViewById(R.id.editText);
        btn = (Button) findViewById(R.id.button);
        btn.setOnClickListener(new ClickHandler());
        Log.d(TAG, "onCreate: setOnClickListener()..");
    }

    private class ClickHandler implements View.OnClickListener{
        @Override
        public void onClick(View v) {
            Log.w(TAG, "onClick: Dialing App Call~~" );
            String myData = et.getText().toString();
            Intent intent = new Intent(Intent.ACTION_DIAL, Uri.parse(myData));
            startActivity(intent);
			
			//map.google.co.kr
			//Uri location = Uri.parse("geo:37.4976648,127.0265556?z=14"); // z param is zoom level
			//Intent intent = new Intent(Intent.ACTION_VIEW, location);
			//startActivity(intent);
			
			//Uri webpage = Uri.parse("http://www.naver.com");
			//Intent intent = new Intent(Intent.ACTION_VIEW, webpage);
			//startActivity(intent);
        }
    }
}
