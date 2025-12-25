package com.example.healthcare;

import android.content.Intent;
import android.os.Bundle;
import android.util.Patterns;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.TextView;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;
import com.google.android.material.textfield.TextInputEditText;
import com.google.android.material.textfield.TextInputLayout;

public class RegisterActivity extends AppCompatActivity {
    TextInputEditText etEmail, etPassword, etPasswordRepeat, etName;
    Button btnSignUp;
    CheckBox termsCheck;
    TextView tvSignInLink;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        // Инициализация полей ввода
        TextInputLayout tilName = findViewById(R.id.tilName);
        TextInputLayout tilEmail = findViewById(R.id.tilEmail);
        TextInputLayout tilPassword = findViewById(R.id.tilPassword);

        etName = (TextInputEditText) tilName.getEditText();
        etEmail = (TextInputEditText) tilEmail.getEditText();
        etPassword = (TextInputEditText) tilPassword.getEditText();

        btnSignUp = findViewById(R.id.btnSignUp);
        termsCheck = findViewById(R.id.termsCheck);
        tvSignInLink = findViewById(R.id.tvSignInLink);

        // Заполнение email если передан из интента
        String prefilled = getIntent().getStringExtra("prefilledEmail");
        if (prefilled != null && !prefilled.isEmpty() && etEmail != null) {
            etEmail.setText(prefilled);
        }

        // Обработчик кнопки регистрации
        btnSignUp.setOnClickListener(v -> {
            if (validateForm()) {
                registerUser();
            }
        });

        // Обработчик ссылки "Sign In"
        tvSignInLink.setOnClickListener(v -> {
            startActivity(new Intent(this, LoginActivity.class));
            finish();
        });
    }

    private boolean validateForm() {
        String email = etEmail != null ? etEmail.getText().toString().trim() : "";
        String pwd = etPassword != null ? etPassword.getText().toString() : "";
        String name = etName != null ? etName.getText().toString().trim() : "";

        // Валидация email
        if (email.isEmpty()) {
            showError("Please enter email");
            return false;
        }
        if (!validateEmail(email)) {
            showError("Invalid email format");
            return false;
        }

        // Валидация пароля
        if (pwd.isEmpty()) {
            showError("Please enter password");
            return false;
        }
        if (!validatePassword(pwd)) {
            showError("Password must be exactly 8 characters, containing only digits and special characters");
            return false;
        }

        // Валидация имени
        if (name.isEmpty()) {
            showError("Please enter your name");
            return false;
        }

        // Проверка согласия с условиями
        if (!termsCheck.isChecked()) {
            showError("Please agree to Terms & Conditions");
            return false;
        }

        return true;
    }

    private void registerUser() {
        String email = etEmail.getText().toString().trim();
        String pwd = etPassword.getText().toString();
        String name = etName.getText().toString().trim();

        // Сохраняем пользователя
        SharedPrefManager.getInstance(this).saveUser(email, pwd, name);

        Toast.makeText(this, "Registration successful", Toast.LENGTH_SHORT).show();

        // Переходим на главный экран
        startActivity(new Intent(this, MainContainerActivity.class));
        finish();
    }

    private boolean validateEmail(String email) {
        return Patterns.EMAIL_ADDRESS.matcher(email).matches();
    }

    private boolean validatePassword(String pwd) {
        if (pwd == null || pwd.length() < 6) {
            return false;
        }
        return pwd.matches("^(?=.*[0-9])(?=.*[a-zA-Z]).{6,}$");
    }

    private void showError(String message) {
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show();
    }
}