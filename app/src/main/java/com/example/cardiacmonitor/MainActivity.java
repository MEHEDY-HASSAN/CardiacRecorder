package com.example.cardiacmonitor;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.widget.Toast;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class MainActivity extends AppCompatActivity {

    private FirebaseAuth mAuth;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mAuth = FirebaseAuth.getInstance();
        FirebaseUser currentUser = mAuth.getCurrentUser();

        final Handler handler = new Handler(Looper.getMainLooper());
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                if (currentUser!=null){
                    //homeActivityIntent();
                    addActivityIntent();
                }
                else
                    loginActivityIntent();
            }
        }, 200);


    }

    private void addActivityIntent() {
        Intent addIntent = new Intent(this,AddActivity.class);
        this.startActivity(addIntent);
    }


    private void homeActivityIntent() {
        Intent homeIntent = new Intent(this,HomeAcitivity.class);
        this.startActivity(homeIntent);
    }

    private void loginActivityIntent() {
        Intent loginIntenet = new Intent(this,LoginActivity.class);
        this.startActivity(loginIntenet);
    }

}