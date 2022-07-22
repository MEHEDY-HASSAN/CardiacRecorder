package com.example.cardiacmonitor;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.google.firebase.auth.FirebaseAuth;

public class HomeAcitivity extends AppCompatActivity {

    public Button logout;
    private FirebaseAuth mAuth;
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
    }

    private void initialization() {
        mAuth = FirebaseAuth.getInstance();
        logout = (Button) findViewById(R.id.home_logOut);
    }
    private void mainActivityIntent() {
        Intent mainIntent = new Intent(this,MainActivity.class);
        this.startActivity(mainIntent);
    }
}