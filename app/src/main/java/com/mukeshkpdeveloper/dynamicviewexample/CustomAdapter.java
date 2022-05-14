package com.mukeshkpdeveloper.dynamicviewexample;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class CustomAdapter extends RecyclerView.Adapter<CustomAdapter.MyViewHolder> {

    private static ArrayList<DataModel> dataSet;
    private static ArrayList<DataModel> dataSetLabour = new ArrayList<>();
    ItemClickListener itemClickListener;
    int selectedPosition=-1;
    LabourAdapter recyclerDataAdapter;

    public static class MyViewHolder extends RecyclerView.ViewHolder {

        TextView textViewName;
        CardView addContractor, removeContractor;
        RecyclerView rv_sub_loaction;

        public MyViewHolder(View itemView) {
            super(itemView);
            this.textViewName = itemView.findViewById(R.id.textViewName);
            this.addContractor = itemView.findViewById(R.id.multi_contractor_add);
            this.removeContractor = itemView.findViewById(R.id.multi_contractor_remove);
            this.rv_sub_loaction = itemView.findViewById(R.id.rv_sub_loaction);

        }
    }

    public CustomAdapter(ArrayList<DataModel> data, ItemClickListener itemClickListener) {
        this.dataSet = data;
        this.itemClickListener=itemClickListener;
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent,
                                           int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.cards_layout, parent, false);


        MyViewHolder myViewHolder = new MyViewHolder(view);
        return myViewHolder;
    }

    @Override
    public void onBindViewHolder(final MyViewHolder holder, final int listPosition) {

        TextView textViewName = holder.textViewName;
        CardView addContractor = holder.addContractor;
        CardView removeContractor = holder.removeContractor;
        RecyclerView rv_sub_loaction = holder.rv_sub_loaction;

        textViewName.setText(dataSet.get(listPosition).getName());

        addContractor.setOnClickListener(new View.OnClickListener() {
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
        });

        DataModel dataModel = new DataModel(
                "Test", "2", R.drawable.ic_launcher_background, 0
        );
        dataSetLabour.add(dataModel);
        recyclerDataAdapter = new LabourAdapter(dataSetLabour);
      //  rv_sub_loaction = new LinearLayoutManager(this);
        rv_sub_loaction.setAdapter(recyclerDataAdapter);
        recyclerDataAdapter.notifyDataSetChanged();
    }

    @Override
    public int getItemCount() {
        return dataSet.size();
    }
}
