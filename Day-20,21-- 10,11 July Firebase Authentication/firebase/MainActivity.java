package com.bmpl.firebase;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private FirebaseAuth mAuth;

    EditText emailEditText,passwordEditText;
    Button loginButton, registerButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mAuth = FirebaseAuth.getInstance();

        emailEditText = (EditText)findViewById(R.id.emailEditText);
        passwordEditText = (EditText)findViewById(R.id.passwordEditText);

        loginButton = (Button)findViewById(R.id.loginButton);

        registerButton = (Button)findViewById(R.id.registerButton);

        loginButton.setOnClickListener(this);
        registerButton.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {

        switch (view.getId()){

            case R.id.loginButton:

                String email = emailEditText.getText().toString();
                String password = passwordEditText.getText().toString();

                mAuth.signInWithEmailAndPassword(email, password)
                        .addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
                            @Override
                            public void onComplete(@NonNull Task<AuthResult> task) {
                                Log.d("MainActivity", "signInWithEmail:onComplete:" + task.isSuccessful());

                                Intent intent = new Intent(MainActivity.this, RegisterActivity.class);
                                startActivity(intent);

                                if (!task.isSuccessful()) {
                                    Log.w("MainActivity", "signInWithEmail:failed", task.getException());
                                    Toast.makeText(MainActivity.this, "Sign in failed",
                                            Toast.LENGTH_SHORT).show();
                                }

                            }
                        });

                break;

            case R.id.registerButton:
                Intent intent = new Intent(MainActivity.this, RegisterActivity.class);
                startActivity(intent);

                break;
        }
    }
}
