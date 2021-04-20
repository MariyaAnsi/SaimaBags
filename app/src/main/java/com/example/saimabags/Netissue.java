package com.example.saimabags;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class Netissue extends AppCompatActivity {

    private Button checkNetwork;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_netissue);

        checkNetwork = (Button) findViewById(R.id.checkNetwork);

        checkNetwork.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                checkNetworkConnectionStatus();
            }
        });
    }

    private void checkNetworkConnectionStatus() {

        boolean wifiConnected;
        boolean mobileConnected;
        ConnectivityManager connMgr = (ConnectivityManager)
                getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo activeInfo = connMgr.getActiveNetworkInfo();
        if (activeInfo != null && activeInfo.isConnected()){ //connected with either mobile or wifi
            wifiConnected = activeInfo.getType() == ConnectivityManager.TYPE_WIFI;
            mobileConnected = activeInfo.getType() == ConnectivityManager.TYPE_MOBILE;
            if (wifiConnected || mobileConnected ){ //wifi connected

                //Toast.makeText(loader.this,"Network connection is available!",Toast.LENGTH_SHORT).show();
                final Intent i = new Intent(this,Login.class);
                startActivity(i);

            }

        }
        else { //no internet connection
            Toast.makeText(Netissue.this,"Network connection is not available!",Toast.LENGTH_SHORT).show();
        }
    }
}
