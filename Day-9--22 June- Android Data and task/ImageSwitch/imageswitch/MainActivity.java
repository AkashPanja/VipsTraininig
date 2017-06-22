package com.bmpl.imageswitch;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    //declare
    Button imageOneButton, imageTwoButton;
    ImageView imageView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        imageOneButton = (Button)findViewById(R.id.imageOneButton);
        imageTwoButton = (Button)findViewById(R.id.imageTwoButton);
        imageView = (ImageView)findViewById(R.id.imageView);


        imageOneButton.setOnClickListener(this);
        imageTwoButton.setOnClickListener(this);


    }

    @Override
    public void onClick(View view) {

        switch (view.getId()){
            case R.id.imageOneButton:
                imageView.setImageResource(R.drawable.images1);
                imageOneButton.setVisibility(View.INVISIBLE);
                break;

            case R.id.imageTwoButton:
                imageView.setImageResource(R.drawable.images2);
                break;
        }

    }
}




