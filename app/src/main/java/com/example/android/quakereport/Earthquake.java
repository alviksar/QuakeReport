package com.example.android.quakereport;

import android.support.v4.content.ContextCompat;

import java.text.DateFormat;
import java.text.DecimalFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import static java.security.AccessController.getContext;

/**
 * Created by Alexey on 04.10.2017.
 */

public class Earthquake {

    private static final String LOCATION_SEPARATOR = " of ";
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

    public double getMagnitude() {
        return mMag;
    }

    public String getMagStr() {
        DecimalFormat formatter = new DecimalFormat("0.0");
        return formatter.format(mMag);
    }

    public String getPlace() {
        return mPlace;
    }

    public String getNearThe(String near_the) {
        int i = mPlace.indexOf(LOCATION_SEPARATOR);
        if (i > 0)
            return mPlace.substring(0, i+LOCATION_SEPARATOR.length());
        else
            return near_the;
    }

    public String getPoint() {
        int i = mPlace.indexOf(LOCATION_SEPARATOR);
        if (i > 0)
            return mPlace.substring(i+LOCATION_SEPARATOR.length());
        else
            return mPlace;
    }

    public String getDate() {
        // DateFormat df = new SimpleDateFormat("MM/dd/yyyy HH:mm:ss");
        DateFormat df = new SimpleDateFormat("MMM d, yyyy");
        if (mTime != null)
            return df.format(mTime);
        else
            return "";
    }

    public String getTime() {
        // DateFormat df = new SimpleDateFormat("MM/dd/yyyy HH:mm:ss");
        DateFormat df = new SimpleDateFormat("HH:mm:ss");
        if (mTime != null)
            return df.format(mTime);
        else
            return "";
    }
}
