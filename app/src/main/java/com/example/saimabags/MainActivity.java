package com.example.saimabags;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Bundle;
import android.view.Window;
import android.view.WindowManager;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import pl.droidsonroids.gif.GifImageView;

public class MainActivity extends AppCompatActivity {

    private GifImageView splashlogo,loader;
    private TextView splashsaimaText,splashbagsText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //status bar color change
        Window window = getWindow();
        window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS);
        window.setStatusBarColor(Color.WHITE);

        splashlogo = (GifImageView) findViewById(R.id.splashlogo) ;
        splashsaimaText = (TextView) findViewById(R.id.splashsaimaText) ;
        splashbagsText = (TextView) findViewById(R.id.splashbagsText) ;
        loader = (GifImageView) findViewById(R.id.loader);

        //text animation
        Animation myanim = AnimationUtils.loadAnimation(this,R.anim.frombottom);
        myanim.setFillAfter(true);
        splashlogo.startAnimation(myanim);

        Animation mysanim = AnimationUtils.loadAnimation(this,R.anim.myslowtransition);
        mysanim.setFillAfter(true);
        splashsaimaText.startAnimation(mysanim);
        splashbagsText.startAnimation(mysanim);


        checkNetworkConnectionStatus(); // network check function




    }
    // network check function
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
                Thread timer = new Thread(){
                    public void run(){
                        try {
                            sleep(6000);


                        }catch (InterruptedException e){

                            e.printStackTrace();

                        }
                        finally{
                            startActivity(i);
                            finish();
                        }
                    }

                };
                timer.start();
            }

        }
        else { //no internet connection
            Toast.makeText(MainActivity.this,"Network connection is not available!",Toast.LENGTH_SHORT).show();
            final Intent i = new Intent(this,Netissue.class);
            Thread timer = new Thread(){
                public void run(){
                    try {
                        sleep(3000);


                    }catch (InterruptedException e){

                        e.printStackTrace();

                    }
                    finally{
                        startActivity(i);
                        finish();
                    }
                }

            };
            timer.start();
        }
    }
}
