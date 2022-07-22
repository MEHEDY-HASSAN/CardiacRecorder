package com.example.cardiacmonitor;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        loginActivityIntent();
    }

    private void loginActivityIntent() {
        Intent loginIntenet = new Intent(this,LoginActivity.class);
        this.startActivity(loginIntenet);
    }
}