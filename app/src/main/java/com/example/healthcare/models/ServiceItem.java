package com.example.healthcare.models;

public class ServiceItem {
    private String title;
    private String subtitle;

    public ServiceItem() {
        // Пустой конструктор
    }

    public ServiceItem(String title, String subtitle) {
        this.title = title;
        this.subtitle = subtitle;
    }

    public String getTitle() {
        return title != null ? title : "";
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getSubtitle() {
        return subtitle != null ? subtitle : "";
    }

    public void setSubtitle(String subtitle) {
        this.subtitle = subtitle;
    }
}