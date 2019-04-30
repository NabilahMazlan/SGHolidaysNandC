package com.example.sgholidays;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    ListView lv;
    ArrayList<String> alHolidays;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        lv = findViewById(R.id.lvSelect);
        alHolidays = new ArrayList<String>();
        typesOfHolidays();

        ArrayAdapter<String> aaAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, alHolidays);
        lv.setAdapter(aaAdapter);

        lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                String name = adapterView.getItemAtPosition(i).toString();
                int pos = adapterView.getPositionForView(view);
                Intent intent = new Intent(MainActivity.this, ViewHolidays.class);
                intent.putExtra("name", name);
                intent.putExtra("pos", pos);
                startActivity(intent);
            }
        });
    }

    void typesOfHolidays(){
        alHolidays.add("Secular");
        alHolidays.add("Ethnic & Religion");

    }
}
