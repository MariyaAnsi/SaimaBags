package com.example.saimabags;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;

public class Forgetpassword extends AppCompatActivity {

    private Button resetpasswordButton;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_forgetpassword);
        Window window = getWindow();
        window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS);
        window.setStatusBarColor(getResources().getColor(R.color.yellow));

        resetpasswordButton = (Button) findViewById(R.id.resetpasswordButton);

        resetpasswordButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final Intent i = new Intent(Forgetpassword.this,Netissue.class);
                startActivity(i);
            }
        });


    }
}
