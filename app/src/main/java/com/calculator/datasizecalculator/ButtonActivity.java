package com.calculator.datasizecalculator;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

public class ButtonActivity extends AppCompatActivity {

    private static final String PREF_NAME = "MyPrefs";
    private static final String VISIT_COUNT_KEY = "visit_count";
    private static final String SHOW_RATE_DIALOG_KEY = "show_rate_dialog";

    private SharedPreferences sharedPreferences;
    private int visitCount;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_button);

        sharedPreferences = getSharedPreferences(PREF_NAME, Context.MODE_PRIVATE);
        visitCount = sharedPreferences.getInt(VISIT_COUNT_KEY, 0);

        // Check if RateUs dialog should be shown
        if (visitCount >= 2 && sharedPreferences.getBoolean(SHOW_RATE_DIALOG_KEY, true)) {
            showRateUsDialog();
        }

        // Increment visit count
        visitCount++;
        sharedPreferences.edit().putInt(VISIT_COUNT_KEY, visitCount).apply();

        // Buttons
        Button twitterButton = findViewById(R.id.twitterButton);
        Button facebookButton = findViewById(R.id.facebookButton);

        // Set onClickListeners for buttons
        twitterButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openBrowser("https://twitter.com");
            }
        });

        facebookButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openBrowser("https://facebook.com");
            }
        });
    }

    private void openBrowser(String url) {
        Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse(url));
        startActivity(intent);
    }

    private void showRateUsDialog() {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("Rate Us");
        builder.setMessage("Enjoying the app? Please take a moment to rate us on the Play Store.");

        builder.setPositiveButton("RateUs", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                // User clicked RateUs
                openPlayStore();
                // Set flag to not show the dialog again
                sharedPreferences.edit().putBoolean(SHOW_RATE_DIALOG_KEY, false).apply();
            }
        });

        builder.setNegativeButton("CLOSE", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                // User clicked CLOSE, show the dialog again next time
            }
        });

        builder.setOnCancelListener(new DialogInterface.OnCancelListener() {
            @Override
            public void onCancel(DialogInterface dialog) {
                // Dialog canceled, show it again next time
            }
        });

        builder.show();
    }

    private void openPlayStore() {
        // Open Google Play Store for rating
        try {
            startActivity(new Intent(Intent.ACTION_VIEW,
                    Uri.parse("market://details?id=" + getPackageName())));
        } catch (android.content.ActivityNotFoundException e) {
            startActivity(new Intent(Intent.ACTION_VIEW,
                    Uri.parse("https://play.google.com/store/apps/details?id=" + getPackageName())));
        }
    }
}
