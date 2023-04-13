package com.example.travelingtogether;

import android.graphics.Bitmap;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

public class ProfileFragment extends Fragment {

    private ImageView driverImageView;
    private TextView driverNameEditText;
    private TextView driverFreeSeatsEditText;
    private TextView driverPriceEditText;

    private String driverName;
    private int driverFreeSeats;
    private int driverPrice;
    private int driverImage;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.profile_fragment, container, false);

        driverImageView = view.findViewById(R.id.driver_image);
        driverNameEditText = view.findViewById(R.id.driver_name);
        driverFreeSeatsEditText = view.findViewById(R.id.driver_seats);
        driverPriceEditText = view.findViewById(R.id.driver_price);

        // Заполнение полей значениями, полученными из предыдущего фрагмента
        Bundle bundle = getArguments();
        if (bundle != null) {
            driverName = bundle.getString("driverName");
            driverFreeSeats = bundle.getInt("freeSeats");
            driverPrice = bundle.getInt("price");;

            driverImageView.setImageResource(R.drawable.profile);
            driverNameEditText.setText("Имя: Иван");
            driverFreeSeatsEditText.setText(String.valueOf("Кол-во свободных мест: "+driverFreeSeats));
            driverPriceEditText.setText(String.valueOf("Цена: "+driverPrice));
        }

        return view;
    }
}

