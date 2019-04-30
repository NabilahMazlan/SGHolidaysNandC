package com.example.sgholidays;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

public class HolidayAdapter extends ArrayAdapter<Holiday> {

    private ArrayList<Holiday> holiday;
    private Context context;
    private TextView tvHoliday;
    private TextView tvDate;
    private ImageView ivHoliday;


    public HolidayAdapter(Context context, int resource, ArrayList<Holiday> objects) {
        super(context, resource, objects);
        holiday = objects;
        this.context = context;
    }

    public View getView(int position, View convertView, ViewGroup parent){
        LayoutInflater inflater = (LayoutInflater) context
                .getSystemService(Context.LAYOUT_INFLATER_SERVICE);

        View rowView = inflater.inflate(R.layout.row, parent, false);

        tvHoliday = (TextView) rowView.findViewById(R.id.tvHoliday);
        tvDate = (TextView) rowView.findViewById(R.id.tvDate);
        ivHoliday = (ImageView) rowView.findViewById(R.id.ivHoliday);

        // Holiday
        Holiday currentHoliday = holiday.get(position);
        tvHoliday.setText(currentHoliday.getName());

        //Image
        if (currentHoliday.getName() == "New Year's Day"){
            ivHoliday.setImageResource(R.drawable.newyear);
        } else if (currentHoliday.getName() == "Christmas") {
            ivHoliday.setImageResource(R.drawable.christmas);
        } else if (currentHoliday.getName() == "Labour Day") {
            ivHoliday.setImageResource(R.drawable.labourday);
        } else if (currentHoliday.getName() == "Chinese New Year") {
            ivHoliday.setImageResource(R.drawable.cny);
        } else if (currentHoliday.getName() == "Deepavali"){
            ivHoliday.setImageResource(R.drawable.deepavali);
        } else if (currentHoliday.getName() == "Good Friday"){
            ivHoliday.setImageResource(R.drawable.goodfriday);
        } else if (currentHoliday.getName() == "Hari Raya Haji"){
            ivHoliday.setImageResource(R.drawable.harirayahaji);
        } else if (currentHoliday.getName() == "Hari Raya Puasa"){
            ivHoliday.setImageResource(R.drawable.harirayapuasa);
        } else if (currentHoliday.getName() == "National Day"){
            ivHoliday.setImageResource(R.drawable.nationalday);
        }


        tvDate.setText(currentHoliday.getDate());
        return rowView;
    }
}
