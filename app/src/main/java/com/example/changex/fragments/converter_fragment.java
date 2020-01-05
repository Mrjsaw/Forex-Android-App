package com.example.changex.fragments;

import android.os.Bundle;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.example.changex.adapters.NetworkAdapter;
import com.example.changex.R;

import java.util.ArrayList;

public class converter_fragment extends Fragment  implements AdapterView.OnItemSelectedListener{

    private Spinner spinner;
    private String[] paths;
    private TextView amount;
    private EditText value;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.converter_layout, container, false);
        paths = getResources().getStringArray(R.array.currencies);
        return rootView;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        spinner = (Spinner) getView().findViewById(R.id.spinnerTwo);
        ArrayAdapter<String>adapter = new ArrayAdapter<>(getActivity(),
                android.R.layout.simple_spinner_item,paths);
        amount = getView().findViewById(R.id.amount_conv);
        value = getView().findViewById(R.id.getValue);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(adapter);
        spinner.setOnItemSelectedListener(this);
    }

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
        Toast toast;
        ArrayList<String> rates = NetworkAdapter.getInstance(getContext().getApplicationContext()).getRates();
        int number = Integer.parseInt(value.getText().toString());
        Double d;
        switch (position) {
            case 0:
                toast = Toast.makeText(getActivity().getApplicationContext(),"USD",Toast. LENGTH_SHORT);
                toast.show();
                d = number * Double.parseDouble(rates.get(position));
                amount.setText(d.toString());
                break;
            case 1:
                toast = Toast.makeText(getActivity().getApplicationContext(),"EUR",Toast. LENGTH_SHORT);
                toast.show();
                d = number * Double.parseDouble(rates.get(position));
                amount.setText(d.toString());
                break;
            case 2:
                toast = Toast.makeText(getActivity().getApplicationContext(),"GBP",Toast. LENGTH_SHORT);
                toast.show();
                d = number * Double.parseDouble(rates.get(position));
                amount.setText(d.toString());
                break;
            case 3:
                toast = Toast.makeText(getActivity().getApplicationContext(),"JPY",Toast. LENGTH_SHORT);
                toast.show();
                d = number * Double.parseDouble(rates.get(position));
                amount.setText(d.toString());
                break;
            case 4:
                toast = Toast.makeText(getActivity().getApplicationContext(),"CAD",Toast. LENGTH_SHORT);
                toast.show();
                d = number * Double.parseDouble(rates.get(position));
                amount.setText(d.toString());
                break;
            case 5:
                toast = Toast.makeText(getActivity().getApplicationContext(),"CNY",Toast. LENGTH_SHORT);
                toast.show();
                d = number * Double.parseDouble(rates.get(position));
                amount.setText(d.toString());
                break;
            case 6:
                toast = Toast.makeText(getActivity().getApplicationContext(),"INR",Toast. LENGTH_SHORT);
                toast.show();
                d = number * Double.parseDouble(rates.get(position));
                amount.setText(d.toString());
                break;
            case 7:
                toast = Toast.makeText(getActivity().getApplicationContext(),"HKD",Toast. LENGTH_SHORT);
                toast.show();
                d = number * Double.parseDouble(rates.get(position));
                amount.setText(d.toString());
                break;
            case 8:
                toast = Toast.makeText(getActivity().getApplicationContext(),"AUD",Toast. LENGTH_SHORT);
                toast.show();
                d = number * Double.parseDouble(rates.get(position));
                amount.setText(d.toString());
                break;
            case 9:
                toast = Toast.makeText(getActivity().getApplicationContext(),"IDR",Toast. LENGTH_SHORT);
                toast.show();
                d = number * Double.parseDouble(rates.get(position));
                amount.setText(d.toString());
                break;
            case 10:
                toast = Toast.makeText(getActivity().getApplicationContext(),"TRY",Toast. LENGTH_SHORT);
                toast.show();
                d = number * Double.parseDouble(rates.get(position));
                amount.setText(d.toString());
                break;
        }
    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }
}
