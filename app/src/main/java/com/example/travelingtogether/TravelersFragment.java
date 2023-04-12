package com.example.travelingtogether;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ListView;

import androidx.fragment.app.Fragment;

import java.util.ArrayList;
import java.util.List;

public class TravelersFragment extends Fragment {
    private ListView listView;
    private Button goButton;
    public List<Drivers> driversList = new ArrayList<>();
    @SuppressLint("MissingInflatedId")
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle saveInstanceState) {

        View view = inflater.inflate(R.layout.fragment_travelers, container,false);

        listView = view.findViewById(R.id.driver_list);
        goButton = view.findViewById(R.id.go_button);

        driversList.add(new Drivers("Вася", 2, 500, R.drawable.profile));
        driversList.add(new Drivers("Петя", 4, 300, R.drawable.profile));
        driversList.add(new Drivers("Иван", 1, 700, R.drawable.profile));

        DriversAdapter adapter = new DriversAdapter(getContext(), R.layout.list_drivers, driversList);
        listView.setAdapter(adapter);

        goButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Действие при нажатии на кнопку "поехать"
            }
        });
        return view;
    }
}
