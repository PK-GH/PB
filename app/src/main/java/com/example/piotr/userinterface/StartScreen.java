package com.example.piotr.userinterface;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class StartScreen extends Activity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.start_layout);

        Intent activityStartHome = getIntent();

        String previousActivity = activityStartHome.getExtras().getString("homeStart");

        //15:40

        //Button callingButton = (Button) find

        //TextView callingActivityMessage = (TextView) findViewById(R.id.);


    }

    public void OnStartConfirmation(View view) {
        // Vid 5, Derek
        //String

        Intent toStart = new Intent();

        //toStart.putExtra("Don't need",)

        setResult(RESULT_OK, toStart);

        finish();
    }
}
