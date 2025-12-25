package com.example.healthcare;

import android.content.DialogInterface;
import android.os.Bundle;
import android.widget.TextView;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import com.google.android.material.button.MaterialButton;

public class AmbulanceActivity extends AppCompatActivity {

    private TextView textAddress;
    private MaterialButton buttonConfirmLocation;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ambulance);

        initializeViews();
        setupClickListeners();
    }

    private void initializeViews() {
        textAddress = findViewById(R.id.textAddress);
        buttonConfirmLocation = findViewById(R.id.buttonConfirmLocation);

        // Set address
        textAddress.setText("Flat No. 50, Mahalaxmi Shop, Upkear, 36, Barpokhar (E), Siwan, Bihar, Pincode-880212");
    }

    private void setupClickListeners() {
        buttonConfirmLocation.setOnClickListener(v -> {
            showConfirmationDialog();
        });
    }

    private void showConfirmationDialog() {
        new AlertDialog.Builder(this)
                .setTitle("Confirm Ambulance Request")
                .setMessage("Are you sure you want to request an ambulance to this location?")
                .setPositiveButton("Yes, Call Ambulance", (dialog, which) -> {
                    // Here you would typically call ambulance service API
                    showSuccessDialog();
                })
                .setNegativeButton("Cancel", null)
                .show();
    }

    private void showSuccessDialog() {
        new AlertDialog.Builder(this)
                .setTitle("Ambulance Requested")
                .setMessage("Ambulance has been requested successfully. It will arrive at your location shortly.")
                .setPositiveButton("OK", null)
                .show();
    }
}