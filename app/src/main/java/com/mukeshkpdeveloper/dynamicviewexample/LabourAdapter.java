package com.mukeshkpdeveloper.dynamicviewexample;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.Spinner;
import android.widget.Toast;

import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class LabourAdapter extends RecyclerView.Adapter<LabourAdapter.MyViewHolder> {

    private static ArrayList<LabourModel> dataSetLabour;
    int selectedPosition = -1;
    Context mContext;
    MyClickListener myClickListener;
    String value = "";

    public LabourAdapter(ArrayList<LabourModel> data, Context mContext , MyClickListener myClickListener) {
        this.dataSetLabour = data;
        this.mContext = mContext;
        this.myClickListener = myClickListener;
    }
    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent,
                                           int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.cards_labour_layout, parent, false);


        MyViewHolder myViewHolder = new MyViewHolder(view);
        return myViewHolder;
    }

    @Override
    public void onBindViewHolder(final MyViewHolder holder, final int listPosition) {

        CardView addContractor = holder.addContractor;
        CardView removeContractor = holder.removeContractor;
        Spinner spinnerLabourName = holder.spinnerLabourName;

        addContractor.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int position = holder.getAdapterPosition();
                selectedPosition = position;
                myClickListener.onClick(position,value, "flag");
                Toast.makeText(holder.addContractor.getContext(), ":: " + selectedPosition, Toast.LENGTH_SHORT).show();
                LabourModel dataModel = new LabourModel(
                        "Test", 0);
                dataSetLabour.add(dataModel);
                notifyDataSetChanged();
            }
        });

        removeContractor.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int position = holder.getAdapterPosition();
                selectedPosition = position;
                Toast.makeText(holder.removeContractor.getContext(), ":: " + selectedPosition, Toast.LENGTH_SHORT).show();
                if (dataSetLabour.size() > 1) {
                    dataSetLabour.remove(position);
                }
                notifyDataSetChanged();
            }
        });

        ArrayList<ContractorModel> variant = new ArrayList<>();
        for (int i = 0; i < 5; i++) {
            ContractorModel contractorModel= new ContractorModel();
            contractorModel.setPid(i);
            contractorModel.setContractorName("Test "+i);
            variant.add(contractorModel);
        }

        LabourSpinnerAdapter adapter = new LabourSpinnerAdapter(holder.context, android.R.layout.simple_spinner_item, variant);
        spinnerLabourName.setAdapter(adapter);
        spinnerLabourName.setOnItemSelectedListener(
                new AdapterView.OnItemSelectedListener() {
                    @Override
                    public void onItemSelected(AdapterView<?> parent,
                                               View view, int position, long id) {

                        ContractorModel clickedItem = (ContractorModel)
                                parent.getItemAtPosition(position);

                        value = clickedItem.getContractorName();
                        Log.d("TAG", "onItemSelected: "+value);
                    }

                    @Override
                    public void onNothingSelected(AdapterView<?> parent) {

                    }
                });

        if (value.equalsIgnoreCase("Test 0")){
            Log.d("value-TAG", "onBindViewHolder: Not ZERO"+value);
        }else {
            Log.d("value-TAG", "onBindViewHolder: ZERO"+value);
        }
    }

    @Override
    public int getItemCount() {
        return dataSetLabour.size();
    }

    public static class MyViewHolder extends RecyclerView.ViewHolder {

        CardView addContractor, removeContractor;
        Context context;
        Spinner spinnerLabourName;

        public MyViewHolder(View itemView) {
            super(itemView);
            context = itemView.getContext();
            this.addContractor = itemView.findViewById(R.id.button1);
            this.removeContractor = itemView.findViewById(R.id.button2);
            this.spinnerLabourName = itemView.findViewById(R.id.spinner_labor_name);

        }
    }
}
