package com.example.changex;

import android.content.Context;
import android.content.res.Resources;
import android.net.Uri;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;


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
