package com.mukeshkpdeveloper.dynamicviewexample;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.Spinner;
import android.widget.TextView;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class CustomAdapter extends RecyclerView.Adapter<CustomAdapter.MyViewHolder> implements MyClickListener {

    private static ArrayList<DataModel> dataSet;
    private static ArrayList<LabourModel> dataSetLabour;
    ItemClickListener itemClickListener;
    int selectedPosition=-1;
    LabourAdapter recyclerDataAdapter;
    Context mContext;
    MyClickListener myClickListener;
    String values = "";
    String contactorValue = "";

    public static class MyViewHolder extends RecyclerView.ViewHolder {

        TextView textViewName;
        CardView addContractor, removeContractor;
        RecyclerView rv_sub_loaction;
        Spinner spinnerContractorName;
        Context context;

        public MyViewHolder(View itemView) {
            super(itemView);
            context = itemView.getContext();
            this.textViewName = itemView.findViewById(R.id.textViewName);
            this.addContractor = itemView.findViewById(R.id.multi_contractor_add);
            this.removeContractor = itemView.findViewById(R.id.multi_contractor_remove);
            this.rv_sub_loaction = itemView.findViewById(R.id.rv_sub_loaction);
            this.spinnerContractorName = itemView.findViewById(R.id.priceSpinner);
        }
    }

    public CustomAdapter(ArrayList<DataModel> data, Context mContext, ItemClickListener itemClickListener) {
        this.dataSet = data;
        this.itemClickListener=itemClickListener;
        this.mContext=mContext;
    }

    @Override
    public void onClick(int position, String value, String flag) {
        Log.d("TAG", "onItemClick_labour::::::::::::::::::::::: "+position+"value:::: "+value);
        values = value;
        recyclerDataAdapter.notifyItemInserted(position);
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent,
                                           int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.cards_layout, parent, false);


        MyViewHolder myViewHolder = new MyViewHolder(view);
        myClickListener = this;
        return myViewHolder;
    }

    @Override
    public void onBindViewHolder(final MyViewHolder holder, final int listPosition) {

        TextView textViewName = holder.textViewName;
        CardView addContractor = holder.addContractor;
        CardView removeContractor = holder.removeContractor;
        RecyclerView rv_sub_loaction = holder.rv_sub_loaction;
        Spinner spinnerContractorName = holder.spinnerContractorName;

        textViewName.setText(dataSet.get(listPosition).getName());

        addContractor.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int position=holder.getAdapterPosition();
                itemClickListener.onClick(position,contactorValue, "add");
                selectedPosition=position;
                notifyDataSetChanged();
            }
        });

        removeContractor.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int position=holder.getAdapterPosition();
                itemClickListener.onClick(position,"hello", "remove");
                selectedPosition=position;
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
        spinnerContractorName.setAdapter(adapter);
        spinnerContractorName.setOnItemSelectedListener(
                new AdapterView.OnItemSelectedListener() {
                    @Override
                    public void onItemSelected(AdapterView<?> parent,
                                               View view, int position, long id) {

                        ContractorModel clickedItem = (ContractorModel)
                                parent.getItemAtPosition(position);

                        contactorValue = clickedItem.getContractorName();
                    }

                    @Override
                    public void onNothingSelected(AdapterView<?> parent) {

                    }
                });

        dataSetLabour = new ArrayList<>();
        LabourModel dataModel = new LabourModel(
                "Test",  0);
        dataSetLabour.add(dataModel);
        recyclerDataAdapter = new LabourAdapter(dataSetLabour, mContext, myClickListener);
        rv_sub_loaction.setLayoutManager(new LinearLayoutManager(mContext));
        rv_sub_loaction.setAdapter(recyclerDataAdapter);
        recyclerDataAdapter.notifyDataSetChanged();

    }


    @Override
    public int getItemCount() {
        return dataSet.size();
    }
}
