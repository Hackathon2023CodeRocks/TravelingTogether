package com.example.travelingtogether;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

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

        Button contactButton = view.findViewById(R.id.driver_contact_button);
        contactButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Получаем информацию об активной поездке
                ImageView imageView = view.findViewById(R.id.driver_image_view);
                String imageName;
                if (imageView.getTag() != null) {
                    imageName = imageView.getTag().toString();
                } else {
                    imageName = "";
// или выполнить какое-то другое действие, например, показать сообщение об ошибке
                }
                TextView priceTextView = view.findViewById(R.id.driver_price_text_view);
                int price = Integer.parseInt(priceTextView.getText().toString());
                TextView driverNameTextView = view.findViewById(R.id.driver_name_text_view);
                String driverName = driverNameTextView.getText().toString();
                int freeSeats = Integer.parseInt(((TextView) view.findViewById(R.id.driver_free_seats_text_view)).getText().toString());


                // Создаем Bundle и добавляем информацию об активной поездке
                Bundle bundle = new Bundle();
                bundle.putString("image_name", imageName);
                bundle.putInt("price", price);
                bundle.putString("driver_name", driverName);
                bundle.putInt("free_seats", freeSeats);

                // Создаем новый экземпляр ProfileFragment и передаем Bundle
                ProfileFragment profileFragment = new ProfileFragment();
                profileFragment.setArguments(bundle);

                // Открываем ProfileFragment
                FragmentTransaction transaction = getFragmentManager().beginTransaction();
                transaction.replace(R.id.fragment_container, profileFragment);
                transaction.addToBackStack(null);
                transaction.commit();
            }
        });

        return view;
    }
}

