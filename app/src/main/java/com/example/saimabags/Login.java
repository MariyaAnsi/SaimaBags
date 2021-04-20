package com.example.saimabags;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;

public class Login extends AppCompatActivity {

    private EditText loginEmailInputText,loginPasswordInputText;
    private Button loginButton,loginsignupButton,loginresetButton;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        Window window = getWindow();
        window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS);
        window.setStatusBarColor(getResources().getColor(R.color.yellow));

        loginEmailInputText = (EditText) findViewById(R.id.loginEmailInputText);
        loginPasswordInputText = (EditText) findViewById(R.id.loginPasswordInputText);
        loginButton = (Button) findViewById(R.id.loginButton);
        loginsignupButton = (Button) findViewById(R.id.loginsignupButton);
        loginresetButton = (Button) findViewById(R.id.loginresetButton);

        loginButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                validateEmail();
                validatepassword();

            }
        });
        loginsignupButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final Intent i = new Intent(Login.this,Signup.class);
                startActivity(i);
            }
        });
        loginresetButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final Intent i = new Intent(Login.this,Forgetpassword.class);
                startActivity(i);
            }
        });
    }

    private boolean validateEmail() {
        String emailInput = loginEmailInputText.getText().toString().trim();
        if (emailInput.isEmpty()) {
            loginEmailInputText.setError("Field can't be empty");
            return false;
        } else {
            loginEmailInputText.setError(null);
            return true;
        }
    }
    private boolean validatepassword() {
        String passwordInput = loginPasswordInputText.getText().toString().trim();
        if (passwordInput.isEmpty()) {
            loginPasswordInputText.setError("Field can't be empty");
            return false;
        }else {
            loginPasswordInputText.setError(null);
            return true;
        }
    }
}
