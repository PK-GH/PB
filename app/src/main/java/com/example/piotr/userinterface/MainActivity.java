package com.example.piotr.userinterface;

import android.content.Intent;
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
        Intent GetStartConfirmation = new Intent(this, StartScreen.class);

        final int res = 1; // can use as a signal for another time

        //GetStartConfirmation.putExtra("homeStart", "MainActivity");
        // This can be used to send data between the activities

        startActivityForResult(GetStartConfirmation, res); //

    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);


    }
}
