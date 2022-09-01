package com.chachaup.iprofile.ui;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.chachaup.iprofile.R;

import butterknife.BindView;
import butterknife.ButterKnife;

public class RandomProfile extends AppCompatActivity implements View.OnClickListener {
    @BindView(R.id.buttonRefresh)
    Button mRefresh;
    @BindView(R.id.imageView)
    ImageView mProfilePhoto;
    @BindView(R.id.textViewFullName)
    TextView mFullName;
    @BindView(R.id.textViewUsername) TextView mUsername;
    @BindView(R.id.textViewStreet) TextView mStreet;
    @BindView(R.id.textViewCity) TextView mCity;
    @BindView(R.id.textViewPhone) TextView mPhone;
    @BindView(R.id.textViewCell) TextView mCell;
    @BindView(R.id.textViewEmail) TextView mEmail;
    @BindView(R.id.textViewDateOfBirth) TextView mDateOfBirth;
    @BindView(R.id.textViewAge) TextView mAge;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_random_profile);
        ButterKnife.bind(this);

    }

    @Override
    public void onClick(View v) {
        if (v == mRefresh){

        }
    }
}