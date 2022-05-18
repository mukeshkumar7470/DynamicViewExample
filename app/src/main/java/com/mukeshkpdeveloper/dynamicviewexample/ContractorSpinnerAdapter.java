package com.mukeshkpdeveloper.dynamicviewexample;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import java.util.List;

public class ContractorSpinnerAdapter extends ArrayAdapter<DataModel> {

    public ContractorSpinnerAdapter(Context context, int id,
                                    List<DataModel> algorithmList) {
        super(context, id, algorithmList);
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable
            View convertView, @NonNull ViewGroup parent) {
        return initView(position, convertView, parent);
    }

    @Override
    public View getDropDownView(int position, @Nullable
            View convertView, @NonNull ViewGroup parent) {
        return initView(position, convertView, parent);
    }

    private View initView(int position, View convertView,
                          ViewGroup parent) {
        // It is used to set our custom view.
        if (convertView == null) {
            convertView = LayoutInflater.from(getContext()).inflate(R.layout.item_layout, parent, false);
        }
        TextView nameTv = convertView.findViewById(R.id.nameTv);
        DataModel currentItem = getItem(position);


        if (currentItem != null) {
            if (currentItem.isSelected()) {
                nameTv.setTextColor(getContext().getColor(R.color.purple_200));
            } else {
                nameTv.setTextColor(getContext().getColor(R.color.black));
            }
            if(currentItem.getId_() == 0){
                  nameTv.setText("Select Contractor");
            }else{
                nameTv.setText(currentItem.getName());
            }

        }
        return convertView;
    }
}
