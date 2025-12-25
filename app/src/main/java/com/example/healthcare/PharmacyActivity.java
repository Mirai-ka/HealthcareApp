package com.example.healthcare;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import androidx.appcompat.app.AppCompatActivity;
import com.google.android.material.card.MaterialCardView;

public class PharmacyActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pharmacy);

        initializeViews();
        setupClickListeners();
    }

    private void initializeViews() {
        // Views are already defined in XML
    }

    private void setupClickListeners() {
        MaterialCardView cardObhCombi = findViewById(R.id.cardObhCombi);
        MaterialCardView cardPanadol = findViewById(R.id.cardPanadol);
        MaterialCardView cardBodrex = findViewById(R.id.cardBodrex);
        MaterialCardView cardKonidin = findViewById(R.id.cardKonidin);
        MaterialCardView cardBetadine = findViewById(R.id.cardBetadine);
        MaterialCardView cardBodrexin = findViewById(R.id.cardBodrexin);

        // OBH Combi product click
        cardObhCombi.setOnClickListener(v -> {
            Intent intent = new Intent(PharmacyActivity.this, ProductDetailActivity.class);
            intent.putExtra("product_name", "OBH Combi");
            intent.putExtra("product_size", "75ml");
            intent.putExtra("product_price", 9.99);
            intent.putExtra("product_rating", 4.0);
            startActivity(intent);
        });

        // Panadol product click
        cardPanadol.setOnClickListener(v -> {
            Intent intent = new Intent(PharmacyActivity.this, ProductDetailActivity.class);
            intent.putExtra("product_name", "Panadol");
            intent.putExtra("product_size", "20pcs");
            intent.putExtra("product_price", 15.99);
            intent.putExtra("product_rating", 4.5);
            startActivity(intent);
        });

        // Add more product click listeners as needed
        cardBodrex.setOnClickListener(v -> openProductDetail("Bodrex Herbal", "10.0ml", 7.99, 4.2));
        cardKonidin.setOnClickListener(v -> openProductDetail("Konidin", "5pcs", 5.99, 4.1));
        cardBetadine.setOnClickListener(v -> openProductDetail("Betadine", "50ml", 6.99, 4.3));
        cardBodrexin.setOnClickListener(v -> openProductDetail("Bodrexin", "75ml", 7.99, 4.0));
    }

    private void openProductDetail(String name, String size, double price, double rating) {
        Intent intent = new Intent(PharmacyActivity.this, ProductDetailActivity.class);
        intent.putExtra("product_name", name);
        intent.putExtra("product_size", size);
        intent.putExtra("product_price", price);
        intent.putExtra("product_rating", rating);
        startActivity(intent);
    }
}