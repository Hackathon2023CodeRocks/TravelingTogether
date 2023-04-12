package com.example.travelingtogether;

import android.annotation.SuppressLint;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;
import androidx.lifecycle.viewmodel.CreationExtras;

public class EnterFragment extends Fragment {

    private Button registerButton;
    private Button loginButton;
    private EditText emailEditText, passwordEditText;
    private DatabaseHelper dbHelper;
    private SQLiteDatabase database;


    @SuppressLint("MissingInflatedId")
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_enter, container, false);

        emailEditText = view.findViewById(R.id.emailEditText);
        passwordEditText = view.findViewById(R.id.passwordEditText);
        registerButton = view.findViewById(R.id.button_register);
        loginButton = view.findViewById(R.id.button_enter);

        registerButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Fragment registerFragment = new RegisterFragment();
                FragmentTransaction transaction = getParentFragmentManager().beginTransaction();
                transaction.replace(R.id.fragment_container, registerFragment);
                transaction.addToBackStack(null);
                transaction.commit();
            }
        });

        loginButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                loginUser();
            }
        });
        dbHelper = new DatabaseHelper(getActivity());
        return view;
    }

    private void loginUser() {
        String email = emailEditText.getText().toString();
        String password = passwordEditText.getText().toString();
        database = dbHelper.getReadableDatabase();
        String[] columns = {"id"};
        String selection = "email=? and password=?";
        String[] selectionArgs = {email, password};
        Cursor cursor = database.query("users", columns, selection, selectionArgs, null, null, null);
        if (cursor.moveToFirst()) {
            Toast.makeText(getActivity(), "Login successful", Toast.LENGTH_SHORT).show();
            FragmentTransaction transaction = getFragmentManager().beginTransaction();
            transaction.replace(R.id.fragment_container, new ProfileFragment());
            transaction.commit();
        } else {
            Toast.makeText(getActivity(), "Login failed", Toast.LENGTH_SHORT).show();
        }
    }
}

