package com.example.android.polystore;

import android.Manifest;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.ActivityCompat;
import android.support.v7.app.AppCompatActivity;
import android.test.mock.MockPackageManager;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import com.example.android.polystore.location.GPSTracker;

import util.Utils;

public class LoginActivity extends AppCompatActivity {

    private static final String TAG = LoginActivity.class.getSimpleName();
    EditText mUserName, mPassword;
    TextView mForgotPassword;
    Button mLogin, mRegister;
    ImageView mFacebook, mTwitter, mLinkedin, mInstagram, mGooglePlus;
    private ProgressBar progressBar;


    private String userId;
    private static final int REQUEST_CODE_PERMISSION = 2;
    String mPermission = Manifest.permission.ACCESS_FINE_LOCATION;

    GPSTracker gps;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);


        try {
            if (ActivityCompat.checkSelfPermission(this, mPermission)
                    != MockPackageManager.PERMISSION_GRANTED) {

                ActivityCompat.requestPermissions(this, new String[]{mPermission},
                        REQUEST_CODE_PERMISSION);


            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        gps = new GPSTracker(LoginActivity.this);

        if(gps.canGetLocation()){

            double latitude = gps.getLatitude();
            double longitude = gps.getLongitude();

            // \n is for new line
            Toast.makeText(getApplicationContext(), "Your Location is - \nLat: "
                    + latitude + "\nLong: " + longitude, Toast.LENGTH_LONG).show();
        }else{

            gps.showSettingsAlert();
        }


        Utils.darkenStatusBar(this, R.color.colorPrimaryDark);

        mUserName = (EditText) findViewById(R.id.user_name);
        mPassword = (EditText) findViewById(R.id.password);
        mForgotPassword = (TextView) findViewById(R.id.forgot_password);
        mLogin = (Button) findViewById(R.id.sign_in);
        mFacebook = (ImageView) findViewById(R.id.facebook);
        mTwitter = (ImageView) findViewById(R.id.twitter);
        mLinkedin = (ImageView) findViewById(R.id.linked_in);
        mInstagram = (ImageView) findViewById(R.id.instagram);
        mGooglePlus = (ImageView) findViewById(R.id.google_plus);
        progressBar = (ProgressBar) findViewById(R.id.progressBar);

        mRegister = (Button) findViewById(R.id.register);

        mLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String email = mUserName.getText().toString();
                final String password = mPassword.getText().toString();

                if (TextUtils.isEmpty(email)) {
                    Toast.makeText(getApplicationContext(), "Enter email address!", Toast.LENGTH_SHORT).show();
                    return;
                }

                if (TextUtils.isEmpty(password)) {
                    Toast.makeText(getApplicationContext(), "Enter password!", Toast.LENGTH_SHORT).show();
                    return;
                }

                progressBar.setVisibility(View.VISIBLE);
                Intent intent = new Intent(LoginActivity.this, NavigationHome.class);
                startActivity(intent);
                finish();

            }


        });

        mRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(LoginActivity.this, RegisterActivity.class));
            }
        });

        mForgotPassword.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(LoginActivity.this, ForgotPassword.class));
            }
        });
    }


}


