package com.mukeshkpdeveloper.dynamicviewexample;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import java.util.ArrayList;

public class ContractorSpinnerAdapter extends ArrayAdapter<ContractorModel> {

    public ContractorSpinnerAdapter(Context context,
                                    ArrayList<ContractorModel> contractorModels)
    {
        super(context, 0, contractorModels);
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable
            View convertView, @NonNull ViewGroup parent)
    {
        return initView(position, convertView, parent);
    }

    @Override
    public View getDropDownView(int position, @Nullable
            View convertView, @NonNull ViewGroup parent)
    {
        return initView(position, convertView, parent);
    }

    private View initView(int position, View convertView,
                          ViewGroup parent)
    {
        // It is used to set our custom view.
        if (convertView == null) {
            convertView = LayoutInflater.from(getContext()).inflate(R.layout.contractor_spinner_item, parent, false);
        }

        TextView textViewName = convertView.findViewById(R.id.text_view);
        ContractorModel currentItem = getItem(position);

        if (currentItem != null) {
            textViewName.setText(currentItem.getContractorName());
        }
        return convertView;
    }
}