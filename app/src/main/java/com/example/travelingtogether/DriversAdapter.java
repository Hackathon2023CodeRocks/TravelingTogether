package com.example.travelingtogether;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import com.bumptech.glide.Glide;

import java.util.ArrayList;
import java.util.List;

public class DriversAdapter extends ArrayAdapter<Drivers> {

    private Context mContext;
    private int mResource;

    public DriversAdapter(Context context, int resource, List<Drivers> objects) {
        super(context, resource, objects);
        mContext = context;
        mResource = resource;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        if (convertView == null) {
            convertView = LayoutInflater.from(mContext).inflate(mResource, parent, false);
        }

        ImageView imageView = convertView.findViewById(R.id.image_view);
        TextView nameTextView = convertView.findViewById(R.id.name_text_view);
        TextView seatsTextView = convertView.findViewById(R.id.free_seats_text_view);
        TextView priceTextView = convertView.findViewById(R.id.price_text_view);

        Drivers driver = getItem(position);
        imageView.setImageResource(driver.getImageId());
        nameTextView.setText(driver.getName());
        seatsTextView.setText(mContext.getString(R.string.free_seats, driver.getFreeSeats()));
        priceTextView.setText(mContext.getString(R.string.price, driver.getPrice()));

        convertView.setTag(position);

        convertView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Integer position = (Integer) v.getTag();
                if (position != null) {
                    Drivers driver = getItem(position);

// Create bundle and add driver data
                    Bundle bundle = new Bundle();
                    bundle.putString("name", driver.getName());
                    bundle.putInt("freeSeats", driver.getFreeSeats());
                    bundle.putInt("price", driver.getPrice());
                    bundle.putInt("imageId", driver.getImageId());

// Create ActiveTravelFragment and set arguments
                    ActiveTravelFragment activeTravelFragment = new ActiveTravelFragment();
                    activeTravelFragment.setArguments(bundle);

// Replace current fragment with ActiveTravelFragment
                    FragmentManager fragmentManager = ((AppCompatActivity) mContext).getSupportFragmentManager();
                    fragmentManager.beginTransaction()
                            .replace(R.id.fragment_container, activeTravelFragment)
                            .addToBackStack(null)
                            .commit();
                }
            }
        });

        return convertView;
    }
}


