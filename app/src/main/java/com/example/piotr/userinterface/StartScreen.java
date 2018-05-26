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

        //String previousActivity = activityStartHome.getExtras().getString("homeStart");

        //15:40

        //Button callingButton = (Button) find

        //TextView callingActivityMessage = (TextView) findViewById(R.id.);


    }

    public void OnStartConfirmation(View view) {
        // Vid 5, Derek
        Intent toStart = new Intent();

        setResult(RESULT_OK, toStart);

        finish();
    }
    public void OnNoStartConfirmation(View view) {

        Intent DoNotStart = new Intent();

        setResult(RESULT_CANCELED, DoNotStart);
        //Don't know if we want result canceled

        finish();
    }
}
