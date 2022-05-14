package com.mukeshkpdeveloper.dynamicviewexample;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Context;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private static RecyclerView.Adapter adapter;
    private RecyclerView.LayoutManager layoutManager;
    private static RecyclerView recyclerView;
    private static ArrayList<DataModel> data;
    private static ArrayList<Integer> removedItems;
    ItemClickListener itemClickListener;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        data = new ArrayList<DataModel>();

        recyclerView = (RecyclerView) findViewById(R.id.my_recycler_view);
        recyclerView.setHasFixedSize(true);

        layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setItemAnimator(new DefaultItemAnimator());

        // Initialize listener
        itemClickListener= new ItemClickListener() {
            @Override
            public void onClick(int position, String value, String flag) {
                if (flag.equalsIgnoreCase("add")) {
                    DataModel dataModel = new DataModel(
                            "Test", "2", R.drawable.ic_launcher_background, 0
                    );
                    data.add(dataModel);
                    Toast.makeText(getApplicationContext(),"Position : "
                            +position +" || Value : "+value,Toast.LENGTH_SHORT).show();
                } else {
                    if (data.size() > 1) {
                        data.remove(position);
                    }
                    Toast.makeText(getApplicationContext(),"Position : "
                            +position +" || Value : "+value,Toast.LENGTH_SHORT).show();
                }
            }
        };

        DataModel dataModel = new DataModel(
                "Test", "1", R.drawable.ic_launcher_background, 0
        );
        data.add(dataModel);
        removedItems = new ArrayList<Integer>();

        adapter = new CustomAdapter(data, itemClickListener);
        recyclerView.setAdapter(adapter);
    }


}