package com.example.travelingtogether;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.fragment.app.Fragment;

public class TravelersFragment extends Fragment {
    public TravelersFragment() {}
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle saveInstanceState) {

        View view = inflater.inflate(R.layout.fragment_travelers, container,false);
        return view;
    }
}
