package com.example.piotr.userinterface;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.support.annotation.NonNull;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.app.ActionBar;
import android.os.Bundle;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;


public class MainActivity extends AppCompatActivity {
    // Testing GH
    // Used to load the 'native-lib' library on application startup.
    int i = 0;
    private static final int REQUEST_BLUETOOTH = 0;
    static {
        System.loadLibrary("native-lib");
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);




    }

    public void OnStartClick(View view) {
        //from Tutorial 5 Derek Banas
        // Here, thisActivity is the current activity

        Intent GetStartConfirmation = new Intent(this, StartScreen.class);
        /*
        Intent: pass context, and activity to open
        1) Action
        2) Data

         */
        final int res = 1; // can use as a signal for another time

        startActivityForResult(GetStartConfirmation, res);
        //res is updated with the information we need
        //if RESULT_CANCELED == 0, then 'No' selected, if
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {

        super.onActivityResult(requestCode, resultCode, data);

        // will need some return result, then we'll update the image
        i = resultCode;
        updateUi();
    }

    private void updateUi()
    {
        ImageView imageView = (ImageView) findViewById(R.id.powericon);
        if(i == 11)
        {   //11 corresponds to ON
            int powerIcon = R.drawable.poweron;
            imageView.setImageResource(powerIcon);
        }
        else if(i == 99)
        {   //99 corresponds to a cancellation case
            int powerIcon = R.drawable.poweroff;
            imageView.setImageResource(powerIcon);
        }
    }


}
