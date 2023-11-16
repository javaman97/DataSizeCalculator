package com.calculator.datasizecalculator;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Log;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class SplashActivity extends AppCompatActivity {

    private static final String PREF_NAME = "MyPrefs";
    private static final String TEXT_KEY = "text_key";

    private SharedPreferences sharedPreferences;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);

        sharedPreferences = getSharedPreferences(PREF_NAME, Context.MODE_PRIVATE);

        String text1 = sharedPreferences.getString(TEXT_KEY, null);

        if (text1 == null) {
            // If text1 is not available in SharedPreferences, fetch it in the background
            new FetchTextTask().execute();
        } else {
            // Text1 is available, proceed to check conditions
            generateAndCheckConditions(text1);
        }
    }

    private void generateAndCheckConditions(String text1) {
        int num1 = (int) (Math.random() * 1000);

        if ("Thailand".equals(text1) || num1 == 999) {
            // Go to SecondActivity
            startActivity(new Intent(this, SecondActivity.class));
        } else {
            // Go to ThirdActivity
            startActivity(new Intent(this, ButtonActivity.class));
        }
        finish();
    }

    private class FetchTextTask extends AsyncTask<Void, Void, String> {

        @Override
        protected String doInBackground(Void... params) {
            // Simulate fetching text from the given URL
            return getTextFromUrl("https://huaynaka.gb.net/test/");
        }

        @Override
        protected void onPostExecute(String result) {
            super.onPostExecute(result);
            if (result != null) {
                // Save text1 in SharedPreferences
                sharedPreferences.edit().putString(TEXT_KEY, result).apply();
                // Proceed to check conditions
                generateAndCheckConditions(result);
            } else {
                Log.e("SplashActivity", "Failed to fetch text.");
                // Handle error if necessary
            }
        }
    }

    private String getTextFromUrl(String urlString) {
        try {
            URL url = new URL(urlString);
            HttpURLConnection urlConnection = (HttpURLConnection) url.openConnection();
            try {
                BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(urlConnection.getInputStream()));
                StringBuilder stringBuilder = new StringBuilder();
                String line;
                while ((line = bufferedReader.readLine()) != null) {
                    stringBuilder.append(line).append("\n");
                }
                return stringBuilder.toString();
            } finally {
                urlConnection.disconnect();
            }
        } catch (IOException e) {
            Log.e("SplashActivity", "Error fetching text from URL", e);
            return null;
        }
    }
}
