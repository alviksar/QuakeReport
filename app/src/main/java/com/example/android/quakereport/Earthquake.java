package com.example.android.quakereport;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by Alexey on 04.10.2017.
 */

public class Earthquake {

    private double mMag;
    private String mPlace;
    private Date mTime;

    public Earthquake(double mag, String place, String dateStr) {
        this.mMag = mag;
        this.mPlace = place;
        try {
            DateFormat df = new SimpleDateFormat("yyyy-MM-dd");
            mTime = new Date();
            mTime = df.parse(dateStr);
        } catch (ParseException pe) {
            pe.printStackTrace();
        }
    }

    public Earthquake(double mag, String place, long time) {
        this.mMag = mag;
        this.mPlace = place;
        this.mTime = new Date(time);
    }

    public String getMagStr() {
        return String.valueOf(mMag);
    }

    public String getPlace() {
        return mPlace;
    }

    public String getTimeStr() {
        // DateFormat df = new SimpleDateFormat("MM/dd/yyyy HH:mm:ss");
        DateFormat df = new SimpleDateFormat("MMM d, yyyy");
        if (mTime != null)
            return df.format(mTime);
        else
            return "";
    }
}
