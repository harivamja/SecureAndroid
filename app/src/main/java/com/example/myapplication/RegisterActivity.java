package com.example.myapplication;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.example.myapplication.com.example.myapplication.user.UserAuthentication;
import com.firebase.ui.database.FirebaseRecyclerOptions;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.RuntimeExecutionException;
import com.google.android.gms.tasks.Task;
import com.google.firebase.FirebaseException;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseAuthInvalidCredentialsException;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class RegisterActivity  extends AppCompatActivity {

    EditText mTextUsername;
    EditText mTextPassword;
    EditText mTextCnfPassword;
    Button mButtonRegister;
    TextView mTextViewLogin;

    FirebaseAuth mAuth ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        mTextUsername = (EditText)findViewById(R.id.edittext_username);
        mTextPassword = (EditText)findViewById(R.id.edittext_password);
        mTextCnfPassword = (EditText)findViewById(R.id.edittext_cnf_password);
        mButtonRegister = (Button)findViewById(R.id.button);
        mTextViewLogin = (TextView)findViewById(R.id.textview_login);

        mAuth  = FirebaseAuth.getInstance();

        mTextViewLogin.setOnClickListener(new View.OnClickListener(){
            public void onClick(View view){
                Intent LoginIntent;
                LoginIntent = new Intent(RegisterActivity.this, MainActivity.class);
                startActivity(LoginIntent);
            }


        });

        mButtonRegister.setOnClickListener(new View.OnClickListener(){
            public void onClick(View view){

                String userName =  mTextUsername.getText().toString();
                String password =  mTextPassword.getText().toString();
                String cnfPassword = mTextCnfPassword.getText().toString();

                if(validatePassword(password, cnfPassword)){
                    createUser(userName, password);
                } else {
                    Toast.makeText(RegisterActivity.this, "Password didn't match", Toast.LENGTH_LONG).show();
                }

            }
        });
        DisplayData();
    }

    private boolean validatePassword(String password, String cnfPassword) {
        return password.equals(cnfPassword);
    }


    private void createUser(String email, String password) {

        mAuth.createUserWithEmailAndPassword(email, password)
                .addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if (task.isSuccessful()) {
                            // Sign in success, update UI with the signed-in user's information
                            FirebaseUser user = mAuth.getCurrentUser();
                            Toast.makeText(RegisterActivity.this,"Successfully",Toast.LENGTH_LONG).show();

                        } else {
                            FirebaseException exception = (FirebaseException) task.getException();
                            Toast.makeText(RegisterActivity.this, exception.getMessage(), Toast.LENGTH_SHORT).show();

                        }
                    }
                });

    }

    private void DisplayData() {}
}
