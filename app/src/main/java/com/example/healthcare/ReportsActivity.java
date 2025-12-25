package com.example.healthcare;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;

public class ReportsActivity extends AppCompatActivity {

    private ImageView imageDownload1, imageDownload2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_reports);

        initializeViews();
        setupClickListeners();
    }

    private void initializeViews() {
        imageDownload1 = findViewById(R.id.imageDownload1);
        imageDownload2 = findViewById(R.id.imageDownload2);

        // Если у вас нет отдельных ID для каждой иконки загрузки,
        // можно найти их по позиции или добавить ID в XML
    }

    private void setupClickListeners() {
        // Обработчик клика для первой иконки загрузки
        View downloadView1 = findViewById(R.id.imageDownload1);
        if (downloadView1 != null) {
            downloadView1.setOnClickListener(v -> {
                downloadReport("General report - Jul. 10, 2023");
            });
        }

        // Обработчик клика для второй иконки загрузки
        View downloadView2 = findViewById(R.id.imageDownload2);
        if (downloadView2 != null) {
            downloadView2.setOnClickListener(v -> {
                downloadReport("General report - Jul. 5, 2023");
            });
        }

        // Обработчики клика для карточек отчетов (опционально)
        View reportCard1 = findViewById(R.id.reportCard1);
        if (reportCard1 != null) {
            reportCard1.setOnClickListener(v -> {
                // Действие при клике на первую карточку отчета
                openReportDetails("General report - Jul. 10, 2023");
            });
        }

        View reportCard2 = findViewById(R.id.reportCard2);
        if (reportCard2 != null) {
            reportCard2.setOnClickListener(v -> {
                // Действие при клике на вторую карточку отчета
                openReportDetails("General report - Jul. 5, 2023");
            });
        }
    }

    private void downloadReport(String reportName) {
        // Здесь реализуйте логику загрузки отчета
        // Например, скачивание PDF файла или открытие в браузере

        // Временное уведомление для демонстрации
        android.widget.Toast.makeText(this, "Downloading: " + reportName, android.widget.Toast.LENGTH_SHORT).show();

        // Можно добавить анимацию загрузки
        startDownloadAnimation();
    }

    private void openReportDetails(String reportName) {
        // Здесь реализуйте открытие деталей отчета
        // Например, переход на новый экран с подробной информацией

        android.widget.Toast.makeText(this, "Opening: " + reportName, android.widget.Toast.LENGTH_SHORT).show();
    }

    private void startDownloadAnimation() {
        // Простая анимация для иконки загрузки
        // В реальном приложении можно использовать Lottie или ProgressBar
        if (imageDownload1 != null) {
            imageDownload1.animate()
                    .rotationBy(360)
                    .setDuration(500)
                    .start();
        }
    }
}