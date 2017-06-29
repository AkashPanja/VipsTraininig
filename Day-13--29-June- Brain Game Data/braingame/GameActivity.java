package com.bmpl.braingame;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

public class GameActivity extends AppCompatActivity{

    TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game);

        textView = (TextView)findViewById(R.id.textView);
	
	//Step-4: Create Object of Intent class to receive data
        Intent intent = getIntent();
	
	//Step-5: Extract data and set it to proper widget
        textView.setText(intent.getStringExtra("button"));
    }
}