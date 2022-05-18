package com.mukeshkpdeveloper.dynamicviewexample;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class CustomAdapter extends RecyclerView.Adapter<CustomAdapter.MyViewHolder>  {

    private static ArrayList<DataModel> dataSet;
    private static ArrayList<LabourModel> dataSetLabour;
    ItemClickListener itemClickListener;
    int selectedPosition=-1;
    LabourAdapter recyclerDataAdapter;
    Context mContext;
   // private static LabourAdapter.MyClickListener myClickListener;

    /*@Override
    public void onItemClick(int position, int pos, View v) {
        LabourModel dataModel = new LabourModel(
                "Test", pos);
        recyclerDataAdapter.notifyItemInserted(pos);
    }*/

    public static class MyViewHolder extends RecyclerView.ViewHolder {

        TextView textViewName;
        CardView addContractor, removeContractor;
        RecyclerView rv_sub_loaction;

        public MyViewHolder(View itemView) {
            super(itemView);
            this.textViewName = itemView.findViewById(R.id.textViewName);
            this.addContractor = itemView.findViewById(R.id.multi_contractor_add);
            this.removeContractor = itemView.findViewById(R.id.multi_contractor_remove);
          //  this.rv_sub_loaction = itemView.findViewById(R.id.rv_sub_loaction);

        }
    }

    public CustomAdapter(ArrayList<DataModel> data, Context mContext, ItemClickListener itemClickListener) {
        this.dataSet = data;
        this.itemClickListener=itemClickListener;
        this.mContext=mContext;
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent,
                                           int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.cards_layout, parent, false);


        MyViewHolder myViewHolder = new MyViewHolder(view);
      //  myClickListener = this;
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

        dataSetLabour = new ArrayList<>();
        LabourModel dataModel = new LabourModel();
        dataSetLabour.add(dataModel);
        recyclerDataAdapter = new LabourAdapter(dataSetLabour, mContext);
        rv_sub_loaction.setLayoutManager(new LinearLayoutManager(mContext));
        rv_sub_loaction.setAdapter(recyclerDataAdapter);
        recyclerDataAdapter.notifyDataSetChanged();
    }

    @Override
    public int getItemCount() {
        return dataSet.size();
    }
}
