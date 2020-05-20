package com.standard.varkari;


import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class LoginActivity extends AppCompatActivity {

    EditText text_login, text_password;
    TextView text_forgot, text_signup;
    Button btn_login;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        text_login=(EditText)findViewById(R.id.editTextEmail);
        text_password=(EditText)findViewById(R.id.editTextPassword);
        text_forgot=(TextView)findViewById(R.id.TextviewForgot);
        text_signup=(TextView)findViewById(R.id.TextSignup);
        btn_login=(Button)findViewById(R.id.cirLoginButton);

        btn_login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(LoginActivity.this, DashboardActivity.class);
                startActivity(intent);
            }
        });

        text_signup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(LoginActivity.this, RegisterActivity.class);
                startActivity(intent);
            }
        });
    }
}
