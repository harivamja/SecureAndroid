package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class MainActivity extends AppCompatActivity {

    FirebaseDatabase firebaseDatabase ;
    DatabaseReference databaseReference ;
    EditText mTextUsername;
    EditText mTextPassword;
    Button mButtonLogin;
    TextView mTextViewRegister;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mTextUsername = (EditText)findViewById(R.id.edittext_username);
        mTextPassword = (EditText)findViewById(R.id.edittext_password);
        mButtonLogin = (Button)findViewById(R.id.button);
        mTextViewRegister = (TextView)findViewById(R.id.textview_register);

        mTextViewRegister.setOnClickListener(new View.OnClickListener(){
                                                  public void onClick(View view) {
                                                      Intent registerIntent = new Intent(MainActivity.this,RegisterActivity.class);
                                                      startActivity(registerIntent);
                                                  }
                                              });






    }
}
