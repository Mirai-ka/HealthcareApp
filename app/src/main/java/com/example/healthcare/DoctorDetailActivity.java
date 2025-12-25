package com.example.healthcare;

import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;

public class DoctorDetailActivity extends AppCompatActivity {

    private TextView textDetailDoctorName, textDetailDoctorSpecialty;
    private TextView textDetailRating, textDetailDistance, textAbout;
    private Button buttonBookAppointment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_doctor_detail);

        initializeViews();
        setupDoctorData();
        setupClickListeners();
    }

    private void initializeViews() {
        textDetailDoctorName = findViewById(R.id.textDetailDoctorName);
        textDetailDoctorSpecialty = findViewById(R.id.textDetailDoctorSpecialty);
        textDetailRating = findViewById(R.id.textDetailRating);
        textDetailDistance = findViewById(R.id.textDetailDistance);
        textAbout = findViewById(R.id.textAbout);
        buttonBookAppointment = findViewById(R.id.buttonBookAppointment);
    }

    private void setupDoctorData() {
        // Get data from intent
        String doctorName = getIntent().getStringExtra("doctor_name");
        String doctorSpecialty = getIntent().getStringExtra("doctor_specialty");
        double doctorRating = getIntent().getDoubleExtra("doctor_rating", 4.7);
        String doctorDistance = getIntent().getStringExtra("doctor_distance");

        // Set data to views
        textDetailDoctorName.setText(doctorName);
        textDetailDoctorSpecialty.setText(doctorSpecialty);
        textDetailRating.setText(String.valueOf(doctorRating));
        textDetailDistance.setText(doctorDistance);

        // Set about text
        textAbout.setText("Lorem ipsum dolor sit amet, consectetur adipi elit, sed do eiusmod tempor incididunt ut laore et dolore magna aliqua. Ut enim ad minim veniam...");
    }

    private void setupClickListeners() {
        buttonBookAppointment.setOnClickListener(v -> {
            // Handle book appointment logic
            // You can show a confirmation dialog or navigate to booking screen
        });
    }
}