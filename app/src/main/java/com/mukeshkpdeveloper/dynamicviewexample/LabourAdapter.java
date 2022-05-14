package com.mukeshkpdeveloper.dynamicviewexample;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class LabourAdapter extends RecyclerView.Adapter<LabourAdapter.MyViewHolder> {

    private static ArrayList<DataModel> dataSetLabour;
    ItemClickListener itemClickListener;
    int selectedPosition=-1;

    public static class MyViewHolder extends RecyclerView.ViewHolder {

        TextView textViewName;
        CardView addContractor, removeContractor;
        RecyclerView rv_sub_loaction;

        public MyViewHolder(View itemView) {
            super(itemView);
            this.addContractor = itemView.findViewById(R.id.multi_contractor_add);
            this.removeContractor = itemView.findViewById(R.id.multi_contractor_remove);

        }
    }

    public LabourAdapter(ArrayList<DataModel> data) {
        this.dataSetLabour = data;
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



        /*addContractor.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int position=holder.getAdapterPosition();
                itemClickListener.onClick(position,"hello", "add");
                selectedPosition=position;
                if (selectedPosition == 0) {
                    addContractor.setVisibility(View.GONE);
                }
                notifyDataSetChanged();
            }
        });

        removeContractor.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int position=holder.getAdapterPosition();
                itemClickListener.onClick(position,"hello", "remove");
                selectedPosition=position;
                if (selectedPosition == 0) {
                    addContractor.setVisibility(View.VISIBLE);
                }
                notifyDataSetChanged();
            }
        });*/
    }

    @Override
    public int getItemCount() {
        return 1;
    }
}
