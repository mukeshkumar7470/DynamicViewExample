package com.mukeshkpdeveloper.dynamicviewexample;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.AdapterView;
import android.widget.LinearLayout;
import android.widget.Spinner;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatButton;
import androidx.cardview.widget.CardView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = "MainActivity";
    private static ArrayList<DataModel> data;
    private static ArrayList<LabourModel> labourList;
    int count = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        data = new ArrayList<DataModel>();
        labourList = new ArrayList<LabourModel>();


        AppCompatButton btnCheckData = findViewById(R.id.btnCheckData);
        btnCheckData.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });

        for (int j = 0; j < 5; j++) {
            DataModel dataModel = new DataModel();
            dataModel.setId_(j);
            dataModel.setName("Test" + j);
            data.add(dataModel);
        }

        for (int j = 0; j < 5; j++) {
            LabourModel dataModel = new LabourModel();
            dataModel.setId_(j);
            dataModel.setName("Test" + j);
            labourList.add(dataModel);
        }

        createLayout();

    }

    private void createLayout() {
        for (int i = 0; i < 1; i++) {
            LayoutInflater inflater = LayoutInflater.from(MainActivity.this);
            LinearLayout ll = (LinearLayout) findViewById(R.id.container_destacado);

            View inflatedLayout = inflater.inflate(R.layout.cards_layout, null);

            CardView multi_contractor_add = inflatedLayout.findViewById(R.id.multi_contractor_add);
            Spinner spinner_contractor_name = inflatedLayout.findViewById(R.id.spinner_contractor_name);
            Spinner spinner_labor_name = inflatedLayout.findViewById(R.id.spinner_labor_name);

            Log.e(TAG, "createLayout: " + data.size());
            ContractorSpinnerAdapter adapter = new ContractorSpinnerAdapter(MainActivity.this, android.R.layout.simple_spinner_item, data);
            spinner_contractor_name.setAdapter(adapter);

            spinner_contractor_name.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                @Override
                public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {

                    DataModel clickedItem = (DataModel) adapterView.getItemAtPosition(i);
                    Log.e(TAG, "onItemSelected: " + clickedItem.getName());

                    for (int j = 0; j < data.size(); j++) {
                        Log.d(TAG, "onItemSelected: " + data.get(j).isSelected);
                        if (data.get(j).getId_() == clickedItem.getId_()) {
                            data.get(j).setSelected(true);
                        }

                    }
                }

                @Override
                public void onNothingSelected(AdapterView<?> adapterView) {

                }
            });

            LabourSpinnerAdapter labourSpinnerAdapter = new LabourSpinnerAdapter(MainActivity.this, android.R.layout.simple_spinner_item, labourList);
            spinner_labor_name.setAdapter(labourSpinnerAdapter);

            spinner_labor_name.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                @Override
                public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {

                }

                @Override
                public void onNothingSelected(AdapterView<?> adapterView) {

                }
            });


            multi_contractor_add.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    createLayout();
                }
            });


            CardView multi_contractor_remove = inflatedLayout.findViewById(R.id.multi_contractor_remove);

            multi_contractor_remove.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Log.e(TAG, "onClick: ");
                }
            });

            ll.addView(inflatedLayout);
        }

    }


}