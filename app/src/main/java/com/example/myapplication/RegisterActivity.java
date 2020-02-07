package com.example.myapplication;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.firebase.ui.database.FirebaseRecyclerOptions;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class RegisterActivity  extends AppCompatActivity {

    EditText mTextUsername;
    EditText mTextPassword;
    EditText getTextCnfPassword;
    Button mButtonRegister;
    TextView mTextViewLogin;
    FirebaseDatabase firebaseDatabase ;
    DatabaseReference databaseReference ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        mTextUsername = (EditText)findViewById(R.id.edittext_username);
        mTextPassword = (EditText)findViewById(R.id.edittext_password);
        getTextCnfPassword = (EditText)findViewById(R.id.edittext_cnf_password);
        mButtonRegister = (Button)findViewById(R.id.button);
        mTextViewLogin = (TextView)findViewById(R.id.textview_login);
        firebaseDatabase  = FirebaseDatabase.getInstance();
        databaseReference = firebaseDatabase.getReference("MainActivity");



        mTextViewLogin.setOnClickListener(new View.OnClickListener(){
            public void onClick(View view){

                Intent LoginIntent;
                LoginIntent = new Intent(RegisterActivity.this, MainActivity.class);
                startActivity(LoginIntent);


            }


        });


        mButtonRegister.setOnClickListener(new View.OnClickListener(){
            public void onClick(View view){
                Input_user();


            }


        });
        DisplayData();
    }


    private void Input_user()
    {


        String Username =  mTextUsername.getText().toString();
        String Password =  mTextPassword.getText().toString();
        String cnf_Password = getTextCnfPassword.getText().toString();

        Post post = new Post(Username,Password, cnf_Password);
        databaseReference.push().setValue(post);
        Toast.makeText(RegisterActivity.this,"Connected",Toast.LENGTH_LONG).show();

    }

    private void DisplayData() {
        FirebaseRecyclerOptions<Post> options = new FirebaseRecyclerOptions.Builder<Post>().setQuery(databaseReference,Post.class).build();



    }
}
