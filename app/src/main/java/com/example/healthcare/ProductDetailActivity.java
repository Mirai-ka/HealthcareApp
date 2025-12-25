package com.example.healthcare;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;

public class ProductDetailActivity extends AppCompatActivity {

    private TextView textProductName, textProductSize, textRating, textProductPrice;
    private TextView textQuantity, textDescription;
    private Button buttonDecrease, buttonIncrease, buttonBuy;
    private int quantity = 1;
    private double productPrice = 0.0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_product_detail);

        initializeViews();
        setupProductData();
        setupClickListeners();
    }

    private void initializeViews() {
        textProductName = findViewById(R.id.textProductName);
        textProductSize = findViewById(R.id.textProductSize);
        textRating = findViewById(R.id.textRating);
        textProductPrice = findViewById(R.id.textProductPrice);
        textQuantity = findViewById(R.id.textQuantity);
        textDescription = findViewById(R.id.textDescription);
        buttonDecrease = findViewById(R.id.buttonDecrease);
        buttonIncrease = findViewById(R.id.buttonIncrease);
        buttonBuy = findViewById(R.id.buttonBuy);
    }

    private void setupProductData() {
        // Get data from intent
        Intent intent = getIntent();
        String productName = intent.getStringExtra("product_name");
        String productSize = intent.getStringExtra("product_size");
        productPrice = intent.getDoubleExtra("product_price", 0.0);
        double rating = intent.getDoubleExtra("product_rating", 4.0);

        // Set data to views
        textProductName.setText(productName);
        textProductSize.setText(productSize);
        textRating.setText(String.valueOf(rating));
        textProductPrice.setText(String.format("$%.2f", productPrice));

        // Set description
        textDescription.setText("OBH COMBI is a cough medicine containing Paracetamol, Ephedrine HCl, and Chlorphenamine maleate which is used to relieve coughs accompanied by flu symptoms such as fever, headache, and sneezing...");

        updateTotalPrice();
    }

    private void setupClickListeners() {
        buttonDecrease.setOnClickListener(v -> {
            if (quantity > 1) {
                quantity--;
                textQuantity.setText(String.valueOf(quantity));
                updateTotalPrice();
            }
        });

        buttonIncrease.setOnClickListener(v -> {
            quantity++;
            textQuantity.setText(String.valueOf(quantity));
            updateTotalPrice();
        });

        buttonBuy.setOnClickListener(v -> {
            // Add to cart and navigate to cart
            Intent intent = new Intent(ProductDetailActivity.this, CartActivity.class);
            intent.putExtra("product_name", textProductName.getText().toString());
            intent.putExtra("product_size", textProductSize.getText().toString());
            intent.putExtra("quantity", quantity);
            intent.putExtra("price", productPrice * quantity);
            startActivity(intent);
        });
    }

    private void updateTotalPrice() {
        double totalPrice = productPrice * quantity;
        textProductPrice.setText(String.format("$%.2f", totalPrice));
    }
}