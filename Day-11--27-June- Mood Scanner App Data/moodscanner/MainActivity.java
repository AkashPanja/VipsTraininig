package com.bmpl.moodscanner;

import android.graphics.drawable.AnimationDrawable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    TextView resultTextView;
    ImageView fingerPrint;
    AnimationDrawable animationDrawable;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        resultTextView = (TextView)findViewById(R.id.resultTextView);
        fingerPrint = (ImageView)findViewById(R.id.fingerPrintImageView);

        fingerPrint.setBackgroundResource(R.drawable.animation_effects);

        animationDrawable = (AnimationDrawable) fingerPrint.getBackground();

        fingerPrint.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View view) {
                animationDrawable.start();//animation start

                return true;
            }
        });
    }
}





