package com.example.travelingtogether;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

import java.util.ArrayList;
import java.util.List;

public class DriversAdapter extends ArrayAdapter<Drivers> {
    private int resourceLayout;
    private Context mContext;

    public DriversAdapter(Context context, int resource, List<Drivers> items) {
        super(context, resource, items);
        this.resourceLayout = resource;
        this.mContext = context;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View view = convertView;

        if (view == null) {
            LayoutInflater inflater = LayoutInflater.from(mContext);
            view = inflater.inflate(resourceLayout, null);
        }

        Drivers driver = getItem(position);

        if (driver != null) {
            TextView nameTextView = view.findViewById(R.id.name_text_view);
            TextView freeSeatsTextView = view.findViewById(R.id.free_seats_text_view);
            TextView priceTextView = view.findViewById(R.id.price_text_view);
            ImageView imageView = view.findViewById(R.id.image_view);

            nameTextView.setText(driver.getName());
            freeSeatsTextView.setText(String.valueOf(driver.getFreeSeats()));
            priceTextView.setText(String.valueOf(driver.getPrice()));
            imageView.setImageResource(driver.getImageId());
        }

        return view;
    }
}
