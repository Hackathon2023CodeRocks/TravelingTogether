package com.example.travelingtogether;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.fragment.app.Fragment;

public class ActiveTravelFragment extends Fragment {
    private TextView nameTextView;
    private TextView freeSeatsTextView;
    private TextView priceTextView;
    private ImageView imageView;

    public ActiveTravelFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_activity_travel, container, false);

// Get data from bundle
        Bundle bundle = getArguments();
        String name = bundle.getString("name");
        int freeSeats = bundle.getInt("freeSeats");
        int price = bundle.getInt("price");
        int imageId = bundle.getInt("imageId");

// Set data to views
        nameTextView = view.findViewById(R.id.driver_name_text_view);
        freeSeatsTextView = view.findViewById(R.id.driver_free_seats_text_view);
        priceTextView = view.findViewById(R.id.driver_price_text_view);
        imageView = view.findViewById(R.id.driver_image_view);

        nameTextView.setText(name);
        freeSeatsTextView.setText(String.valueOf(freeSeats));
        priceTextView.setText(String.valueOf(price));
        imageView.setImageResource(imageId);

        return view;
    }
}

