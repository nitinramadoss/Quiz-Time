package com.example.nitinr.fblaqtime;

import android.content.Intent;
import android.icu.text.IDNA;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;


import com.facebook.AccessToken;
import com.facebook.CallbackManager;
import com.facebook.FacebookCallback;
import com.facebook.FacebookException;
import com.facebook.login.LoginManager;
import com.facebook.login.LoginResult;
import com.facebook.login.widget.LoginButton;
import com.google.android.gms.auth.api.signin.GoogleSignIn;
import com.google.android.gms.auth.api.signin.GoogleSignInAccount;
import com.google.android.gms.auth.api.signin.GoogleSignInClient;
import com.google.android.gms.auth.api.signin.GoogleSignInOptions;
import com.google.android.gms.common.SignInButton;
import com.google.android.gms.common.api.ApiException;
import com.google.android.gms.tasks.Task;

import java.util.Arrays;
import java.util.Objects;

public class MainActivity extends AppCompatActivity {
    //declaring global variables
    LoginButton signInButton;
    CallbackManager callbackManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        signInButton = findViewById(R.id.login_button);

        //this code is for the Facebook login. When the user clicks the Facebook button, control of the program shifts to the Facebook SDK
        callbackManager = CallbackManager.Factory.create();
        signInButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                LoginManager.getInstance().registerCallback(callbackManager,
                        new FacebookCallback<LoginResult>() {
                            @Override
                            public void onSuccess(LoginResult loginResult) {
                                Toast.makeText(MainActivity.this, "Sign in Success", Toast.LENGTH_SHORT).show();
                            }

                            @Override
                            public void onCancel() {
                                Toast.makeText(MainActivity.this, "Sign in canceled", Toast.LENGTH_SHORT).show();
                            }

                            @Override
                            public void onError(FacebookException exception) {
                                Toast.makeText(MainActivity.this, "Sign in Error!", Toast.LENGTH_SHORT).show();
                            }
                        });

            }
        });


        AccessToken accessToken = AccessToken.getCurrentAccessToken();
        boolean isLoggedIn = accessToken != null && !accessToken.isExpired();
    }
    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        callbackManager.onActivityResult(requestCode, resultCode, data);
        super.onActivityResult(requestCode, resultCode, data);
    }


    //method for transitioning the activities on button click for the home screen
    public void onClick(View v) {

        switch (v.getId()) {
            case R.id.start:
                Intent i0 = new Intent(MainActivity.this, QuizActivity.class);
                startActivity(i0);
                overridePendingTransition(R.anim.fade_in, R.anim.fade_out);
                break;

            case R.id.Info:

                Intent inf = new Intent(MainActivity.this, InfoActivity.class);
                startActivity(inf);
                overridePendingTransition(R.anim.fade_in, R.anim.fade_out);
                break;

        }
    }
}
