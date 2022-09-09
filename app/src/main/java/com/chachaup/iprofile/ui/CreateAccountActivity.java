package com.chachaup.iprofile.ui;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.chachaup.iprofile.R;
import com.google.android.material.textfield.TextInputLayout;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

import butterknife.BindView;
import butterknife.ButterKnife;

public class CreateAccountActivity extends AppCompatActivity implements View.OnClickListener {
    @BindView(R.id.editTextEmailCreateAccount)
    EditText mEmailCA;
    @BindView(R.id.editTextPasswordCreateAccount) EditText mPassCA;
    @BindView(R.id.editTextUsernameCreateAccount)
    EditText mUsernameCA;
    @BindView(R.id.editTextRepeatPasswordCreateAccount) EditText mRepeatPassCA;
    @BindView(R.id.buttonCreateAccount)
    Button mCreateAccountButton;
    @BindView(R.id.textViewLoginLink)
    TextView mLoginLink;

    private FirebaseAuth mAuth;
    private FirebaseAuth.AuthStateListener mAuthListener;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_account);
        ButterKnife.bind(this);

        mCreateAccountButton.setOnClickListener(this);
        mLoginLink.setOnClickListener(this);

        mAuth = FirebaseAuth.getInstance();
        CreateAuthStateListener();
    }

    @Override
    public void onClick(View v) {
        if (v == mCreateAccountButton){
            CreateNewUser();
        }
        if (v == mLoginLink){
            Intent intent = new Intent(CreateAccountActivity.this, LoginActivity.class);
            intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
            startActivity(intent);
        }

    }

    private void CreateNewUser(){
        final String name = mUsernameCA.getText().toString().trim();
        final String email = mEmailCA.getText().toString().trim();
        final String password = mPassCA.getText().toString().trim();
        final String repeatPassword = mRepeatPassCA.getText().toString().trim();

        mAuth.createUserWithEmailAndPassword(email, password)
                .addOnCompleteListener(this, task -> {
                    if (task.isSuccessful()){
                        Toast.makeText(getApplicationContext(),"Account created successfully",Toast.LENGTH_SHORT).show();
                    }
                    else{

                        Toast.makeText(getApplicationContext(),"You ran into a problem", Toast.LENGTH_SHORT).show();
                    }
                });
    }

    private void CreateAuthStateListener(){
        mAuthListener = new FirebaseAuth.AuthStateListener() {
            @Override
            public void onAuthStateChanged(@NonNull FirebaseAuth firebaseAuth) {
                final FirebaseUser user = firebaseAuth.getCurrentUser();
                if (user != null){
                    Intent intent = new Intent(CreateAccountActivity.this, RandomProfileActivity.class);
                    intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
                    startActivity(intent);
                    finish();
                }
            }
        };

    }

    @Override
    protected void onStart() {
        super.onStart();
        mAuth.addAuthStateListener(mAuthListener);
    }

    @Override
    protected void onStop() {
        super.onStop();
        if (mAuthListener != null){
            mAuth.removeAuthStateListener(mAuthListener);
        }
    }
}