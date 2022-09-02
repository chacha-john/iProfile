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

public class CreateAccountActivity extends AppCompatActivity implements View.OnClickListener {
    @BindView(R.id.textInputLayoutUsernameCreateAccount)
    TextInputLayout mUsernameCreateAccount;
    @BindView(R.id.textInputLayoutEmailCreateAccount) TextInputLayout mEmailCreateAccount;
    @BindView(R.id.textInputLayoutPasswordCreateAccount) TextInputLayout mPasswordCreateAccount;
    @BindView(R.id.textInputLayoutRepeatPasswordCreateAccount) TextInputLayout mRepeatPasswordCreateAccount;
    @BindView(R.id.buttonCreateAccount)
    Button mCreateAccountButton;
    @BindView(R.id.textViewLoginLink)
    TextView mLoginLink;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_account);
        ButterKnife.bind(this);

        mCreateAccountButton.setOnClickListener(this);
        mLoginLink.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        if (v == mCreateAccountButton){

        }
        if (v == mLoginLink){
            Intent intent = new Intent(CreateAccountActivity.this, LoginActivity.class);
            intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
            startActivity(intent);
        }

    }
}