package com.bmpl.bluetooth;

import android.bluetooth.BluetoothAdapter;
import android.bluetooth.BluetoothDevice;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.ListView;
import android.widget.Switch;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Set;

public class MainActivity extends AppCompatActivity {

    BluetoothAdapter bluetoothAdapter;
    ArrayList arrayList;

    ArrayAdapter arrayAdapter;

    //Set will remove duplicate elements
    // and keep only unique elements
    Set<BluetoothDevice> bluetoothDevice;

    Switch aSwitch;
    Button visibleButton, pairedDeviceButton;
    ListView listView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        visibleButton = (Button)findViewById(R.id.visibleButton);
        pairedDeviceButton = (Button)findViewById(R.id.pairedDevices);
        listView = (ListView)findViewById(R.id.listView);

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

        visibleButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intent = new Intent(BluetoothAdapter.ACTION_REQUEST_DISCOVERABLE);
                intent.putExtra(BluetoothAdapter.EXTRA_DISCOVERABLE_DURATION, 1000);
                startActivity(intent);
            }
        });

        pairedDeviceButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                bluetoothDevice = bluetoothAdapter.getBondedDevices();

                arrayList = new ArrayList();
                //enhanced for loop

                for(BluetoothDevice tempBluetoothDevice : bluetoothDevice){
                    arrayList.add(tempBluetoothDevice.getName());
                }
                arrayAdapter = new ArrayAdapter(MainActivity.this, R.layout.support_simple_spinner_dropdown_item, arrayList);
                listView.setAdapter(arrayAdapter);
            }
        });
    }
}