package com.example.piotr.userinterface;

import android.bluetooth.BluetoothAdapter;
import android.bluetooth.BluetoothDevice;
import android.content.BroadcastReceiver;
import android.content.Intent;
import android.content.Context;
import android.content.IntentFilter;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.app.ActionBar;
import android.os.Bundle;
import android.util.Log;
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

    private static final String TAG = "MainActivity";
    BluetoothAdapter mBluetoothAdapter;

    static {
        System.loadLibrary("native-lib");
    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button connect_paintbot = (Button) findViewById(R.id.connect_paintbot);
        mBluetoothAdapter = BluetoothAdapter.getDefaultAdapter();

        connect_paintbot.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.d(TAG, "onClick: enabling/disabling BT");
                enabledisableBT();
            }
        });

    }

    private final BroadcastReceiver mBroadcastReceiver1 = new BroadcastReceiver() {
        public void onReceive(Context context, Intent intent) {
            String action = intent.getAction();
            if (action.equals(mBluetoothAdapter.ACTION_STATE_CHANGED)) {
                final int state = intent.getIntExtra(BluetoothAdapter.EXTRA_STATE, mBluetoothAdapter.ERROR);

                switch(state){
                    case BluetoothAdapter.STATE_OFF:
                        Log.d(TAG, "onReceive: STATE OFF");
                        break;
                    case BluetoothAdapter.STATE_TURNING_OFF:
                        Log.d(TAG, "mBoradCastReceiver1: STATE TURNING OFF");
                        break;
                    case BluetoothAdapter.STATE_ON:
                        Log.d(TAG, "mBoradCastReceiver1: STATE ON");
                        break;
                    case BluetoothAdapter.STATE_TURNING_ON:
                        Log.d(TAG, "mBoradCastReceiver1: STATE TURNING ON");
                        break;
                }

                // Discovery has found a device. Get the BluetoothDevice
                // object and its info from the Intent.

            }
        }
    };
    public void enabledisableBT()
    {
        if(mBluetoothAdapter == null)
        {
            Log.d(TAG, "enableDisableBT does not have BT capabilities");
        }
        if(!mBluetoothAdapter.isEnabled())
        {
            Log.d(TAG,"enabledisableBT():enabling");
            Intent enableBTIntent = new Intent(BluetoothAdapter.ACTION_REQUEST_ENABLE);
            startActivity(enableBTIntent);

            IntentFilter BTIntent = new IntentFilter(BluetoothAdapter.ACTION_STATE_CHANGED);
            registerReceiver(mBroadcastReceiver1, BTIntent);
        }
        if(mBluetoothAdapter.isEnabled())
        {
            Log.d(TAG,"enabledisableBT():disabling");
            mBluetoothAdapter.disable();

            IntentFilter BTIntent = new IntentFilter(BluetoothAdapter.ACTION_STATE_CHANGED);
            registerReceiver(mBroadcastReceiver1, BTIntent);
        }
    }
    @Override
    protected void onDestroy() {
        Log.d(TAG, "Destroy called");
        super.onDestroy();
        unregisterReceiver(mBroadcastReceiver1);
    }


    public void OnStartClick(View view) {
    //from Tutorial 5 Derek Banas
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
