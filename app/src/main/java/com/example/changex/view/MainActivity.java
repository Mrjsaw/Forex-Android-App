package com.example.changex.view;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;

import com.example.changex.R;
import com.example.changex.service.NetworkController;

public class MainActivity extends AppCompatActivity {

    private EditText amount;
    private Spinner currencyOne;
    private Spinner currencyTwo;
    private ArrayAdapter<CharSequence> adapter;
    private TextView rate;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        currencyOne = findViewById(R.id.currencyOne);
        currencyTwo = findViewById(R.id.currencyTwo);
        amount = findViewById(R.id.exchangeAmount);
        rate = findViewById(R.id.rate);
        adapter = ArrayAdapter.createFromResource(this,
                R.array.currencies, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        currencyOne.setAdapter(adapter);
        currencyTwo.setAdapter(adapter);
    }

    public void onClickExchange(View v) {
        NetworkController.getInstance(this).getLatestHTTP("latest?base=","USD");
    }

}
