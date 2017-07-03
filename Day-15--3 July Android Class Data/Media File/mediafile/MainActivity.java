package com.bmpl.mediafile;

import android.media.MediaPlayer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    //MediaPlayer class
    MediaPlayer mediaPlayer;
    Button playButton, pauseButton, stopButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        playButton = (Button)findViewById(R.id.playButton);
        pauseButton = (Button)findViewById(R.id.pauseButton);
        stopButton = (Button)findViewById(R.id.stopButton);

        mediaPlayer  = MediaPlayer.create(this, R.raw.background_music);

        playButton.setOnClickListener(this);
        pauseButton.setOnClickListener(this);
        stopButton.setOnClickListener(this);


    }

    @Override
    public void onClick(View view) {

        switch (view.getId()){
            case R.id.playButton:
                mediaPlayer.start();
                break;

            case R.id.pauseButton:
                mediaPlayer.pause();
                break;

            case R.id.stopButton:
                mediaPlayer.stop();
                break;

        }

    }
}




