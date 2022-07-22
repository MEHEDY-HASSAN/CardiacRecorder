package com.example.cardiacmonitor;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class LoginActivity extends AppCompatActivity {

    public TextView emailAddress, password;
    public Button loginButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        initialization();

        loginButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(LoginActivity.this, emailAddress.getText(), Toast.LENGTH_SHORT).show();
            }
        });
    }

    private void initialization() {
        emailAddress = (TextView) findViewById(R.id.login_email_view);
        password = (TextView) findViewById(R.id.login_password_view);
        loginButton = (Button) findViewById(R.id.login_loginButton);
    }
}