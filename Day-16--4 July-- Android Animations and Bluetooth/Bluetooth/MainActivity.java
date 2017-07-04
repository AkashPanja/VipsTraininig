package com.bmpl.bluetooth;

import android.bluetooth.BluetoothAdapter;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.CompoundButton;
import android.widget.Switch;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    BluetoothAdapter bluetoothAdapter;

    Switch aSwitch;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        aSwitch = (Switch)findViewById(R.id.bluetoothSwitch);
        //get bluetooth driver information
        bluetoothAdapter = BluetoothAdapter.getDefaultAdapter();

        aSwitch.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {

                if(bluetoothAdapter == null){
                    Toast.makeText(MainActivity.this, "Bluetooth Driver is not available", Toast.LENGTH_LONG).show();
                }
                else if(!bluetoothAdapter.isEnabled()){
                    Intent intent = new Intent(BluetoothAdapter.ACTION_REQUEST_ENABLE);
                    startActivity(intent);
                    Toast.makeText(MainActivity.this, "Bluetooth On", Toast.LENGTH_LONG).show();
                } else {
                    //bluetooth off

                }

            }
        });
    }
}
