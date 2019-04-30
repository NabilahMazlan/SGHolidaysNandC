package com.example.sgholidays;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class SecondActivity extends AppCompatActivity {

    ListView lv;
    TextView tvCategory;
    Button btnBack;
    ArrayAdapter aa;
    ArrayList<Holiday> holiday;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        holiday = new ArrayList<Holiday>();
        btnBack = (Button)findViewById(R.id.btnBack);
        lv = (ListView) this.findViewById(R.id.lvHolidays);
        tvCategory = (TextView) findViewById(R.id.tvCategory);

        Intent i = getIntent();
        String category = i.getStringExtra("category");

        tvCategory.setText(category);

        if (category.equalsIgnoreCase("Secular")) {
            holiday.add(new Holiday("New Year's Day", "1 January 2018"));
            holiday.add(new Holiday("Good Friday", "30 March 2018"));
            holiday.add(new Holiday("Labour Day", "1 May 2018"));
            holiday.add(new Holiday("National Day", "9 August 2018"));

        } else if (category.equalsIgnoreCase("Ethnics and Religion")){
            holiday.add(new Holiday("Chinese New Year", "16-17 February 2018"));
            holiday.add(new Holiday("Vesak day", "29 May 2018"));
            holiday.add(new Holiday("Hari Raya Puasa", "15 June 2018"));
            holiday.add(new Holiday("Hari Raya Haji", "22 August 2018"));
            holiday.add(new Holiday("Deepavali", "6 November 2018"));
            holiday.add(new Holiday("Christmas Day", "25 December 2018"));
        }

        aa = new HolidayAdapter(this, R.layout.row, holiday);
        lv.setAdapter(aa);

        lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Holiday selectedHoliday = holiday.get(position);
                Toast.makeText(SecondActivity.this, selectedHoliday.getName()
                                + " Date: " + selectedHoliday.getDate(),
                        Toast.LENGTH_LONG).show();
            }
        });

        btnBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }

}
