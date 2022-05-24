package com.mukeshkpdeveloper.dynamicviewexample;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatButton;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Context;
import android.graphics.Color;
import android.os.Bundle;
import android.text.InputType;
import android.util.Log;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = "MainActivity";
    private static ArrayList<DataModel> data;
    private static ArrayList<LabourModel> labourList;
    int count = 0;
    ArrayList<View> listOfViewGroups;
    LinearLayout ll;
    LinearLayout llabour;

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
                // data get here
                checkFilledData();

            }
        });

        for (int j = 0; j < 5; j++) {
            DataModel dataModel = new DataModel();
            dataModel.setId_(j);
            dataModel.setName("Test"+j);
            data.add(dataModel);
        }

        for (int j = 0; j < 5; j++) {
            LabourModel dataModel = new LabourModel();
            dataModel.setId_(j);
            dataModel.setName("Test"+j);
            labourList.add(dataModel);
        }

        createLayout();

    }

    private void checkFilledData() {
        for(int i=0; i<(ll.getChildCount()); ++i) {
            View child= ll.getChildAt(i);
            Spinner spinner_contractor_name = (Spinner) child.findViewById(R.id.spinner_contractor_name);
            DataModel clickedItem = (DataModel) spinner_contractor_name.getSelectedItem();
            Log.e(TAG, "checkFilledData: "+clickedItem);

            for (int j = 0; j <(llabour.getChildCount()); j++) {
                View child1= llabour.getChildAt(j);
                EditText uredt = (EditText)child1.findViewById(R.id.et_time);
                Log.e(TAG, "checkFilledData: "+uredt.getText().toString());
            }

        }
    }

    private void createLayout() {
        for (int i = 0; i < 1; i++) {
            LayoutInflater inflater = LayoutInflater.from(MainActivity.this);
            ll = (LinearLayout) findViewById(R.id.container_destacado);

            View inflatedLayout= inflater.inflate(R.layout.cards_layout, null);

            CardView multi_contractor_add = inflatedLayout.findViewById(R.id.multi_contractor_add);
            Spinner spinner_contractor_name = inflatedLayout.findViewById(R.id.spinner_contractor_name);
         //   CardView button1 = inflatedLayout.findViewById(R.id.button1);

            Log.e(TAG, "createLayout: "+data.size() );
            ContractorSpinnerAdapter adapter = new ContractorSpinnerAdapter(MainActivity.this, android.R.layout.simple_spinner_item, data);
            spinner_contractor_name.setAdapter(adapter);

            spinner_contractor_name.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                @Override
                public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {

                    DataModel clickedItem = (DataModel) adapterView.getItemAtPosition(i);
                    Log.e(TAG, "onItemSelected: "+clickedItem.getName());

                    for (int j = 0; j < data.size(); j++) {
                        Log.d(TAG, "onItemSelected: "+data.get(j).isSelected);
                        if (data.get(j).getId_() == clickedItem.getId_()) {
                            data.get(j).setSelected(true);
                        }

                    }
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
            createMultiLabourUI(inflatedLayout);

        }
    }

    private void createMultiLabourUI(View view) {
        for (int i = 0; i < 1; i++) {
            LayoutInflater inflater = LayoutInflater.from(MainActivity.this);
            llabour = view.findViewById(R.id.multi_labour_detail);

            View inflatedLayout = inflater.inflate(R.layout.multi_labour_layout, null);

            CardView button1 = inflatedLayout.findViewById(R.id.button1);
            CardView button2 = inflatedLayout.findViewById(R.id.button2);
            Spinner spinner_labor_name = inflatedLayout.findViewById(R.id.spinner_labor_name);

            /*laborSpinnerAdapter = new LaborSpinnerAdapter(this, laborModels);
            spinner_labor_name.setAdapter(laborSpinnerAdapter);

            final LaborModel[] lastClick = {new LaborModel()};
            final int[] lastClickedPosition = {0};
            spinner_labor_name.setOnTouchListener(new View.OnTouchListener() {
                @Override
                public boolean onTouch(View v, MotionEvent event) {
                    if (event.getAction() == MotionEvent.ACTION_UP) {
                        //Your code
                        lastClick[0] = (LaborModel) spinner_labor_name.getSelectedItem();
                        lastClickedPosition[0] = spinner_labor_name.getSelectedItemPosition();

                    }

                    return false;
                }
            });
            spinner_labor_name.setOnItemSelectedListener(
                    new AdapterView.OnItemSelectedListener() {
                        @Override
                        public void onItemSelected(AdapterView<?> parent,
                                                   View view, int position, long id) {
                            LaborModel clickedItem = (LaborModel)
                                    parent.getItemAtPosition(position);

                            if (clickedItem.isSelected()) {
                                Toast.makeText(MainActivity.this, "this item is already Selected", Toast.LENGTH_SHORT).show();
                                parent.setSelection(lastClickedPosition[0]);
                            }

                            if (position > 0) {
                                contractor_labour_linking_id = clickedItem.getContractor_labour_linking_id();
                                for (int i = 0; i < laborModels.size(); i++) {
                                    if (laborModels.get(i).getContractor_labour_linking_id() == lastClick[0].getContractor_labour_linking_id()) {
                                        laborModels.get(i).setSelected(false);
                                        clickedItem.setTime("");
                                    }
                                    if (contractor_labour_linking_id == laborModels.get(i).getContractor_labour_linking_id()) {
                                        clickedItem.setTime(et_time.getText().toString());
                                        clickedItem.setSelected(true);
                                    }
                                }
                            }

                        }

                        @Override
                        public void onNothingSelected(AdapterView<?> parent) {
                        }
                    });*/

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


            button1.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    ++count;
                    createMultiLabourUI(view);
                }
            });
            button2.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Log.e(TAG, "onClick_count: "+count);
                    if (count >= 0) {
                        llabour.removeViewAt(count);
                        --count;
                    } else {
                        Log.e(TAG, "onClick_count else : "+count);
                    }
                }
            });

            llabour.addView(inflatedLayout);
        }
    }


}