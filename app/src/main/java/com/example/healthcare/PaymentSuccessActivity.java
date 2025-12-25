package com.example.healthcare;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import com.google.android.material.button.MaterialButton;

public class PaymentSuccessActivity extends AppCompatActivity {

    private TextView textFinalTotal;
    private MaterialButton buttonBackToHome;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_payment_success);

        initializeViews();
        setupData();
        setupClickListeners();
    }

    private void initializeViews() {
        textFinalTotal = findViewById(R.id.textFinalTotal);
        buttonBackToHome = findViewById(R.id.buttonBackToHome);
    }

    private void setupData() {
        // Get total amount from intent
        double totalAmount = getIntent().getDoubleExtra("total_amount", 28.98);
        textFinalTotal.setText(String.format("$%.2f", totalAmount));
    }

    private void setupClickListeners() {
        buttonBackToHome.setOnClickListener(v -> {
            // Navigate back to home and clear the back stack
            Intent intent = new Intent(PaymentSuccessActivity.this, MainContainerActivity.class);
            intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP | Intent.FLAG_ACTIVITY_SINGLE_TOP);
            startActivity(intent);
            finish();
        });
    }
}