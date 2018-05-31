package com.example.piotr.userinterface;

import android.app.Activity;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.content.Intent;
import android.view.View;

import java.nio.charset.Charset;


public class StartConfirm extends MainActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.start_confirm_layout);

        Intent activityStartHome = getIntent();

    }



    public void OnStartConfirmation(View view) {
        // Vid 5, Derek
        Intent toStart = new Intent();

        // this is where the difficulties lie, the intents.

        setResult(1, toStart);

        finish(); // eventually will need to add something to these two intents
    }

    public void OnNoStartConfirmation(View view) {

        Intent DoNotStart = new Intent();

        setResult(0, DoNotStart);
        //Do not want canceled, indicates there was a failure on the button

        finish();
    }
}
