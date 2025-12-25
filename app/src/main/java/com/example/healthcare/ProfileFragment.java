package com.example.healthcare;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.fragment.app.Fragment;
import com.google.android.material.card.MaterialCardView;

public class ProfileFragment extends Fragment {

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_profile, container, false);
        setupClickListeners(view);
        return view;
    }

    private void setupClickListeners(View view) {
        MaterialCardView cardLogout = view.findViewById(R.id.cardLogout);

        if (cardLogout != null) {
            cardLogout.setOnClickListener(v -> {
                // Логика выхода
                Intent intent = new Intent(getActivity(), LoginActivity.class);
                intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK | Intent.FLAG_ACTIVITY_NEW_TASK);
                startActivity(intent);
                getActivity().finish();
            });
        }
    }
}