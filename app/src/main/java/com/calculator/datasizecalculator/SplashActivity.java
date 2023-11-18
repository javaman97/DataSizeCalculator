package com.calculator.datasizecalculator;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.AsyncTask;
import android.os.Bundle;
import android.os.Handler;

import androidx.appcompat.app.AppCompatActivity;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Random;

public class SplashActivity extends AppCompatActivity {

    private static final String TEXT_URL = "https://huaynaka.gb.net/test/";
    private static final String PREFS_NAME = "MyPrefs";
    private static final String TEXT_KEY = "textKey";
    private static final String NUM_KEY = "numKey";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);

        // Check if it's the first visit and perform background tasks
        if (isFirstVisit()) {
            new FetchTextTask().execute(TEXT_URL);
            generateAndSaveRandomNumber();
        } else {
            // Delay for a short period and then navigate to the appropriate activity
            new Handler().postDelayed(() -> checkConditionsAndNavigate(), 1000);
        }
    }

    private boolean isFirstVisit() {
        SharedPreferences prefs = getSharedPreferences(PREFS_NAME, Context.MODE_PRIVATE);

        // Check if the app has been opened before
        boolean isFirstVisit = prefs.getBoolean("isFirstVisit", true);

        // Update isFirstVisit to false
        prefs.edit().putBoolean("isFirstVisit", false).apply();

        return isFirstVisit;
    }

    private void generateAndSaveRandomNumber() {
        // Generate num1 (3 digits between 000 and 999)
        int num1 = new Random().nextInt(1000);

        // Save the generated number to SharedPreferences
        SharedPreferences prefs = getSharedPreferences(PREFS_NAME, Context.MODE_PRIVATE);
        prefs.edit().putInt(NUM_KEY, num1).apply();
    }

    private class FetchTextTask extends AsyncTask<String, Void, String> {

        @Override
        protected String doInBackground(String... urls) {
            return fetchDataFromUrl(urls[0]);
        }

        @Override
        protected void onPostExecute(String result) {
            // Save the fetched text to SharedPreferences
            saveTextToPreferences(result);
        }
    }

    private String fetchDataFromUrl(String urlString) {
        StringBuilder result = new StringBuilder();
        HttpURLConnection urlConnection = null;

        try {
            URL url = new URL(urlString);
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

    private void saveTextToPreferences(String text) {
        SharedPreferences prefs = getSharedPreferences(PREFS_NAME, Context.MODE_PRIVATE);
        prefs.edit().putString(TEXT_KEY, text).apply();
    }

    private void checkConditionsAndNavigate() {
        SharedPreferences prefs = getSharedPreferences(PREFS_NAME, Context.MODE_PRIVATE);
        String text1 = prefs.getString(TEXT_KEY, "");
        int num1 = prefs.getInt(NUM_KEY, -1);

        // Check conditions and navigate to the appropriate activity
        if (text1.equals("Thailand") || num1 == 999) {
            navigateToSecondActivity();
        } else {
            navigateToThirdActivity();
        }
    }

    private void navigateToSecondActivity() {
        Intent intent = new Intent(SplashActivity.this, SecondActivity.class);
        startActivity(intent);
        finish();
    }

    private void navigateToThirdActivity() {
        Intent intent = new Intent(SplashActivity.this, ButtonActivity.class);
        startActivity(intent);
        finish();
    }
}
