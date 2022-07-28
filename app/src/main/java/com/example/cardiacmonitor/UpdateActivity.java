package com.example.cardiacmonitor;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class UpdateActivity extends AppCompatActivity {

    public TextView Systolic_pressure,Diastolic_pressure,Heart_rate,Measure_time,Measure_date,Comment;
    public Button Update_button , Delete_button;

    DatabaseReference database;
    FirebaseAuth mAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_update);


        String key = getIntent().getStringExtra("key");

        Initialization();
        InitializationValues(key);
        Update_button.setOnClickListener(new View.OnClickListener() {
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

                Record record = new Record(Measure_dateString,Measure_timeString,Systolic_pressureNumber,Diastolic_pressureNumber,Heart_rateNumber,CommentString);
                database.child(key).setValue(record).addOnSuccessListener(new OnSuccessListener<Void>() {
                    @Override
                    public void onSuccess(Void unused) {
                        Toast.makeText(UpdateActivity.this, "Update Successful", Toast.LENGTH_SHORT).show();
                        Intent HomeIntent = new Intent(UpdateActivity.this,HomeAcitivity.class);
                        UpdateActivity.this.startActivity(HomeIntent);
                    }
                }).addOnFailureListener(new OnFailureListener() {
                    @Override
                    public void onFailure(@NonNull Exception e) {
                        Toast.makeText(UpdateActivity.this, "Failed", Toast.LENGTH_SHORT).show();
                    }
                });
            }
        });

        Delete_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                database.child(key).removeValue().addOnFailureListener(new OnFailureListener() {
                    @Override
                    public void onFailure(@NonNull Exception e) {
                        Toast.makeText(UpdateActivity.this, "Failed", Toast.LENGTH_SHORT).show();
                    }
                }).addOnSuccessListener(new OnSuccessListener<Void>() {
                    @Override
                    public void onSuccess(Void unused) {
                        Toast.makeText(UpdateActivity.this, "Update Successful", Toast.LENGTH_SHORT).show();
                        Intent HomeIntent = new Intent(UpdateActivity.this,HomeAcitivity.class);
                        UpdateActivity.this.startActivity(HomeIntent);
                    }
                });
            }
        });
    }

    private void InitializationValues(String key) {
        database.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                for (DataSnapshot dataSnapshot: snapshot.getChildren()){
                    if (dataSnapshot.getKey().toString().compareTo(key)==0){
                        Record record = dataSnapshot.getValue(Record.class);
                        Systolic_pressure.setText(String.valueOf(record.getSystolicPressure()));
                        Diastolic_pressure.setText(String.valueOf(record.getDiastolicPressure()));
                        Heart_rate.setText(String.valueOf(record.getHeartRate()));
                        Comment.setText(record.getComment());
                        Measure_time.setText(record.getTimeMeasured());
                        Measure_date.setText(record.getDataMeasured());
                    }
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });
    }

    private void Initialization() {
        mAuth = FirebaseAuth.getInstance();
        String userId = mAuth.getUid().toString();
        database = FirebaseDatabase.getInstance().getReference().child("Record").child(userId);
        Systolic_pressure = (TextView) findViewById(R.id.Update_Enter_Systolic_pressure);
        Diastolic_pressure = (TextView) findViewById(R.id.Update_Enter_Diastolic_pressure);
        Heart_rate = (TextView) findViewById(R.id.Update_Enter_Heart_Rate);
        Measure_time = (TextView) findViewById(R.id.Update_Enter_Measure_Time);
        Measure_date = (TextView) findViewById(R.id.Update_Enter_Measure_Date);
        Comment = (TextView) findViewById(R.id.Update_Enter_Comment);

        Update_button = (Button) findViewById(R.id.Update_UpdateButton);
        Delete_button = (Button) findViewById(R.id.Update_DeleteButton);

    }
}