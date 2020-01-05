package com.example.changex.fragments;

import android.content.res.Resources;
import android.os.Bundle;
import androidx.fragment.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import com.example.changex.R;
import com.example.changex.adapters.SettingsListAdapter;

import java.util.ArrayList;


public class settings_fragment extends Fragment {
    public SettingsListAdapter itemsAdapter;
    public ListView listView;
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.settings_layout, container, false);
        return rootView;
    }
    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        listView = getView().findViewById(R.id.settings_list);
        Resources res = getResources();
        String [] settings = res.getStringArray(R.array.setting_list);
        ArrayList<String> myList = new ArrayList<>();
        for(String s : settings) {
            myList.add(s);
        }
        itemsAdapter = new SettingsListAdapter(getActivity(), myList);
        listView.setAdapter(itemsAdapter);
    }


}
