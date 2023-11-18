package com.calculator.datasizecalculator;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.util.Log;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.textfield.TextInputEditText;

import java.util.Objects;

public class SecondActivity extends AppCompatActivity {
    AutoCompleteTextView autoCompleteTextView;
    TextView bits,nibbles,bytes,kiloBytes,gigaBytes,megaBytes,teraBytes;

    TextInputEditText inputValue;
    Button clrButton,calcButton;
    String[] items ={"bits", "nibbles", "bytes", "kilobytes", "megabytes", "gigabytes", "terabytes"};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        inputValue = findViewById(R.id.txtInput);

        bits= findViewById(R.id.txtBits);
        nibbles= findViewById(R.id.txtNibbles);
        bytes= findViewById(R.id.txtBytes);
        kiloBytes= findViewById(R.id.txtKiloBytes);
        gigaBytes= findViewById(R.id.txtGigaBytes);
        megaBytes= findViewById(R.id.txtMegaBytes);
        teraBytes= findViewById(R.id.txtTeraBytes);

        clrButton = findViewById(R.id.btnClear);
        calcButton = findViewById(R.id.btnCalculate);

    }
    @Override
    public void onResume() {
        super.onResume();
        autoCompleteTextView = findViewById(R.id.autoCompleteText);
        if (autoCompleteTextView != null) {
            ArrayAdapter<String> adapter = new ArrayAdapter<>(this, R.layout.dropdown_items, items);
            autoCompleteTextView.setAdapter(adapter);
            autoCompleteTextView.setText(items[0],false);

            autoCompleteTextView.setOnItemClickListener((parent, view, position, id) -> {
                // Action to perform when an item is selected
                String selectedItem = (String) parent.getItemAtPosition(position);
                selectedDataConversion(selectedItem);
            });
        } else {
            Log.e("SecondActivity", "exposedDropdown is null");
        }
    }

    private void selectedDataConversion(String selectedItem) {
        calcButton.setOnClickListener(v -> {
            switch (selectedItem) {
                case "bits":
                    calculateBits(Double.parseDouble(Objects.requireNonNull(inputValue.getText()).toString()));
                    break;
                case "nibbles":
                    calculateNibbles(Double.parseDouble(Objects.requireNonNull(inputValue.getText()).toString()));
                    break;
                case "bytes":
                    calculateBytes(Double.parseDouble(Objects.requireNonNull(inputValue.getText()).toString()));
                    break;
                case "kilobytes":
                    calculateKiloBytes(Double.parseDouble(Objects.requireNonNull(inputValue.getText()).toString()));
                    break;
                case "megabytes":
                    calculateMegaBytes(Double.parseDouble(Objects.requireNonNull(inputValue.getText()).toString()));
                    break;
                case "gigabytes":
                    calculateGigaBytes(Double.parseDouble(Objects.requireNonNull(inputValue.getText()).toString()));
                    break;
                case "terabytes":
                calculateTeraBytes(Double.parseDouble(Objects.requireNonNull(inputValue.getText()).toString()));
                break;
                  default:
                    calculateBits(Double.parseDouble(Objects.requireNonNull(inputValue.getText()).toString()));
                    break;
            }
                });

        clrButton.setOnClickListener(view -> {
            inputValue.setText("");
            bits.setText("");
            bytes.setText("");
            nibbles.setText("");
            kiloBytes.setText("");
            megaBytes.setText("");
            gigaBytes.setText("");
            teraBytes.setText("");
        });
    }

    @SuppressLint("DefaultLocale")
    private void calculateBits(double input) {
        bits.setText(String.valueOf((int) input));
        nibbles.setText(String.format("%e", DataConverter.convertBitsToNibbles(input)));
        bytes.setText(String.format("%e", DataConverter.convertBitsToBytes(input)));
        kiloBytes.setText(String.format("%e", DataConverter.convertBitsToKiloBytes(input)));
        megaBytes.setText(String.format("%e", DataConverter.convertBitsToMegaBytes(input)));
        gigaBytes.setText(String.format("%e", DataConverter.convertBitsToGigaBytes(input)));
        teraBytes.setText(String.format("%e", DataConverter.convertBitsToTeraBytes(input)));
    }
    @SuppressLint("DefaultLocale")
    private void calculateNibbles(double input) {
        nibbles.setText(String.valueOf((int) input));
        bits.setText(String.format("%e", DataConverter.convertNibblesToBits(input)));
        bytes.setText(String.format("%e", DataConverter.convertNibblesToBytes(input)));
        kiloBytes.setText(String.format("%e", DataConverter.convertNibblesToKiloBytes(input)));
        megaBytes.setText(String.format("%e", DataConverter.convertNibblesToMegaBytes(input)));
        gigaBytes.setText(String.format("%e", DataConverter.convertNibblesToGigaBytes(input)));
        teraBytes.setText(String.format("%e", DataConverter.convertNibblesToTeraBytes(input)));
    }
    @SuppressLint("DefaultLocale")
    private void calculateBytes(double input) {
        bytes.setText(String.valueOf((int) input));
        bits.setText(String.format("%e", DataConverter.convertBytesToBits(input)));
        nibbles.setText(String.format("%e", DataConverter.convertBytesToNibbles(input)));
        kiloBytes.setText(String.format("%e", DataConverter.convertBytesToKiloBytes(input)));
        megaBytes.setText(String.format("%e", DataConverter.convertBytesToMegaBytes(input)));
        gigaBytes.setText(String.format("%e", DataConverter.convertBytesToGigaBytes(input)));
        teraBytes.setText(String.format("%e", DataConverter.convertBytesToTeraBytes(input)));
    }
    @SuppressLint("DefaultLocale")
    private void calculateKiloBytes(double input) {
        kiloBytes.setText(String.valueOf((int) input));
        bits.setText(String.format("%e", DataConverter.convertKiloBytesToBits(input)));
        nibbles.setText(String.format("%e", DataConverter.convertKiloBytesToNibbles(input)));
        bytes.setText(String.format("%e", DataConverter.convertKiloBytesToBytes(input)));
        megaBytes.setText(String.format("%e", DataConverter.convertKiloBytesToMegaBytes(input)));
        gigaBytes.setText(String.format("%e", DataConverter.convertKiloBytesToGigaBytes(input)));
        teraBytes.setText(String.format("%e", DataConverter.convertKiloBytesToTeraBytes(input)));
    }
    @SuppressLint("DefaultLocale")
    private void calculateMegaBytes(double input) {
        megaBytes.setText(String.valueOf((int) input));
        bits.setText(String.format("%e", DataConverter.convertMegaBytesToBits(input)));
        nibbles.setText(String.format("%e", DataConverter.convertMegaBytesToNibbles(input)));
        kiloBytes.setText(String.format("%e", DataConverter.convertMegaBytesToKiloBytes(input)));
        bytes.setText(String.format("%e", DataConverter.convertMegaBytesToBytes(input)));
        gigaBytes.setText(String.format("%e", DataConverter.convertMegaBytesToGigaBytes(input)));
        teraBytes.setText(String.format("%e", DataConverter.convertMegaBytesToTeraBytes(input)));
    }

    @SuppressLint("DefaultLocale")
    private void calculateGigaBytes(double input) {
        gigaBytes.setText(String.valueOf((int) input));
        bits.setText(String.format("%e", DataConverter.convertGigaBytesToBits(input)));
        nibbles.setText(String.format("%e", DataConverter.convertGigaBytesToNibbles(input)));
        kiloBytes.setText(String.format("%e", DataConverter.convertGigaBytesToKiloBytes(input)));
        bytes.setText(String.format("%e", DataConverter.convertGigaBytesToBytes(input)));
        megaBytes.setText(String.format("%e", DataConverter.convertGigaBytesToMegaBytes(input)));
        teraBytes.setText(String.format("%e", DataConverter.convertGigaBytesToTeraBytes(input)));
    }

    @SuppressLint("DefaultLocale")
    private void calculateTeraBytes(double input) {
        teraBytes.setText(String.valueOf((int) input));
        bits.setText(String.format("%e", DataConverter.convertTeraBytesToBits(input)));
        nibbles.setText(String.format("%e", DataConverter.convertTeraBytesToNibbles(input)));
        kiloBytes.setText(String.format("%e", DataConverter.convertTeraBytesToKiloBytes(input)));
        bytes.setText(String.format("%e", DataConverter.convertTeraBytesToBytes(input)));
        megaBytes.setText(String.format("%e", DataConverter.convertTeraBytesToMegaBytes(input)));
        gigaBytes.setText(String.format("%e", DataConverter.convertTeraBytesToGigaBytes(input)));
    }
}