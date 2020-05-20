package com.standard.varkari;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class RegisterActivity extends AppCompatActivity {

    EditText editTextname, editTextmobile, editTextemail, editTextpassword;
    Button btn_register;
    TextView text_login;


    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        editTextmobile=(EditText)findViewById(R.id.EditText_mobile);
        editTextemail=(EditText)findViewById(R.id.EditText_email);
        editTextname=(EditText)findViewById(R.id.EditText_name);
        editTextpassword=(EditText)findViewById(R.id.EditText_pass);
        btn_register=(Button)findViewById(R.id.ButtonRegister);
        text_login=(TextView)findViewById(R.id.Text_login);

        btn_register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(RegisterActivity.this, LoginActivity.class);
                startActivity(intent);
            }
        });

        text_login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(RegisterActivity.this, LoginActivity.class);
                startActivity(intent);
            }
        });
    }
}
