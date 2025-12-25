package com.example.healthcare;

import android.content.Intent;
import android.os.Bundle;
import android.util.Patterns;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;
import com.google.android.material.button.MaterialButton;
import com.google.android.material.textfield.TextInputEditText;
import com.google.android.material.textfield.TextInputLayout;

public class LoginActivity extends AppCompatActivity {
    TextInputEditText etEmail, etPassword;
    MaterialButton btnSignIn;
    TextView tvSignUpLink, tvForgot;
    boolean firstLaunch;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        // Инициализация полей ввода
        TextInputLayout tilEmail = findViewById(R.id.tilEmail);
        TextInputLayout tilPassword = findViewById(R.id.tilPassword);

        etEmail = (TextInputEditText) tilEmail.getEditText();
        etPassword = (TextInputEditText) tilPassword.getEditText();

        btnSignIn = findViewById(R.id.btnSignIn);
        tvSignUpLink = findViewById(R.id.tvSignUpLink);
        tvForgot = findViewById(R.id.tvForgot);

        firstLaunch = getIntent().getBooleanExtra("firstLaunch", true);

        // Если данные ранее сохранены, подставляем email
        String savedEmail = SharedPrefManager.getInstance(this).getEmail();
        if (savedEmail != null && etEmail != null) {
            etEmail.setText(savedEmail);
        }

        // Обработчик кнопки входа
        btnSignIn.setOnClickListener(v -> {
            if (validateForm()) {
                processLogin();
            }
        });

        // Обработчик ссылки "Sign Up"
        tvSignUpLink.setOnClickListener(v -> {
            String email = etEmail != null ? etEmail.getText().toString().trim() : "";
            Intent intent = new Intent(LoginActivity.this, RegisterActivity.class);
            intent.putExtra("prefilledEmail", email);
            startActivity(intent);
        });

        // Обработчик "Forgot password"
        tvForgot.setOnClickListener(v -> {
            Toast.makeText(this, "Forgot password feature coming soon", Toast.LENGTH_SHORT).show();
        });

        // Обработчики социальных кнопок
        View btnGoogle = findViewById(R.id.btnGoogle);
        View btnFacebook = findViewById(R.id.btnFacebook);

        if (btnGoogle != null) {
            btnGoogle.setOnClickListener(v -> {
                Toast.makeText(this, "Google sign in coming soon", Toast.LENGTH_SHORT).show();
            });
        }

        if (btnFacebook != null) {
            btnFacebook.setOnClickListener(v -> {
                Toast.makeText(this, "Facebook sign in coming soon", Toast.LENGTH_SHORT).show();
            });
        }
    }

    private boolean validateForm() {
        String email = etEmail != null ? etEmail.getText().toString().trim() : "";
        String pwd = etPassword != null ? etPassword.getText().toString() : "";

        if (!validateEmail(email)) {
            Toast.makeText(this, "Please enter valid email", Toast.LENGTH_SHORT).show();
            return false;
        }
        if (pwd.isEmpty()) {
            Toast.makeText(this, "Please enter password", Toast.LENGTH_SHORT).show();
            return false;
        }

        return true;
    }

    private void processLogin() {
        String email = etEmail.getText().toString().trim();
        String pwd = etPassword.getText().toString();

        // Проверяем существование пользователя
        String savedEmail = SharedPrefManager.getInstance(this).getEmail();
        String savedPassword = SharedPrefManager.getInstance(this).getPassword();

        if (savedEmail != null && savedPassword != null) {
            // Пользователь существует - проверяем credentials
            if (savedEmail.equals(email) && savedPassword.equals(pwd)) {
                // Успешный вход
                Toast.makeText(this, "Login successful", Toast.LENGTH_SHORT).show();
                startActivity(new Intent(LoginActivity.this, MainContainerActivity.class));
                finish();
            } else {
                Toast.makeText(this, "Invalid email or password", Toast.LENGTH_SHORT).show();
            }
        } else {
            // Первый вход - переходим к регистрации
            Intent intent = new Intent(LoginActivity.this, RegisterActivity.class);
            intent.putExtra("prefilledEmail", email);
            startActivity(intent);
            finish();
        }
    }

    private boolean validateEmail(String email) {
        return email != null && !email.isEmpty() && Patterns.EMAIL_ADDRESS.matcher(email).matches();
    }
}