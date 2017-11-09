package com.freelancing.ahmed.myapplication;

import android.content.Intent;
import android.graphics.Typeface;
import android.net.Uri;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.TextView;

public class NextActivity extends AppCompatActivity {
    FloatingActionButton fab,fab_fb,fab_tw,fab2,fab_police,fab_ambulance;
    Animation fabOpen,fabClose,fabRotate1,fabRotate2;
    boolean isOpen=false;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_next);
        Typeface myTypeface = Typeface.createFromAsset(getAssets(),"lalezar.ttf");
        TextView txt = (TextView) findViewById(R.id.titlee);
        txt.setTypeface(myTypeface);
        txt.setTextSize(45);
        TextView txt2 = (TextView) findViewById(R.id.textView8);
        txt2.setTypeface(myTypeface);
        txt2.setTextSize(20);
          fab= (FloatingActionButton) findViewById(R.id.fab);
        fab_fb=(FloatingActionButton) findViewById(R.id.fab_fb);
        fab_tw=(FloatingActionButton) findViewById(R.id.fab_twitter);
        fabOpen = AnimationUtils.loadAnimation(getApplicationContext(),R.anim.fab_open);
        fabClose = AnimationUtils.loadAnimation(getApplicationContext(),R.anim.fab_close);
        fabRotate1= AnimationUtils.loadAnimation(getApplicationContext(),R.anim.rotate_clockwise);
        fabRotate2 = AnimationUtils.loadAnimation(getApplicationContext(),R.anim.rotate_anticlockwise);
        final FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
               // Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                      //  .setAction("Action", null).show();
                if (isOpen){
                    fab_fb.startAnimation(fabClose);
                    fab_tw.startAnimation(fabClose);
                    fab.startAnimation(fabRotate2);
                    fab_fb.setClickable(false);
                    fab_tw.setClickable(false);
                    isOpen=false;
                }else{
                fab_fb.startAnimation(fabOpen);
                  fab_tw.startAnimation(fabOpen);
                    fab.startAnimation(fabRotate1);
                    fab_fb.setClickable(true);
                    fab_tw.setClickable(true);
                    isOpen=true;
                }
            }
        });
        fab_fb.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                GoToURL("https://www.facebook.com/");
            }
        });
        fab_tw.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                GoToURL("https://www.twitter.com/");
            }
        });



      //  getSupportActionBar().setDisplayHomeAsUpEnabled(true);
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
    }

    public void GoToURL(String url){
        Intent i = new Intent(Intent.ACTION_VIEW);
        i.setData(Uri.parse(url));
        startActivity(i);
    }
}