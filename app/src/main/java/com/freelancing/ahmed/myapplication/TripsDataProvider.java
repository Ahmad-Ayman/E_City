    package com.freelancing.ahmed.myapplication;

import android.graphics.Bitmap;

/**
 * Created by ahmed on 9/2/2017.
 */

public class TripsDataProvider {


    private String title, shortD, longD,longD2;
    private Bitmap img_front, img1, img2;

    public TripsDataProvider(String title, String shortD, String longD, String longD2, Bitmap img_front, Bitmap img1, Bitmap img2) {
        this.title = title;
        this.shortD = shortD;
        this.longD = longD;
        this.longD2 = longD2;
        this.img_front = img_front;
        this.img1 = img1;
        this.img2 = img2;
    }

    public String getTitle() {
        return title;
    }

    public String getShortD() {
        return shortD;
    }

    public String getLongD() {
        return longD;
    }

    public String getLongD2(){return longD2; }

    public Bitmap getImg_front() {
        return img_front;
    }

    public Bitmap getImg1() {
        return img1;
    }

    public Bitmap getImg2() {
        return img2;
    }
}