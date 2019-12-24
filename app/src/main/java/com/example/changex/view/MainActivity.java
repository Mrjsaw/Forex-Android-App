package com.example.changex.view;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;

import com.example.changex.R;

public class MainActivity extends AppCompatActivity {

    private EditText amount;
    private Spinner currencyOne;
    private Spinner currencyTwo;
    private ArrayAdapter<CharSequence> adapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        currencyOne = findViewById(R.id.currencyOne);
        currencyTwo = findViewById(R.id.currencyTwo);
        amount = findViewById(R.id.exchangeAmount);
        adapter = ArrayAdapter.createFromResource(this,
                R.array.currencies, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        currencyOne.setAdapter(adapter);
        currencyTwo.setAdapter(adapter);
    }

}
