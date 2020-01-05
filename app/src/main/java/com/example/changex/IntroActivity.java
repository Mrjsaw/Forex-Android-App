package com.example.changex;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.Toast;

public class IntroActivity extends AppCompatActivity implements AdapterView.OnItemSelectedListener {
    Button myButton;
    Spinner mySpinner;
    private String[] paths;
    private String prefCurrency;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_intro);
        myButton = (Button) findViewById(R.id.introButton);
        mySpinner = (Spinner) findViewById(R.id.currencySpinner);
        paths = getResources().getStringArray(R.array.currencies);
        ArrayAdapter<String> adapter = new ArrayAdapter<>(this,
                android.R.layout.simple_spinner_item,paths);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        mySpinner.setAdapter(adapter);
        mySpinner.setOnItemSelectedListener(this);
    }

    public void onButtonClick(View v) {
        Intent myIntent = new Intent(IntroActivity.this, MainActivity.class);
        myIntent.putExtra("currency",prefCurrency);
        startActivity(myIntent);
    }

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
        switch (position) {
            case 0:
                prefCurrency = "USD";
                break;
            case 1:
                prefCurrency = "EUR";
                break;
            case 2:
                prefCurrency = "GBP";
                break;
            case 3:
                prefCurrency = "JPY";
                break;
            case 4:
                prefCurrency = "CAD";
                break;
            case 5:
                prefCurrency = "CNY";
                break;
            case 6:
                prefCurrency = "INR";
                break;
            case 7:
                prefCurrency = "HKD";
                break;
            case 8:
                prefCurrency = "AUD";
                break;
            case 9:
                prefCurrency = "IDR";
                break;
            case 10:
                prefCurrency = "TRY";
                break;
        }
    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }
}
