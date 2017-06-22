package com.bmpl.greetapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    //declare
    EditText nameEditText, salaryEditText;
    Button submit, cancel;
    TextView resultTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //step-1: downcasting

        nameEditText = (EditText) findViewById(R.id.nameEditText);
        salaryEditText = (EditText)findViewById(R.id.salaryEditText);

        submit = (Button)findViewById(R.id.submitButton);
        cancel = (Button)findViewById(R.id.cancelButton);

        resultTextView = (TextView)findViewById(R.id.resultTextView);

        //step-2: attach listener

        submit.setOnClickListener(this);
        cancel.setOnClickListener(this);
    }

    //handler
    @Override
    public void onClick(View view) {

        String name = nameEditText.getText().toString();
        String salary = salaryEditText.getText().toString();

        switch (view.getId())
        {

            case R.id.submitButton:

                if(name.isEmpty() || salary.isEmpty())
                {
                    resultTextView.setText("Please Enter values");
                }
                else

                    resultTextView.setText("Welcome "+ nameEditText.getText() + "\n" + salaryEditText.getText());

                break;

            case R.id.cancelButton:
                nameEditText.setText("");
                salaryEditText.setText("");
                resultTextView.setText("");
                break;

        }

    }
}