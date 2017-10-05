package com.example.android.quakereport;

import android.content.Context;
import android.graphics.drawable.GradientDrawable;
import android.support.annotation.LayoutRes;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.content.ContextCompat;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.List;

/**
 * Created by Alexey on 04.10.2017.
 */

public class EarthquakeArrayAdapter extends ArrayAdapter<Earthquake> {

    Context mContext;

    public EarthquakeArrayAdapter(@NonNull Context context, @LayoutRes int resource, @NonNull List<Earthquake> objects) {
        super(context, 0, objects);
        mContext = context;
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

        // Find TextView in the my_list_item.xmlxml layout
        TextView magView = (TextView) listItemView.findViewById(R.id.mag_text_view);

        // Set the proper background color on the magnitude circle.
        // Fetch the background from the TextView, which is a GradientDrawable.
        GradientDrawable magnitudeCircle = (GradientDrawable) magView.getBackground();

        // Get the appropriate background color based on the current earthquake magnitude
        int magnitudeColor = getMagnitudeColor(current.getMagnitude());

        // Set the color on the magnitude circle
        magnitudeCircle.setColor(magnitudeColor);


        TextView pointView = (TextView) listItemView.findViewById(R.id.point_text_view);
        TextView locView = (TextView) listItemView.findViewById(R.id.offset_text_view);
        TextView dateView = (TextView) listItemView.findViewById(R.id.date_text_view);
        TextView timeView = (TextView) listItemView.findViewById(R.id.time_text_view);

        // Set text on the TextView
        magView.setText(current.getMagStr());
        locView.setText(current.getNearThe(mContext.getResources().getString(R.string.near_the)));
        pointView.setText(current.getPoint());
        dateView.setText(current.getDate());
        timeView.setText(current.getTime());
        /*
        // Find the ImageView in the my_list_item.xmlxml layout with the ID list_item_icon
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

    public int getResourceId(String pVariableName, String pResourcename, String pPackageName)
    {
        try {
            return mContext.getResources().getIdentifier(pVariableName, pResourcename, pPackageName);
        } catch (Exception e) {
            e.printStackTrace();
            return -1;
        }
    }

    private int getMagnitudeColor(double magnitude) {
        int magnitudeColorResourceId;
        int magnitudeFloor = (int) Math.floor(magnitude);

        /*
        switch (magnitudeFloor) {
            case 0:
            case 1:
                magnitudeColorResourceId = R.color.magnitude1;
                break;
            case 2:
                magnitudeColorResourceId = R.color.magnitude2;
                break;
            case 3:
                magnitudeColorResourceId = R.color.magnitude3;
                break;
            case 4:
                magnitudeColorResourceId = R.color.magnitude4;
                break;
            case 5:
                magnitudeColorResourceId = R.color.magnitude5;
                break;
            case 6:
                magnitudeColorResourceId = R.color.magnitude6;
                break;
            case 7:
                magnitudeColorResourceId = R.color.magnitude7;
                break;
            case 8:
                magnitudeColorResourceId = R.color.magnitude8;
                break;
            case 9:
                magnitudeColorResourceId = R.color.magnitude9;
                break;
            default:
                magnitudeColorResourceId = R.color.magnitude10plus;
                break;
        }
*/
        if (magnitudeFloor < 10) {
            magnitudeColorResourceId = getResourceId(String.format("magnitude%d", magnitudeFloor), "color", mContext.getPackageName());
        }
        else {
            magnitudeColorResourceId = R.color.magnitude10plus;
        }
        return ContextCompat.getColor(getContext(), magnitudeColorResourceId);
    }
}
