package com.foodie.grv.foodie;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageView;

import java.util.Timer;
import java.util.TimerTask;

import jp.wasabeef.blurry.Blurry;

/**
 * Created by gaurav on 22/05/17.
 */

public class SplashActivity extends AppCompatActivity {

    long delay = 5000;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.splash_activity);

        findViewById(R.id.content).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Blurry.with(getApplicationContext())
                        .radius(25)
                        .sampling(1)
                        .async()
                        .animate(500)
                        .capture(findViewById(R.id.content))
                        .into((ImageView) findViewById(R.id.content));
            }
        });


        Timer runSplash = new Timer();
        TimerTask showSplash = new TimerTask() {
            @Override
            public void run() {
                finish();
                startActivity(new Intent(SplashActivity.this,UserLogin.class));
            }
        };

        runSplash.schedule(showSplash,delay);
    }
}
