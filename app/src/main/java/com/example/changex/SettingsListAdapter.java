package com.example.changex;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.content.ContextCompat;

import java.util.List;

public class SettingsListAdapter extends ArrayAdapter<String> {

    public SettingsListAdapter(@NonNull Context context, @NonNull List<String> objects) {
        super(context,0, objects);
    }
    private static class ViewHolder {
        TextView option;
    }

    private int lastPosition = -1;

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        String options = getItem(position);
        SettingsListAdapter.ViewHolder viewHolder;
        final View result;
        if (convertView == null) {
            viewHolder = new SettingsListAdapter.ViewHolder();
            LayoutInflater inflater = LayoutInflater.from(getContext());
            convertView = inflater.inflate(R.layout.setting_row, parent, false);
            viewHolder.option = (TextView) convertView.findViewById(R.id.option);
            convertView.setTag(viewHolder);
            //convertView = LayoutInflater.from(getContext()).inflate(R.layout.row, parent, false);

        } else {
            viewHolder = (SettingsListAdapter.ViewHolder) convertView.getTag();
        }
        lastPosition = position;
        viewHolder.option.setText(options);
        return convertView;
    }

}
