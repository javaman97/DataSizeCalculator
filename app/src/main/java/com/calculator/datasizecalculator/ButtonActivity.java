package com.calculator.datasizecalculator;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class ButtonActivity extends AppCompatActivity {

    private static final String BUTTON_TEXT_URL = "https://huaynaka.gb.net/test1.txt";
    private static final String PREFS_NAME = "MyPrefs";
    private static final String BUTTON_TEXT_KEY = "buttonText";
    private boolean showRateUsDialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_button);

        Button button1 = findViewById(R.id.twitterButton);
        Button button2 = findViewById(R.id.facebookButton);

        // Check if it's the first visit and retrieve button text
        showRateUsDialog = checkFirstVisit();

        if (showRateUsDialog) {
            // Show RateUs dialog
            showRateUsDialog();
        }

        button1.setOnClickListener(v -> openBrowser("https://twitter.com"));

        button2.setOnClickListener(v -> openBrowser("https://facebook.com"));
    }

    private boolean checkFirstVisit() {
        SharedPreferences prefs = getSharedPreferences(PREFS_NAME, Context.MODE_PRIVATE);

        // Check if the app has been opened before
        boolean isFirstVisit = prefs.getBoolean("isFirstVisit", true);

        if (isFirstVisit) {
            // It's the first visit, retrieve button text and save it to SharedPreferences
            String buttonText = getButtonTextFromUrl();
            prefs.edit().putString(BUTTON_TEXT_KEY, buttonText).apply();

            // Update isFirstVisit to false
            prefs.edit().putBoolean("isFirstVisit", false).apply();
        }

        return !isFirstVisit;
    }

    private String getButtonTextFromUrl() {
        StringBuilder result = new StringBuilder();
        HttpURLConnection urlConnection = null;

        try {
            URL url = new URL(ButtonActivity.BUTTON_TEXT_URL);
            urlConnection = (HttpURLConnection) url.openConnection();

            if (urlConnection.getResponseCode() == HttpURLConnection.HTTP_OK) {
                InputStreamReader in = new InputStreamReader(urlConnection.getInputStream());
                BufferedReader reader = new BufferedReader(in);

                String line;
                while ((line = reader.readLine()) != null) {
                    result.append(line);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (urlConnection != null) {
                urlConnection.disconnect();
            }
        }

        return result.toString();
    }

    private void openBrowser(String url) {
        Intent browserIntent = new Intent(Intent.ACTION_VIEW, Uri.parse(url));
        startActivity(browserIntent);
    }

    private void showRateUsDialog() {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("Rate Us");
        builder.setMessage("Enjoying the app? Please take a moment to rate it on the Play Store.");

        builder.setPositiveButton("Rate Us", (dialog, which) -> {
            // Open Google Play Store for rating
            openBrowser("https://play.google.com/store/apps/details?id=your.package.name");

            // Set showRateUsDialog to false so it won't be shown again
            showRateUsDialog = false;
        });

        builder.setNegativeButton("CLOSE", (dialog, which) -> {
            // Dismiss the dialog and show it again on the next open
            dialog.dismiss();
            showRateUsDialog = true;
        });

        builder.setOnCancelListener(dialog -> showRateUsDialog = true);

        builder.show();
    }
}
