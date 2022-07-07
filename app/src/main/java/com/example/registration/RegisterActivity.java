package com.example.registration;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class RegisterActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        TextView btn=findViewById(R.id.alreadyHaveAccount);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(RegisterActivity.this,LoginActivity.class));
            }
        });
    }

    public void displayToast(View v){
        EditText editText1 = (EditText) findViewById(R.id.inputUsername);
        String username = editText1.getText().toString();
        EditText editText2 = (EditText) findViewById(R.id.inputEmail);
        String email = editText2.getText().toString();
        EditText editText3 = (EditText) findViewById(R.id.inputPassword);
        String password = editText2.getText().toString();
        EditText editText4 = (EditText) findViewById(R.id.inputConformPassword);
        String conformPassword = editText2.getText().toString();


        if (username.isEmpty()||email.isEmpty()||password.isEmpty()||conformPassword.isEmpty())
        Toast.makeText(RegisterActivity.this, "Please fill in all fields",Toast.LENGTH_SHORT).show();
           else
         Toast.makeText(RegisterActivity.this, "Account Created!!",Toast.LENGTH_SHORT).show();

    }
}
