package com.chachaup.iprofile.ui;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.chachaup.iprofile.R;
import com.google.android.material.textfield.TextInputLayout;

import butterknife.BindView;
import butterknife.ButterKnife;

public class LoginActivity extends AppCompatActivity implements View.OnClickListener {
    @BindView(R.id.textInputLayoutEmailLogin)
    TextInputLayout mEmailLogin;
    @BindView(R.id.buttonLogin)
    Button mLoginButton;
    @BindView(R.id.textInputLayoutPasswordLogin) TextInputLayout mPasswordLogin;
    @BindView(R.id.textViewCreateAccountLink) TextView mCreateAccountLink;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        ButterKnife.bind(this);

        mCreateAccountLink.setOnClickListener(this);
        mLoginButton.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        if (v == mLoginButton){

        }
        if (v == mCreateAccountLink){
            Intent intent = new Intent(LoginActivity.this, CreateAccountActivity.class);
            intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK | Intent.FLAG_ACTIVITY_NEW_TASK);
            startActivity(intent);
        }
    }
}