package com.mukeshkpdeveloper.dynamicviewexample;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class LabourAdapter extends RecyclerView.Adapter<LabourAdapter.MyViewHolder> {

    private static ArrayList<LabourModel> dataSetLabour;
    int selectedPosition = -1;
    Context mContext;

    public LabourAdapter(ArrayList<LabourModel> data, Context mContext) {
        this.dataSetLabour = data;
        this.mContext = mContext;
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

        addContractor.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int position = holder.getAdapterPosition();
                selectedPosition = position;
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
    }

    @Override
    public int getItemCount() {
        return dataSetLabour.size();
    }

    public static class MyViewHolder extends RecyclerView.ViewHolder {

        TextView textViewName;
        CardView addContractor, removeContractor;
        RecyclerView rv_sub_loaction;

        public MyViewHolder(View itemView) {
            super(itemView);
            this.addContractor = itemView.findViewById(R.id.button1);
            this.removeContractor = itemView.findViewById(R.id.button2);

        }
    }
}
