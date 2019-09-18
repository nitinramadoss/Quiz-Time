package com.example.nitinr.fblaqtime;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.VideoView;


import com.facebook.share.model.ShareLinkContent;
import com.facebook.share.widget.ShareDialog;

import java.util.Objects;

public class PopUpActivity extends AppCompatActivity {

    Button shareButton;

    int score;

    @SuppressLint({"SetTextI18n", "WrongViewCast"})
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pop_up);
        shrinkScreen();

        //when user presses the Share button, control of the program shifts to the Facebook SDK to allow the user to send a post to Facebook
        shareButton = findViewById(R.id.share_button);
        shareButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(PopUpActivity.this, "Share your score and review!",Toast.LENGTH_LONG ).show();
                ShareLinkContent shareLinkContent = new ShareLinkContent.Builder()
                        .setContentUrl(Uri.parse("https://www.fbla-pbl.org/"))
                        .build();
                ShareDialog.show(PopUpActivity.this,shareLinkContent);
            }
        });

        TextView scoreBoard = (TextView) findViewById(R.id.tvscore);
        score = getIntent().getIntExtra("participantScore", 0); //captures score from previous activity in order to display it
        scoreBoard.setText("Your Score is \n " + score + " \n out of 25"); //display score with a text view

    }



    //method to shrink the screen size of the popup activity that contains the score the participant received
    public void shrinkScreen(){
        DisplayMetrics dm = new DisplayMetrics();
        getWindowManager().getDefaultDisplay().getMetrics(dm);

        int w = dm.widthPixels;
        int h = dm.heightPixels;

        getWindow().setLayout((int)(w*.8),(int)(h*.6));
    }

}
