package com.example.android.quakereport;

import android.content.Context;
import android.support.annotation.LayoutRes;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.content.ContextCompat;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

/**
 * Created by Alexey on 04.10.2017.
 */

public class EarthquakeArrayAdapter extends ArrayAdapter<Earthquake> {

    public EarthquakeArrayAdapter(@NonNull Context context, @LayoutRes int resource, @NonNull List<Earthquake> objects) {
        super(context, 0, objects);
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        // Check if the existing view is being reused, otherwise inflate the view
        View listItemView = convertView;
        if(listItemView == null) {
            listItemView = LayoutInflater.from(getContext()).inflate(
                    R.layout.list_item, parent, false);

          //  int color = ContextCompat.getColor(getContext(), mBackgroundColor);
          //  listItemView.findViewById(R.id.text_container).setBackgroundColor(color);

        }
        // Get the object located at this position in the list
        Earthquake current = getItem(position);

        // Find TextView in the list_item.xml layout
        TextView magView = (TextView) listItemView.findViewById(R.id.mag_text_view);
        TextView placeView = (TextView) listItemView.findViewById(R.id.place_text_view);
        TextView dateView = (TextView) listItemView.findViewById(R.id.date_text_view);


        // Set text on the TextView
        magView.setText(current.getMagStr());
        placeView.setText(current.getPlace());
        dateView.setText(current.getTimeStr());
        /*
        // Find the ImageView in the list_item.xml layout with the ID list_item_icon
        ImageView imageView = (ImageView) listItemView.findViewById(R.id.image4word);
        // Get the image resource ID from the current AndroidFlavor object and
        // set the image to iconView

        if (current.hasImage()) {
            // If an image is available, display the provided image based on the resource ID
            imageView.setImageResource(current.getImageResourceId());
            // Make sure the view is visible
            imageView.setVisibility(View.VISIBLE);
        } else {
            // Otherwise hide the ImageView (set visibility to GONE)
            imageView.setVisibility(View.GONE);
        }
        */
/*
        // Set the theme color for the list item
        View textContainer = listItemView.findViewById(R.id.text_layout);
        // Find the color that the resource ID maps to
        int color = ContextCompat.getColor(getContext(), mBackgroundColor);
        // Set the background color of the text container View
        textContainer.setBackgroundColor(color);
*/
        // Return the whole list item layout (containing 2 TextViews and an ImageView)
        // so that it can be shown in the ListView
        return listItemView;

       // return super.getView(position, convertView, parent);


    }
}
