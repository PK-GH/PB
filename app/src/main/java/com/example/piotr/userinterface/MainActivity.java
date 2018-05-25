package com.example.piotr.userinterface;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;


public class MainActivity extends AppCompatActivity {
    // Testing GH
    // Used to load the 'native-lib' library on application startup.
    int i = 0;
    static {
        System.loadLibrary("native-lib");
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Example of a call to a native method
        final TextView tv = (TextView) findViewById(R.id.TextView);

        RelativeLayout contentView = (RelativeLayout) findViewById(R.id.content);

        tv.setText(stringFromJNI());
        //merely replaces the text in tv for now.

        //final TextView firstTextView = (TextView) findViewById(R.id.TextView);
        Button startButton = (Button) findViewById(R.id.startButton);
        Button functionButton = (Button) findViewById(R.id.functionButton);
        Button settingButton = (Button) findViewById(R.id.settingButton);
        Button helpButton = (Button) findViewById(R.id.helpButton);

       /* contentView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                //Toggle the start button,

                //then update the UI:
                updateUi();
            }
        });
        */
        //when clicked, will take users to a new menu
        startButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
            // here we'll make our call to execute the Python code, a new activity
            // need to interface w/ bluetooth, and pi

                tv.setText("Start Menu");
                if (i == 0) {
                    i = 1;
                } else {
                    i = 0;
                }
                updateUi();
            }
        });
        settingButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
            // will have access to sensor readings, camera settings/view

                tv.setText("Settings Menu");

            }
        });
        helpButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // simply a contact number in case of fkup

                tv.setText("Help Menu");

            }
        });
        functionButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // users will be able to execute the drive function and other functions
                // first need to open a new menu
                tv.setText("Function Menu");

            }
        });
    }
    private void updateUi(){
        ImageView imageView = (ImageView) findViewById(R.id.powericon);

        //now, P.91, need an if condition, like the button being pressed to update this power image
        if(i == 0)
        {
            int powerIcon = R.drawable.poweroff;
            imageView.setImageResource(powerIcon);
        }else
        {
            int powerIcon = R.drawable.poweron;
            imageView.setImageResource(powerIcon);
        }

    }


    /**
     * A native method that is implemented by the 'native-lib' native library,
     * which is packaged with this application.
     */
    public native String stringFromJNI();

    public void OnStartClick(View view) {
    //from Tutorial 5 Derek Banas
        Intent GetStartConfirmation = new Intent(this, StartScreen.class);

        final int res = 1; // can use as a signal for another time

        GetStartConfirmation.putExtra("homeStart", "MainActivity");
        // This can be used to send data between the activities

        startActivityForResult(GetStartConfirmation, res); //

    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);


    }
}
