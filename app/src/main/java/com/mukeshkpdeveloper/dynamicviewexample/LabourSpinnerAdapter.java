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

public class LabourSpinnerAdapter extends ArrayAdapter<ContractorModel> {

    public LabourSpinnerAdapter(Context context, int id,
                                List<ContractorModel> algorithmList) {
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
        if (convertView == null) {
            convertView = LayoutInflater.from(getContext()).inflate(R.layout.varient_item_layout, parent, false);
        }
        TextView nameTv = convertView.findViewById(R.id.nameTv);
        ContractorModel currentItem = getItem(position);
        if (currentItem != null) {
            if(currentItem.getPid() == 0){
                nameTv.setText("Select Contractor");
            }else{
                nameTv.setText(currentItem.contractorName);
            }
        }
        return convertView;
    }
}
