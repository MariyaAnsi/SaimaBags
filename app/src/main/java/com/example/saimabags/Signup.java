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

public class Signup extends AppCompatActivity {

    private Button gotologinpage,signupButton;
    private EditText signupusernameInputText,signupEmailInputText,signupphoneInputText,signuppasswordInputText,signuprepasswordInputText;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup);
        Window window = getWindow();
        window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS);
        window.setStatusBarColor(getResources().getColor(R.color.yellow));

        gotologinpage = (Button) findViewById(R.id.gotologinpage);
        signupButton = (Button) findViewById(R.id.signupButton);
        signupusernameInputText = (EditText) findViewById(R.id.signupusernameInputText);
        signupEmailInputText = (EditText) findViewById(R.id.signupEmailInputText);
        signupphoneInputText = (EditText) findViewById(R.id.signupphoneInputText);
        signuppasswordInputText = (EditText) findViewById(R.id.signuppasswordInputText);
        signuprepasswordInputText = (EditText) findViewById(R.id.signuprepasswordInputText);

        gotologinpage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final Intent i = new Intent(Signup.this,Login.class);
                startActivity(i);
            }
        });

        signupButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                validateusername();
            }
        });
    }

    private boolean validateusername() {
        String emailInput = signupusernameInputText.getText().toString().trim();
        if (emailInput.isEmpty()) {
            signupusernameInputText.setError("Field can't be empty");
            return false;
        } else {
            signupusernameInputText.setError(null);
            return true;
        }
    }
}
