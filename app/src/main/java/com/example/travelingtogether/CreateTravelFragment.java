package com.example.travelingtogether;

import android.annotation.SuppressLint;
import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;
import androidx.navigation.Navigation;

import java.util.ArrayList;
import java.util.List;


public class CreateTravelFragment extends Fragment {


    Button create_btn;

    @SuppressLint("MissingInflatedId")
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.create_travel, container, false);
        create_btn= view.findViewById(R.id.create_btn);

        create_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                TravelersFragment travelersFragment = new TravelersFragment();
                FragmentTransaction transaction = getParentFragmentManager().beginTransaction();
                travelersFragment.driversList.add(new Drivers("Джон", 2, 500, R.drawable.profile));
                transaction.replace(R.id.fragment_container, travelersFragment);
                transaction.addToBackStack(null);
                transaction.commit();
            }
        });
        return view;
    }
}
