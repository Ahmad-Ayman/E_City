package com.freelancing.ahmed.myapplication;

import android.graphics.Typeface;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import org.w3c.dom.Text;

public class DataVieweer2 extends AppCompatActivity {

    int s;
    int ss;
    TripsDataProvider2 tdp;
    AppDataCenter2 adc;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_data_vieweer2);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        s= getIntent().getIntExtra("position",0);
        // Sightseeing
        adc= new AppDataCenter2(this);
        tdp=adc.getTripsItems().get(s);
        TextView title=(TextView)findViewById(R.id.textView2);

        TextView desc=(TextView)findViewById(R.id.textView3);
        TextView desc2=(TextView) findViewById(R.id.textView4) ;
        ImageView img1=(ImageView) findViewById(R.id.imageView4);

        ImageView img2=(ImageView)findViewById(R.id.imageView3);
        title.setText(tdp.getTitle());
        desc.setText(tdp.getLongD());
        desc2.setText(tdp.getLongD2());
        img1.setImageBitmap(tdp.getImg1());
        img2.setImageBitmap(tdp.getImg2());
        Typeface myTypeface = Typeface.createFromAsset(getAssets(),"lalezar.ttf");
        desc.setTypeface(myTypeface);
        desc2.setTypeface(myTypeface);
        title.setTypeface(myTypeface);
    }
}
