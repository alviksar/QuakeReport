package com.example.android.quakereport;

import java.text.DateFormat;
import java.text.FieldPosition;
import java.text.ParseException;
import java.text.ParsePosition;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/**
 * Created by Alexey on 04.10.2017.
 */

public class Earthquake {

    public Earthquake(double mag, String place, String dateStr) {
        this.mag = mag;
        this.place = place;
        try {
            DateFormat df = new SimpleDateFormat("yyyy-MM-dd");
            time = new Date();
            time = df.parse(dateStr);
        } catch (ParseException pe) {
            pe.printStackTrace();
        }
    }

    private double mag;
    private String place;
    private Date time;
    private long updated;
    private int tz;
    private double longitude;
    private double latitude;
    private double depth;

    public String getMagStr() {
        return String.valueOf(mag);
    }

    public String getPlace() {
        return place;
    }

    public String getTimeStr() {
        // DateFormat df = new SimpleDateFormat("MM/dd/yyyy HH:mm:ss");
        DateFormat df = new SimpleDateFormat("MMM d, yyyy");
        if (time != null)
            return df.format(time);
        else
            return "";
    }
}
