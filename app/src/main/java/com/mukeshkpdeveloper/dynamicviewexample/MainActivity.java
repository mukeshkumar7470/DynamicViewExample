package com.mukeshkpdeveloper.dynamicviewexample;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatButton;
import androidx.cardview.widget.CardView;
import androidx.core.content.ContextCompat;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Context;
import android.graphics.Color;
import android.os.Bundle;
import android.text.InputType;
import android.view.Gravity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    int const_count = 0;
    private int count = 0;
    Context context;
    CardView multi_contractor_add, multi_contractor_remove;
    LinearLayout rl_const_layout, ll, ll_labour;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        context = this;
        multi_contractor_add = findViewById(R.id.multi_contractor_add);
        multi_contractor_remove = findViewById(R.id.multi_contractor_remove);
        rl_const_layout = findViewById(R.id.const_layout);
        ll = findViewById(R.id.main_linearlayout);

        multi_contractor_add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                constCreateT(v);
            }
        });


        multi_contractor_remove.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                constDeleteT(v);
            }
        });


    }

    public void constCreateT(View view) {
        const_count++;
        final LinearLayout frame = new LinearLayout(this);
        frame.setOrientation(LinearLayout.VERTICAL);
        frame.setId(const_count);

        for (int i = 0; i < 1; i++) {

            final FrameLayout frame_content = new FrameLayout(this);
            LinearLayout.LayoutParams frame_contentLp = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT, LinearLayout.LayoutParams.MATCH_PARENT);
            frame_contentLp.setMargins(24, 8, 24, 8);
            frame_content.setLayoutParams(frame_contentLp);

            final LinearLayout contractor_main_ll = new LinearLayout(this);
            LinearLayout.LayoutParams spLp = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT, LinearLayout.LayoutParams.MATCH_PARENT);
            spLp.setMargins(24, 8, 24, 50);
            contractor_main_ll.setOrientation(LinearLayout.VERTICAL);
            contractor_main_ll.setLayoutParams(spLp);

            //CardView
            CardView cardview = new CardView(this);
            cardview.setLayoutParams(new LinearLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT));
            cardview.setCardElevation(6);

            final LinearLayout contractor_card_ll = new LinearLayout(this);
            LinearLayout.LayoutParams contractor_card_sp = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT, LinearLayout.LayoutParams.MATCH_PARENT);
            contractor_card_ll.setOrientation(LinearLayout.VERTICAL);
            contractor_card_ll.setBackgroundResource(R.drawable.cv_bg_shape);
            contractor_card_ll.setLayoutParams(contractor_card_sp);


            //TextView Create
            TextView textView = new TextView(this);
            textView.setLayoutParams(new LinearLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT));
            textView.setGravity(Gravity.CENTER);
            textView.setTextColor(getResources().getColor(R.color.black));
            textView.setTextSize(20);
            textView.setText("LABOUR");


            //contractor spinner
            final Spinner contractor_spinner = new Spinner(context);
            LinearLayout.LayoutParams contractor_spinnerLp = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT, LinearLayout.LayoutParams.MATCH_PARENT);
            contractor_spinnerLp.setMargins(16, 8, 16, 8);
            contractor_spinner.setLayoutParams(contractor_spinnerLp);
            contractor_spinner.setBackgroundResource(R.drawable.cv_bg_shape);
            contractor_spinner.setPadding(16, 8, 16, 8);


            //TextView over-time
            TextView text_over_time = new TextView(this);
            LinearLayout.LayoutParams text_over_timeLp = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT, LinearLayout.LayoutParams.MATCH_PARENT);
            text_over_timeLp.setMargins(36, 16, 36, 16);
            text_over_time.setLayoutParams(text_over_timeLp);
            text_over_time.setGravity(Gravity.CENTER);
            text_over_time.setTextColor(getResources().getColor(R.color.black));
            text_over_time.setTextSize(16);
            text_over_time.setText("over-time");

            //labour Spinner
            final LinearLayout temp_ll = new LinearLayout(this);
            temp_ll.setOrientation(LinearLayout.HORIZONTAL);
            temp_ll.setWeightSum(3);

            final Spinner spinner = new Spinner(context);
            LinearLayout.LayoutParams spinnerLp = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT, LinearLayout.LayoutParams.MATCH_PARENT);
            spinnerLp.weight = 1;
            spinnerLp.setMargins(16, 8, 16, 8);
            spinner.setLayoutParams(spinnerLp);
            spinner.setBackgroundResource(R.drawable.cv_bg_shape);
            spinner.setPadding(16, 8, 16, 8);

            EditText etHrs = new EditText(context);
            LinearLayout.LayoutParams etHrslp = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT, LinearLayout.LayoutParams.MATCH_PARENT);
            etHrslp.setMargins(16, 8, 16, 8);
            etHrslp.weight = 2;
            etHrs.setLayoutParams(etHrslp);
            etHrs.setHint("HRS");
            etHrs.setGravity(Gravity.CENTER);
            etHrs.setInputType(InputType.TYPE_CLASS_DATETIME | InputType.TYPE_DATETIME_VARIATION_TIME);
            etHrs.setTextColor(Color.BLACK);
            etHrs.setPadding(8, 8, 8, 8);
            etHrs.setBackgroundResource(R.drawable.cv_bg_shape);
            etHrs.getText().toString();

           // laborSpinnerAdapter = new LaborSpinnerAdapter(this, laborModels);
          //  spinner.setAdapter(laborSpinnerAdapter);


            final LinearLayout addMoreLabour_ll = new LinearLayout(this);
            LinearLayout.LayoutParams addMoreLabour_llLp = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT, LinearLayout.LayoutParams.MATCH_PARENT);
            addMoreLabour_llLp.setMargins(90, 8, 90, 8);
            addMoreLabour_llLp.gravity = Gravity.BOTTOM;
            addMoreLabour_ll.setOrientation(LinearLayout.HORIZONTAL);
            addMoreLabour_ll.setLayoutParams(addMoreLabour_llLp);

            CardView btnAddLabourMore = new CardView(this);
            LinearLayout.LayoutParams btnAddLabourMoreLp = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.WRAP_CONTENT, LinearLayout.LayoutParams.WRAP_CONTENT);
            btnAddLabourMoreLp.setMargins(0, 0, 0, 0);
            btnAddLabourMore.setLayoutParams(btnAddLabourMoreLp);
            btnAddLabourMore.setPadding(8,8,8,8);
            btnAddLabourMore.setRadius(129);
            btnAddLabourMore.setContentPadding(8,8,8,8);
            btnAddLabourMore.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    createT(v);
                }
            });

            final LinearLayout img_labour_add_ll = new LinearLayout(this);
            LinearLayout.LayoutParams img_labour_add_llLp = new LinearLayout.LayoutParams(90, 90);
            img_labour_add_llLp.setMargins(0, 0, 0, 0);
            img_labour_add_ll.setOrientation(LinearLayout.HORIZONTAL);
            img_labour_add_ll.setLayoutParams(img_labour_add_llLp);


            ImageView imageViewLabourAdd = new ImageView(this);
            imageViewLabourAdd.setLayoutParams(new ViewGroup.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT));
            imageViewLabourAdd.setImageResource(R.drawable.ic_baseline_add_24);
            imageViewLabourAdd.setColorFilter(ContextCompat.getColor(context, R.color.black), android.graphics.PorterDuff.Mode.MULTIPLY);
            img_labour_add_ll.addView(imageViewLabourAdd);
            btnAddLabourMore.addView(img_labour_add_ll);


            CardView btnLabourDelete = new CardView(this);
            LinearLayout.LayoutParams btnLabourDeleteLp = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.WRAP_CONTENT, LinearLayout.LayoutParams.WRAP_CONTENT);
            btnLabourDeleteLp.setMargins(0, 0, 0, 0);
            btnLabourDelete.setLayoutParams(btnLabourDeleteLp);
            btnLabourDelete.setPadding(42,42,42,42);
            btnLabourDelete.setContentPadding(8,8,8,8);
            btnLabourDelete.setRadius(90);
            btnLabourDelete.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    deleteT(v);
                }
            });

            final LinearLayout img_labour_dele_ll = new LinearLayout(this);
            LinearLayout.LayoutParams img_labour_dele_llLp = new LinearLayout.LayoutParams(90, 90);
            img_labour_dele_llLp.setMargins(0, 0, 0, 0);
            img_labour_dele_ll.setOrientation(LinearLayout.HORIZONTAL);
            img_labour_dele_ll.setLayoutParams(img_labour_dele_llLp);


            ImageView LabourDeleimageView = new ImageView(this);
            LabourDeleimageView.setLayoutParams(new ViewGroup.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT));
            LabourDeleimageView.setImageResource(R.drawable.ic_baseline_delete_outline_24);
            LabourDeleimageView.setColorFilter(ContextCompat.getColor(context, R.color.black), android.graphics.PorterDuff.Mode.MULTIPLY);

            img_labour_dele_ll.addView(LabourDeleimageView);
            btnLabourDelete.addView(img_labour_dele_ll);


            addMoreLabour_ll.addView(btnAddLabourMore);
            addMoreLabour_ll.addView(btnLabourDelete);


            //TextView over-time

            final LinearLayout addMore_ll = new LinearLayout(this);
            LinearLayout.LayoutParams addMore_llLp = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT, LinearLayout.LayoutParams.MATCH_PARENT);
            addMore_llLp.setMargins(90, 8, 90, 8);
            addMore_llLp.gravity = Gravity.BOTTOM;
            addMore_ll.setGravity(Gravity.BOTTOM | Gravity.CENTER);
            addMore_ll.setOrientation(LinearLayout.HORIZONTAL);
            addMore_ll.setLayoutParams(addMore_llLp);

            CardView btnAddMore = new CardView(this);
            LinearLayout.LayoutParams tsfdfdLp = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.WRAP_CONTENT, LinearLayout.LayoutParams.WRAP_CONTENT);
            tsfdfdLp.setMargins(0, 0, 0, 0);
            btnAddMore.setLayoutParams(tsfdfdLp);
            btnAddMore.setPadding(8,8,8,8);
            btnAddMore.setRadius(129);
            btnAddMore.setContentPadding(8,8,8,8);
            btnAddMore.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    constCreateT(v);
                }
            });

            final LinearLayout img_add_ll = new LinearLayout(this);
            LinearLayout.LayoutParams img_add_llLp = new LinearLayout.LayoutParams(90, 90);
            img_add_llLp.setMargins(0, 0, 0, 0);
            img_add_ll.setOrientation(LinearLayout.HORIZONTAL);
            img_add_ll.setLayoutParams(img_add_llLp);


            ImageView imageView = new ImageView(this);
            imageView.setLayoutParams(new ViewGroup.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT));
            imageView.setImageResource(R.drawable.ic_baseline_add_24);
            imageView.setColorFilter(ContextCompat.getColor(context, R.color.black), android.graphics.PorterDuff.Mode.MULTIPLY);
            img_add_ll.addView(imageView);
            btnAddMore.addView(img_add_ll);


            CardView btnDelete = new CardView(this);
            LinearLayout.LayoutParams btnDeleteLp = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.WRAP_CONTENT, LinearLayout.LayoutParams.WRAP_CONTENT);
            btnDeleteLp.setMargins(0, 0, 0, 0);
            btnDelete.setLayoutParams(btnDeleteLp);
            btnDelete.setPadding(42,42,42,42);
            btnDelete.setContentPadding(8,8,8,8);
            btnDelete.setRadius(90);
            btnDelete.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    constDeleteT(v);
                }
            });

            final LinearLayout img_dele_ll = new LinearLayout(this);
            LinearLayout.LayoutParams img_dele_llLp = new LinearLayout.LayoutParams(90, 90);
            img_dele_llLp.setMargins(0, 0, 0, 0);
            img_dele_ll.setOrientation(LinearLayout.HORIZONTAL);
            img_dele_ll.setLayoutParams(img_dele_llLp);


            ImageView DeleimageView = new ImageView(this);
            DeleimageView.setLayoutParams(new ViewGroup.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT));
            DeleimageView.setImageResource(R.drawable.ic_baseline_delete_outline_24);
            DeleimageView.setColorFilter(ContextCompat.getColor(context, R.color.black), android.graphics.PorterDuff.Mode.MULTIPLY);

            img_dele_ll.addView(DeleimageView);
            btnDelete.addView(img_dele_ll);


            addMore_ll.addView(btnAddMore);
            addMore_ll.addView(btnDelete);

            //
            contractor_card_ll.addView(textView);
            contractor_card_ll.addView(contractor_spinner);
            contractor_card_ll.addView(text_over_time);

            temp_ll.addView(spinner);
            temp_ll.addView(etHrs);
            contractor_card_ll.addView(temp_ll);
            contractor_card_ll.addView(addMoreLabour_ll);

            cardview.addView(contractor_card_ll);

            contractor_main_ll.addView(cardview);

            frame_content.addView(contractor_main_ll);
            frame_content.addView(addMore_ll);

            frame.addView(frame_content);

           /* LayoutInflater inflater = LayoutInflater.from(this);
            view = inflater.inflate(R.layout.my_view, frame, false);*/
        }

        if (rl_const_layout != null) {
            rl_const_layout.addView(frame);
        }

       /* LayoutInflater inflater=(LayoutInflater) getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        final View rowView=inflater.inflate(R.layout.my_view, null);
        // Add the new row before the add field button.
        rl_const_layout.addView(rowView, rl_const_layout.getChildCount() - 1);*/

    }

    public void constDeleteT(View view) {
        if (const_count > 0) {
            final LinearLayout temp = rl_const_layout.findViewById(const_count);
            //   LinearLayout v = (LinearLayout) temp.getChildAt(0);
            temp.removeAllViews();
            rl_const_layout.removeView(temp);

            const_count--;
        }
    }


    public void createT(View view) {
        count++;
        final LinearLayout frame = new LinearLayout(this);
        frame.setOrientation(LinearLayout.VERTICAL);
        frame.setId(count);

        for (int i = 0; i < 1; i++) {
            final LinearLayout temp_ll = new LinearLayout(this);
            temp_ll.setOrientation(LinearLayout.HORIZONTAL);
            temp_ll.setWeightSum(3);

            final Spinner spinner = new Spinner(context);
            LinearLayout.LayoutParams spLp = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT, LinearLayout.LayoutParams.MATCH_PARENT);
            spLp.weight = 1;
            spLp.setMargins(16, 8, 16, 8);
            spinner.setLayoutParams(spLp);
            spinner.setBackgroundResource(R.drawable.cv_bg_shape);
            spinner.setPadding(16, 8, 16, 8);

            EditText etHrs = new EditText(context);
            LinearLayout.LayoutParams lp = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT, LinearLayout.LayoutParams.MATCH_PARENT);
            lp.setMargins(16, 8, 16, 8);
            lp.weight = 2;
            etHrs.setLayoutParams(lp);
            etHrs.setHint("HRS");
            etHrs.setGravity(Gravity.CENTER);
            etHrs.setInputType(InputType.TYPE_CLASS_DATETIME | InputType.TYPE_DATETIME_VARIATION_TIME);
            etHrs.setTextColor(Color.BLACK);
            etHrs.setPadding(8, 8, 8, 8);
            etHrs.setBackgroundResource(R.drawable.cv_bg_shape);
            etHrs.getText().toString();

            /*laborSpinnerAdapter = new LaborSpinnerAdapter(this, laborModels);
            spinner.setAdapter(laborSpinnerAdapter);

            final LaborModel[] lastClick = {new LaborModel()};
            final int[] lastClickedPosition = {0};
            spinner.setOnTouchListener(new View.OnTouchListener() {
                @Override
                public boolean onTouch(View v, MotionEvent event) {
                    if (event.getAction() == MotionEvent.ACTION_UP) {
                        //Your code

                        lastClick[0] = (LaborModel) spinner.getSelectedItem();
                        lastClickedPosition[0] = spinner.getSelectedItemPosition();
                    }

                    return false;
                }
            });

            spinner.setOnItemSelectedListener(
                    new AdapterView.OnItemSelectedListener() {
                        @Override
                        public void onItemSelected(AdapterView<?> parent,
                                                   View view, int position, long id) {
                            LaborModel clickedItem = (LaborModel)
                                    parent.getItemAtPosition(position);


                            if (clickedItem.isSelected()) {
                                Toast.makeText(CreateNewProgressEntryActivity.this, "this item is already Selected", Toast.LENGTH_SHORT).show();
                                parent.setSelection(lastClickedPosition[0]);
                            }

                            if (position > 0) {
                                contractor_labour_linking_id = clickedItem.getContractor_labour_linking_id();
                                //   labourName.add(0, clickedItem.getName());

                                for (int i = 0; i < laborModels.size(); i++) {
                                    if (laborModels.get(i).getContractor_labour_linking_id() == lastClick[0].getContractor_labour_linking_id()) {
                                        laborModels.get(i).setSelected(false);
                                        clickedItem.setTime("");
                                    }
                                    if (contractor_labour_linking_id == laborModels.get(i).getContractor_labour_linking_id()) {

                                        *//*if (etHrs.getText().toString().trim().isEmpty()) {
                                            Toast.makeText(CreateNewProgressEntryActivity.this, "Hours cannot be ", Toast.LENGTH_SHORT).show();
                                            parent.setSelection(lastClickedPosition[0]);
                                        } else {
                                            clickedItem.setTime(etHrs.getText().toString());
                                            clickedItem.setSelected(true);
                                        }*//*
                                        clickedItem.setTime(etHrs.getText().toString());
                                        clickedItem.setSelected(true);
                                    }

                                }

                            }
                        }

                        @Override
                        public void onNothingSelected(AdapterView<?> parent) {
                        }
                    });*/


            temp_ll.addView(spinner);
            temp_ll.addView(etHrs);
            frame.addView(temp_ll);
        }
        ll_labour.addView(frame);

    }

    public void deleteT(View view) {
        if (count > 0) {
            final LinearLayout temp = ll.findViewById(count);
            LinearLayout v = (LinearLayout) temp.getChildAt(0);
            Spinner toBeDeletedSpinner = (Spinner) v.getChildAt(0);
           /* if (toBeDeletedSpinner instanceof Spinner) {
                LaborModel selectedItem = (LaborModel) toBeDeletedSpinner.getSelectedItem();
                for (int i = 0; i < laborModels.size(); i++) {
                    if (laborModels.get(i).getContractor_labour_linking_id() == selectedItem.getContractor_labour_linking_id()) {
                        laborModels.get(i).setSelected(false);
                        laborModels.get(i).setTime("");
                    }
                }
            }*/


            temp.removeAllViews();
            ll_labour.removeView(temp);


            count--;
        }
    }



}