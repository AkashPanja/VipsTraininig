package com.bmpl.braingame;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class FirstActivity extends AppCompatActivity {

    Button startButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_first);

        startButton = (Button)findViewById(R.id.startButton);

        startButton.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view) {
                //explicit intent--> source and destination
                String data = startButton.getText().toString();
                Intent intent = new Intent(FirstActivity.this, GameActivity.class);
                intent.putExtra("button", data);// key and value
                startActivity(intent);
            }
        });

    }
}







