package com.bmpl.braingame;

import android.content.Intent;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

public class GameActivity extends AppCompatActivity{

    TextView timerTextView;

    /*TextView textView;*/
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game);

        timerTextView = (TextView)findViewById(R.id.timerTextView);

        timer();
        /*textView = (TextView)findViewById(R.id.textView);
        Intent intent = getIntent();
        textView.setText(intent.getStringExtra("button"));*/
    }

    void timer(){

        CountDownTimer countDownTimer = new CountDownTimer(31000, 1000) {
            @Override
            public void onTick(long l) {
                timerTextView.setText(String.valueOf(l/1000));
            }

            @Override
            public void onFinish() {
                //explicit intent
                Intent intent = new Intent(GameActivity.this, ScoreActivity.class);
                startActivity(intent);
                finish();
            }
        }.start();
    }
}