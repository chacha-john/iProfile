package com.chachaup.iprofile.ui;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.util.Patterns;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.chachaup.iprofile.R;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.android.material.textfield.TextInputLayout;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.auth.UserProfileChangeRequest;

import java.util.Objects;

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

        boolean validEmail = isValidEmail(email);
        boolean validName = isValidName(name);
        boolean validPassword = isValidPassword(password,repeatPassword);
        if (!validEmail || !validName || !validPassword) return;

        mAuth.createUserWithEmailAndPassword(email, password)
                .addOnCompleteListener(this, task -> {
                    if (task.isSuccessful()){
                        createUserProfile(Objects.requireNonNull(task.getResult().getUser()));
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

    //validating inputs
    private boolean isValidEmail(String aEmail){
        if (aEmail == null || !Patterns.EMAIL_ADDRESS.matcher(aEmail).matches()){
            mEmailCA.setError("Please enter a valid email address");
            return false;

        }
        return true;
    }

    private boolean isValidName(String aName){
        if (aName.equals("")){
            mUsernameCA.setError("Username cannot be blank");
            return false;
        }
        return true;
    }

    private boolean isValidPassword(String aPassword, String aRPassword){
        if (!aPassword.equals(aRPassword)){
            mPassCA.setError("Passwords do not match!");
            mRepeatPassCA.setError("Passwords do not match!");
            return false;
        }
        if (aPassword.length()<6 || aRPassword.length()<6){
            mPassCA.setError("Your password should contain at least six characters");
            mRepeatPassCA.setError("Your password should contain at least six characters");
            return false;
        }
        return true;
    }

    private void createUserProfile(final FirebaseUser user){
        UserProfileChangeRequest request = new UserProfileChangeRequest.Builder()
                .setDisplayName(mUsernameCA.toString())
                .build();
        user.updateProfile(request)
                .addOnCompleteListener(new OnCompleteListener<Void>() {
                    @Override
                    public void onComplete(@NonNull Task<Void> task) {
                        if (task.isSuccessful()){
                            Log.d("user",user.getDisplayName());
                        }
                    }
                });
    }
}