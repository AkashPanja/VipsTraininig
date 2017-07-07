package com.bmpl.splashscreen;

import android.content.DialogInterface;
import android.content.SharedPreferences;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    EditText nameEditText, passwordEditText;
    Button submitButton, cancelButton;
    TextView resultTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        nameEditText = (EditText)findViewById(R.id.nameEditText);
        passwordEditText = (EditText)findViewById(R.id.passwordEditText);

        submitButton = (Button)findViewById(R.id.submitButton);
        cancelButton = (Button)findViewById(R.id.cancelButton);
        resultTextView = (TextView)findViewById(R.id.loginDetailsTextView);
        submitButton.setOnClickListener(this);
        cancelButton.setOnClickListener(this);
        readData();
    }

    @Override
    public void onClick(View view) {
        switch(view.getId()){

            case R.id.submitButton:

                //data store--> shared preference
                //String name--> file name
                // int mode--> Mode_Private / Mode_Append
                SharedPreferences sharedPreferences = getSharedPreferences("user_details", MODE_PRIVATE);
                SharedPreferences.Editor editor = sharedPreferences.edit();
                editor.putString("name", nameEditText.getText().toString());
                editor.putString("password", passwordEditText.getText().toString());
                editor.commit();

                final AlertDialog.Builder alertDialog = new AlertDialog.Builder(this);

                alertDialog.setTitle("Saved");

                alertDialog.setMessage("Your data is saved");

                alertDialog.setIcon(R.mipmap.ic_launcher);

                alertDialog.setCancelable(false);

                alertDialog.setNeutralButton("OK", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        onResume();
                    }
                });
                alertDialog.show();
                break;

            case R.id.cancelButton:


                break;
        }
    }

    private void readData(){
        SharedPreferences sharedPreferences = getSharedPreferences("user_details", MODE_PRIVATE);
        resultTextView.setText(sharedPreferences.getString("name", "") +
                                "\n" + sharedPreferences.getString("password", ""));

    }
}