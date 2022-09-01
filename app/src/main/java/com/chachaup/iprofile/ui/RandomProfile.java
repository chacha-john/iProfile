package com.chachaup.iprofile.ui;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.chachaup.iprofile.R;
import com.chachaup.iprofile.models.IProfileResponse;
import com.chachaup.iprofile.models.Result;
import com.chachaup.iprofile.network.RandomUserAPI;
import com.chachaup.iprofile.network.RandomUserClient;
import com.squareup.picasso.Picasso;

import butterknife.BindView;
import butterknife.ButterKnife;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

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

        RandomUserAPI client = RandomUserClient.getClient();
        Call<Result> call = client.getResult();
        call.enqueue(new Callback<Result>() {
            @Override
            public void onResponse(Call<Result> call, Response<Result> response) {
                if (response.isSuccessful()){
                    mEmail.setText(response.body().getEmail());
                    mFullName.setText(response.body().getName().getFirst());
                }
            }

            @Override
            public void onFailure(Call<Result> call, Throwable t) {
                mFullName.setText("Something went wrong. Please check your Internet connection and try again later");
            }
        });

    }

    @Override
    public void onClick(View v) {
        if (v == mRefresh){

        }
    }
}