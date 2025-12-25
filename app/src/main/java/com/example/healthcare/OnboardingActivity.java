package com.example.healthcare;

import android.content.Intent;
import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import android.widget.ImageView;
import android.widget.Button;
import android.widget.FrameLayout;
import android.view.ViewGroup;
import android.view.Gravity;
import android.view.View;
import android.widget.LinearLayout;

public class OnboardingActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        FrameLayout root = new FrameLayout(this);
        ImageView iv = new ImageView(this);
        iv.setImageResource(R.drawable.doctor); // Используем существующее изображение из XML
        iv.setScaleType(ImageView.ScaleType.CENTER_CROP);
        root.addView(iv, new FrameLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT));

        LinearLayout bottom = new LinearLayout(this);
        bottom.setOrientation(LinearLayout.VERTICAL);
        FrameLayout.LayoutParams blp = new FrameLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT);
        blp.gravity = Gravity.BOTTOM;
        blp.setMargins(dp(32), dp(32), dp(32), dp(48));

        Button start = new Button(this);
        start.setText("Начать");
        start.setAllCaps(false);
        start.setBackgroundResource(android.R.drawable.btn_default);
        LinearLayout.LayoutParams lp = new LinearLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT);
        bottom.addView(start, lp);

        root.addView(bottom, blp);
        setContentView(root);

        start.setOnClickListener(v -> {
            // SharedPrefManager.getInstance(this).setFirstLaunch(false);
            startActivity(new Intent(this, MainContainerActivity.class));
            finish();
        });
    }

    private int dp(int value) {
        float density = getResources().getDisplayMetrics().density;
        return (int) (value * density + 0.5f);
    }
}