package com.example.healthcare;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.fragment.app.Fragment;
import com.google.android.material.card.MaterialCardView;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

public class HomeFragment extends Fragment {

    private TextView textTime, textUserName;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_home, container, false);
        setupClickListeners(view);
        return view;
    }

    private void initializeViews(View view) {
        textUserName = view.findViewById(R.id.textUserName);

        if (textUserName != null) {
            textUserName.setText("Ruchita");
        }
    }

    private void setupClickListeners(View view) {
        // Doctors card
        MaterialCardView cardDoctors = view.findViewById(R.id.cardDoctors);
        if (cardDoctors != null) {
            cardDoctors.setOnClickListener(v -> {
                startActivity(new Intent(requireActivity(), DoctorsActivity.class));
            });
        }

        // Pharmacy card
        MaterialCardView cardPharmacy = view.findViewById(R.id.cardPharmacy);
        if (cardPharmacy != null) {
            cardPharmacy.setOnClickListener(v -> {
                startActivity(new Intent(requireActivity(), PharmacyActivity.class));
            });
        }

        // Ambulance card
        MaterialCardView cardAmbulance = view.findViewById(R.id.cardAmbulance);
        if (cardAmbulance != null) {
            cardAmbulance.setOnClickListener(v -> {
                startActivity(new Intent(requireActivity(), AmbulanceActivity.class));
            });
        }
    }
}