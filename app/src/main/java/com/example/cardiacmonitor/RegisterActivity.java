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
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class RegisterActivity extends AppCompatActivity {

    public TextView emailAddress, password;
    public Button registerButton;
    private FirebaseAuth mAuth;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        initialization();
        registerButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String emailString = emailAddress.getText().toString().trim();
                String passwordString =password.getText().toString().trim();

                mAuth.createUserWithEmailAndPassword(emailString,passwordString).addOnSuccessListener(new OnSuccessListener<AuthResult>() {
                    @Override
                    public void onSuccess(AuthResult authResult) {
                        Toast.makeText(RegisterActivity.this, "registration Successfully", Toast.LENGTH_SHORT).show();
                        mainActivityIntent();
                    }
                }).addOnFailureListener(new OnFailureListener() {
                    @Override
                    public void onFailure(@NonNull Exception e) {
                        Toast.makeText(RegisterActivity.this, "failed", Toast.LENGTH_SHORT).show();
                    }
                });
            }
        });
    }

    private void mainActivityIntent() {
        Intent mainIntent = new Intent(this,MainActivity.class);
        this.startActivity(mainIntent);
    }

    private void initialization() {
        mAuth = FirebaseAuth.getInstance();
        emailAddress = (TextView) findViewById(R.id.register_email_view);
        password = (TextView) findViewById(R.id.register_password_view);
        registerButton = (Button) findViewById(R.id.register_registerButton);
    }

}