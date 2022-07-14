package com.example.registration;


import  androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.os.PatternMatcher;
import android.util.Patterns;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;



import com.google.android.gms.auth.api.signin.GoogleSignIn;
import com.google.android.gms.auth.api.signin.GoogleSignInAccount;
import com.google.android.gms.auth.api.signin.GoogleSignInClient;
import com.google.android.gms.auth.api.signin.GoogleSignInOptions;
import com.google.android.gms.common.api.ApiException;
import com.google.android.gms.tasks.Task;

public class LoginActivity extends AppCompatActivity {
    GoogleSignInOptions gso;
    GoogleSignInClient gsc;
    ImageView googleBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        TextView btn=findViewById(R.id.textViewSignUp);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(LoginActivity.this,RegisterActivity.class));
            }
        });

        googleBtn=findViewById(R.id.google_btn);
        gso= new GoogleSignInOptions.Builder(GoogleSignInOptions.DEFAULT_SIGN_IN).requestEmail().build();
        gsc= GoogleSignIn.getClient(this,gso);

        googleBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                signIn();
            }
        });


        }

        void signIn(){
        Intent signInIntent = gsc.getSignInIntent();
        startActivityForResult(signInIntent,1000);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode,Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode==1000){
            Task<GoogleSignInAccount> task=GoogleSignIn.getSignedInAccountFromIntent(data);

            try {
                task.getResult(ApiException.class);
                navigateToSecondActivity();
            } catch (ApiException e) {
                Toast.makeText(getApplicationContext(), getString(R.string.somthing_went_wrong), Toast.LENGTH_SHORT).show();
            }

        }
    }

    void navigateToSecondActivity (){
        finish();
        Intent intent= new Intent(LoginActivity.this, SecondActivity.class);
        startActivity(intent);
    }
    public void displayToast(View v){
        EditText editText1 = (EditText) findViewById(R.id.inputUsername);
        String mail = editText1.getText().toString();
        EditText editText2 = (EditText) findViewById(R.id.inputPassword);
        String password = editText2.getText().toString();


        if (password.isEmpty()||mail.isEmpty())
            Toast.makeText(LoginActivity.this,getString(R.string.please_fill_in_all_fields), Toast.LENGTH_SHORT).show();

        else if (!Patterns.EMAIL_ADDRESS.matcher(mail).matches()){
            Toast.makeText(LoginActivity.this,getString(R.string.Dont_have_account), Toast.LENGTH_SHORT).show();
        }
            else
            Toast.makeText(LoginActivity.this, getString(R.string.wellcome_to_the_app), Toast.LENGTH_SHORT).show();

    }
}
