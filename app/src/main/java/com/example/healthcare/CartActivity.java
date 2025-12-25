package com.example.healthcare;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;

public class CartActivity extends AppCompatActivity {

    private TextView textQuantityObh, textPriceObh;
    private TextView textQuantityPanadol, textPricePanadol;
    private TextView textSubtotal, textTaxes, textTotal, textCheckoutTotal;
    private Button buttonDecreaseObh, buttonIncreaseObh;
    private Button buttonDecreasePanadol, buttonIncreasePanadol;
    private TextView buttonCheckout;

    private int quantityObh = 1;
    private int quantityPanadol = 2;
    private double priceObh = 9.99;
    private double pricePanadol = 9.995; // $9.995 per item for 2 items = $19.99

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cart);

        initializeViews();
        setupClickListeners();
        updatePrices();
    }

    private void initializeViews() {
        textQuantityObh = findViewById(R.id.textQuantityObh);
        textPriceObh = findViewById(R.id.textPriceObh);
        textQuantityPanadol = findViewById(R.id.textQuantityPanadol);
        textPricePanadol = findViewById(R.id.textPricePanadol);
        textSubtotal = findViewById(R.id.textSubtotal);
        textTaxes = findViewById(R.id.textTaxes);
        textTotal = findViewById(R.id.textTotal);
        textCheckoutTotal = findViewById(R.id.textCheckoutTotal);

        buttonDecreaseObh = findViewById(R.id.buttonDecreaseObh);
        buttonIncreaseObh = findViewById(R.id.buttonIncreaseObh);
        buttonDecreasePanadol = findViewById(R.id.buttonDecreasePanadol);
        buttonIncreasePanadol = findViewById(R.id.buttonIncreasePanadol);
        buttonCheckout = findViewById(R.id.buttonCheckout);
    }

    private void setupClickListeners() {
        // OBH Combi quantity controls
        buttonDecreaseObh.setOnClickListener(v -> {
            if (quantityObh > 1) {
                quantityObh--;
                textQuantityObh.setText(String.valueOf(quantityObh));
                updatePrices();
            }
        });

        buttonIncreaseObh.setOnClickListener(v -> {
            quantityObh++;
            textQuantityObh.setText(String.valueOf(quantityObh));
            updatePrices();
        });

        // Panadol quantity controls
        buttonDecreasePanadol.setOnClickListener(v -> {
            if (quantityPanadol > 1) {
                quantityPanadol--;
                textQuantityPanadol.setText(String.valueOf(quantityPanadol));
                updatePrices();
            }
        });

        buttonIncreasePanadol.setOnClickListener(v -> {
            quantityPanadol++;
            textQuantityPanadol.setText(String.valueOf(quantityPanadol));
            updatePrices();
        });

        // Checkout button
        buttonCheckout.setOnClickListener(v -> {
            Intent intent = new Intent(CartActivity.this, PaymentSuccessActivity.class);
            intent.putExtra("total_amount", calculateTotal());
            startActivity(intent);
        });
    }

    private void updatePrices() {
        // Update individual item prices
        double totalObh = priceObh * quantityObh;
        double totalPanadol = pricePanadol * quantityPanadol;

        textPriceObh.setText(String.format("$%.2f", totalObh));
        textPricePanadol.setText(String.format("$%.2f", totalPanadol));

        // Update payment details
        double subtotal = totalObh + totalPanadol;
        double taxes = 1.00; // Fixed tax for simplicity
        double total = subtotal + taxes;

        textSubtotal.setText(String.format("$%.2f", subtotal));
        textTaxes.setText(String.format("$%.2f", taxes));
        textTotal.setText(String.format("$%.2f", total));
        textCheckoutTotal.setText(String.format("$%.2f", total));
    }

    private double calculateTotal() {
        double totalObh = priceObh * quantityObh;
        double totalPanadol = pricePanadol * quantityPanadol;
        double subtotal = totalObh + totalPanadol;
        double taxes = subtotal * 0.08; // 8% налог
        return subtotal + taxes;
    }
}