package com.foodie.grv.foodie;

import android.content.Intent;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.Signature;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Base64;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;


/**
 * Created by gaurav on 24/05/17.
 */

public class UserLogin extends AppCompatActivity implements View.OnClickListener {

    Button facebook_login;
    Button google_login;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.user_login);

        getKeyHash();

        facebook_login = (Button) findViewById(R.id.user_facebook);
        google_login = (Button) findViewById(R.id.user_google);

        TextView skip = (TextView) findViewById(R.id.skip);

        skip.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
                Intent intent = new Intent(UserLogin.this,MainActivity.class);
                startActivity(intent);
            }
        });

        facebook_login.setOnClickListener(this);
        google_login.setOnClickListener(this);

    }

    public void getKeyHash(){

        /**
         * Now you need to Get Key Hash Value for your machine. The key hash value is used by Facebook as security check for login.
         * To get key hash value of your machine, write following code in onCreate() method of
         */

        try {
            PackageInfo packageInfo = getPackageManager().getPackageInfo(getPackageName(), PackageManager.GET_SIGNATURES);

            for (Signature signature : packageInfo.signatures){
                MessageDigest md = MessageDigest.getInstance("SHA");
                md.update(signature.toByteArray());
                Log.d("KeyHash: ", Base64.encodeToString(md.digest(), Base64.DEFAULT));
            }
        }catch (PackageManager.NameNotFoundException e){
            e.printStackTrace();
        }catch (NoSuchAlgorithmException e){
            e.printStackTrace();
        }

        /**
         * Ending key hash part
         */

    }


    @Override
    public void onClick(View v) {
        if(v == facebook_login){
            facebookUserInfo();
        }else if(v == google_login){
            googleUserInfo();
        }
    }


    private void facebookUserInfo(){

    }

    private void googleUserInfo(){

    }

}
