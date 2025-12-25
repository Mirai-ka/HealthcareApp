package com.example.healthcare;

import android.content.Context;
import android.content.SharedPreferences;

public class SharedPrefManager {
    private static final String PREF_NAME = "healthcare_prefs";
    private static SharedPrefManager instance;
    private SharedPreferences prefs;

    private SharedPrefManager(Context ctx) {
        prefs = ctx.getApplicationContext().getSharedPreferences(PREF_NAME, Context.MODE_PRIVATE);
    }

    public static SharedPrefManager getInstance(Context ctx) {
        if (instance == null) {
            instance = new SharedPrefManager(ctx);
        }
        return instance;
    }

    public void saveUser(String email, String password, String name) {
        prefs.edit()
                .putString("email", email)
                .putString("password", password)
                .putString("name", name)
                .apply();
    }

    public String getEmail() {
        return prefs.getString("email", null);
    }

    public String getPassword() {
        return prefs.getString("password", null);
    }

    public String getName() {
        return prefs.getString("name", null);
    }

    public void clearUser() {
        prefs.edit().remove("email").remove("password").remove("name").apply();
    }

    public boolean isFirstLaunch() {
        return prefs.getBoolean("first_launch", true);
    }

    public void setFirstLaunch(boolean val) {
        prefs.edit().putBoolean("first_launch", val).apply();
    }
}
