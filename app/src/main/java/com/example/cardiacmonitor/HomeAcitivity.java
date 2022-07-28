package com.example.cardiacmonitor;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.icu.text.Collator;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;

public class HomeAcitivity extends AppCompatActivity {

    RecyclerView recyclerView;
    DatabaseReference database;
    MyAdapter myAdapter;
    ArrayList<Record> list;
    ArrayList<String> keys = new ArrayList<>();

    public FloatingActionButton logout;
    private FirebaseAuth mAuth;
    FloatingActionButton homeRecordAddButton ;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home_acitivity);

        initialization();

        logout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mAuth.signOut();
                mainActivityIntent();
            }
        });
        homeRecordAddButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                AddRecordIntent();
            }
        });
    }

    private void AddRecordIntent() {
        Intent intent = new Intent(this,AddActivity.class);
        this.startActivity(intent);
    }

    private void initialization() {
        homeRecordAddButton = (FloatingActionButton) findViewById(R.id.home_add_record);
        mAuth = FirebaseAuth.getInstance();
        logout = (FloatingActionButton) findViewById(R.id.home_logOut);
        recyclerView = (RecyclerView) findViewById(R.id.record_recycler_view);
        String userId = mAuth.getUid().toString();
        database = FirebaseDatabase.getInstance().getReference("Record").child(userId);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        list = new ArrayList<>();
        myAdapter = new MyAdapter(this,list,keys);
        recyclerView.setAdapter(myAdapter);

        database.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                for (DataSnapshot dataSnapshot : snapshot.getChildren()){
                    Record record = dataSnapshot.getValue(Record.class);
                    list.add(record);
                    keys.add(dataSnapshot.getKey().toString());
                    //Toast.makeText(HomeAcitivity.this, "Value added", Toast.LENGTH_SHORT).show();
                }
                myAdapter.notifyDataSetChanged();
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });

    }
    private void mainActivityIntent() {
        Intent mainIntent = new Intent(this,MainActivity.class);
        this.startActivity(mainIntent);
    }
}