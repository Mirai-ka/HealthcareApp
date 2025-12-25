package com.example.healthcare;

import android.content.Intent;
import android.os.Bundle;
import androidx.fragment.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.google.android.material.card.MaterialCardView;

public class PharmacyFragment extends Fragment {

    public PharmacyFragment() {}

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // Используем существующий XML layout вместо создания программно
        View view = inflater.inflate(R.layout.activity_pharmacy, container, false);

        setupClickListeners(view);

        return view;
    }

    private void setupClickListeners(View view) {
        // Обработчики кликов для карточек продуктов
        MaterialCardView cardPanadol = view.findViewById(R.id.cardPanadol);
        MaterialCardView cardBodrex = view.findViewById(R.id.cardBodrex);
        MaterialCardView cardKonidin = view.findViewById(R.id.cardKonidin);
        MaterialCardView cardObhCombi = view.findViewById(R.id.cardObhCombi);
        MaterialCardView cardBetadine = view.findViewById(R.id.cardBetadine);
        MaterialCardView cardBodrexin = view.findViewById(R.id.cardBodrexin);

        if (cardPanadol != null) {
            cardPanadol.setOnClickListener(v -> openProductDetail("Panadol", "20pcs", 15.99, 4.5));
        }

        if (cardBodrex != null) {
            cardBodrex.setOnClickListener(v -> openProductDetail("Bodrex Herbal", "10.0ml", 7.99, 4.2));
        }

        if (cardKonidin != null) {
            cardKonidin.setOnClickListener(v -> openProductDetail("Konidin", "5pcs", 5.99, 4.1));
        }

        if (cardObhCombi != null) {
            cardObhCombi.setOnClickListener(v -> openProductDetail("OBH Combi", "75ml", 9.99, 4.0));
        }

        if (cardBetadine != null) {
            cardBetadine.setOnClickListener(v -> openProductDetail("Betadine", "50ml", 6.99, 4.3));
        }

        if (cardBodrexin != null) {
            cardBodrexin.setOnClickListener(v -> openProductDetail("Bodrexin", "75ml", 7.99, 4.0));
        }
    }

    private void openProductDetail(String name, String size, double price, double rating) {
        Intent intent = new Intent(getActivity(), ProductDetailActivity.class);
        intent.putExtra("product_name", name);
        intent.putExtra("product_size", size);
        intent.putExtra("product_price", price);
        intent.putExtra("product_rating", rating);
        startActivity(intent);
    }
}