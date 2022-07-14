package com.example.registration;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Patterns;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class RegisterActivity extends AppCompatActivity {
    Button backBtn;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        backBtn=findViewById(R.id.btnRegister);

        TextView btn=findViewById(R.id.alreadyHaveAccount);

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(RegisterActivity.this,LoginActivity.class));
            }
        });

        backBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                backLogin();
            }
        });
    }

    void backLogin() {
        EditText editText1 = (EditText) findViewById(R.id.inputUsername);
        String username = editText1.getText().toString();
        EditText editText2 = (EditText) findViewById(R.id.inputEmail);
        String email = editText2.getText().toString();
        EditText editText3 = (EditText) findViewById(R.id.inputPassword);
        String password = editText3.getText().toString();
        EditText editText4 = (EditText) findViewById(R.id.inputConformPassword);
        String conformPassword = editText4.getText().toString();

        Users user = new Users(email, username,password);


        if (username.isEmpty()||email.isEmpty()||password.isEmpty()||conformPassword.isEmpty())
            Toast.makeText(RegisterActivity.this,getString(R.string.please_fill_in_all_fields) ,Toast.LENGTH_SHORT).show();
        else if ((password.compareTo(conformPassword))!=0)
            Toast.makeText(RegisterActivity.this, getString(R.string.password_mismatch),Toast.LENGTH_SHORT).show();
        else if(!Patterns.EMAIL_ADDRESS.matcher(email).matches()){
            Toast.makeText(RegisterActivity.this, getString(R.string.Invalid_mail), Toast.LENGTH_SHORT).show();
        }
        else {

            DataBase user1 = new DataBase(this);
            boolean success= user1.addOne(user);

            Toast.makeText(RegisterActivity.this, getString(R.string.account_created), Toast.LENGTH_SHORT).show();

            finish();
            startActivity(new Intent(RegisterActivity.this, LoginActivity.class));
        }

    }

  /*  public void displayToast(View v){
        EditText editText1 = (EditText) findViewById(R.id.inputUsername);
        String username = editText1.getText().toString();
        EditText editText2 = (EditText) findViewById(R.id.inputEmail);
        String email = editText2.getText().toString();
        EditText editText3 = (EditText) findViewById(R.id.inputPassword);
        String password = editText3.getText().toString();
        EditText editText4 = (EditText) findViewById(R.id.inputConformPassword);
        String conformPassword = editText4.getText().toString();

        if (username.isEmpty()||email.isEmpty()||password.isEmpty()||conformPassword.isEmpty())
        Toast.makeText(RegisterActivity.this, "Please fill in all fields",Toast.LENGTH_SHORT).show();
        else if ((password.compareTo(conformPassword))!=0)
            Toast.makeText(RegisterActivity.this, "Please fix the password",Toast.LENGTH_SHORT).show();
        else
         Toast.makeText(RegisterActivity.this, "Account Created!!",Toast.LENGTH_SHORT).show();

    }

   */
}
