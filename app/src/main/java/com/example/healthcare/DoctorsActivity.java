package com.example.healthcare;

import android.content.Intent;
import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.healthcare.adapters.DoctorAdapter;
import com.example.healthcare.models.Doctor;

import java.util.ArrayList;
import java.util.List;

public class DoctorsActivity extends AppCompatActivity implements DoctorAdapter.OnDoctorClickListener {

    private RecyclerView recyclerViewDoctors;
    private DoctorAdapter doctorAdapter;
    private List<Doctor> doctorList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_doctors);

        initializeViews();
        setupDoctorsList();
        setupRecyclerView();
    }

    private void initializeViews() {
        recyclerViewDoctors = findViewById(R.id.recyclerViewDoctors);
    }

    private void setupDoctorsList() {
        doctorList = new ArrayList<>();
        // Используем String для рейтинга
        doctorList.add(new Doctor("Dr. Rishi", "Chardiologist", "4.7", "800m away"));
        doctorList.add(new Doctor("Dr. Vaamana", "Dentists", "4.7", "800m away"));
        doctorList.add(new Doctor("Dr. Nallarasi", "Orthopaedic", "4.7", "800m away"));
        doctorList.add(new Doctor("Dr. Nihal", "Chardiologist", "4.7", "800m away"));
        doctorList.add(new Doctor("Dr. Rishita", "Chardiologist", "4.7", "800m away"));
    }

    private void setupRecyclerView() {
        doctorAdapter = new DoctorAdapter(doctorList, this);
        recyclerViewDoctors.setLayoutManager(new LinearLayoutManager(this));
        recyclerViewDoctors.setAdapter(doctorAdapter);
    }

    @Override
    public void onDoctorClick(Doctor doctor) {
        Intent intent = new Intent(this, DoctorDetailActivity.class);
        intent.putExtra("doctor_name", doctor.getName());
        intent.putExtra("doctor_specialty", doctor.getSpecialty());
        intent.putExtra("doctor_rating", doctor.getRating());
        intent.putExtra("doctor_distance", doctor.getDistance());
        startActivity(intent);
    }
}