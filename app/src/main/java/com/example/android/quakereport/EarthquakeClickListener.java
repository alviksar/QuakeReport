package com.example.android.quakereport;

import android.content.Context;
import android.content.Intent;
import android.media.MediaPlayer;
import android.net.Uri;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

/**
 * Created by Alexey on 05.10.2017.
 */

public class EarthquakeClickListener implements ListView.OnItemClickListener {

    private Context mContext;

    public EarthquakeClickListener(Context context) {
        this.mContext = context;
    }

    @Override
    public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
        Intent intent = new Intent(Intent.ACTION_VIEW);
        Earthquake e = (Earthquake) adapterView.getItemAtPosition(i);
        intent.setData(Uri.parse(e.getUrl()));
        mContext.startActivity(intent);
        /*
         // Find the current earthquake that was clicked on
         Earthquake currentEarthquake = adapter.getItem(position);

         // Convert the String URL into a URI object (to pass into the Intent constructor)
         Uri earthquakeUri = Uri.parse(currentEarthquake.getUrl());

         // Create a new intent to view the earthquake URI
         Intent websiteIntent = new Intent(Intent.ACTION_VIEW, earthquakeUri);

         // Send the intent to launch a new activity
         startActivity(websiteIntent)
         */
    }

}
