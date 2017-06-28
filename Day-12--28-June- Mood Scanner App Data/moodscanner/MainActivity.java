package com.bmpl.moodscanner;

import android.graphics.drawable.AnimationDrawable;
import android.os.Handler;
import android.os.Vibrator;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.Random;

public class MainActivity extends AppCompatActivity {

    private TextView resultTextView;
    private ImageView fingerPrint;
    private AnimationDrawable animationDrawable;
    private Handler handler;
    private static final int TIME_DELAY = 2000;
    private String mood[] = {"Eating", "Flying in Dreams",
                            "Want to take a nap", "Coding"};
    private Random random;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        resultTextView = (TextView)findViewById(R.id.resultTextView);
        fingerPrint = (ImageView)findViewById(R.id.fingerPrintImageView);

        handler = new Handler();
        random = new Random();
        fingerPrint.setBackgroundResource(R.drawable.animation_effects);

        animationDrawable = (AnimationDrawable) fingerPrint.getBackground();

        fingerPrint.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View view) {

                animationDrawable.start();//animation start
                Vibrator vibrator = (Vibrator) getSystemService(VIBRATOR_SERVICE);
                vibrator.vibrate(1000);

                handler.postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        resultTextView.setText(mood[random.nextInt(4)]);
                        animationDrawable.stop();
                    }
                },TIME_DELAY);
                return true;
            }
        });
    }
}