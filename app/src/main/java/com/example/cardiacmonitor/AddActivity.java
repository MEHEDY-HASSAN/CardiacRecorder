package com.example.cardiacmonitor;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class AddActivity extends AppCompatActivity {

    public TextView Systolic_pressure,Diastolic_pressure,Heart_rate,Measure_time,Measure_date,Comment;
    public Button Add_button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Initialization();
        setContentView(R.layout.activity_add);
        Add_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String systolic_pressureString = Systolic_pressure.getText().toString().trim();
                String Diastolic_pressureString = Diastolic_pressure.getText().toString().trim();
                String Heart_rateString = Heart_rate.getText().toString().trim();
                String Measure_timeString = Measure_time.getText().toString().trim();
                String Measure_dateString = Measure_date.getText().toString().trim();
                String CommentString = Comment.getText().toString().trim();

                Integer Systolic_pressureNumber = Integer.parseInt(systolic_pressureString);
                Integer Diastolic_pressureNumber = Integer.parseInt(Diastolic_pressureString);
                Integer Heart_rateNumber = Integer.parseInt(Heart_rateString);
            }
        });
    }

    private void Initialization() {
        Systolic_pressure = (TextView) findViewById(R.id.Add_Enter_Systolic_pressure);
        Diastolic_pressure = (TextView) findViewById(R.id.Add_Enter_Diastolic_pressure);
        Heart_rate = (TextView) findViewById(R.id.Add_Enter_Heart_Rate);
        Measure_time = (TextView) findViewById(R.id.ADD_Enter_Measure_Time);
        Measure_date = (TextView) findViewById(R.id.ADD_Enter_Measure_Date);
        Comment = (TextView) findViewById(R.id.ADD_Enter_Comment);

        Add_button = (Button) findViewById(R.id.ADD_ADDButton);
    }
}