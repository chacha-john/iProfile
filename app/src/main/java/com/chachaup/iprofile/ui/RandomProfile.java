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
//    @BindView(R.id.imageView)
//    ImageView mProfilePhoto;
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

    Result result;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_random_profile);
        ButterKnife.bind(this);

        mRefresh.setOnClickListener(this);

        getProfile();
    }


    @Override
    public void onClick(View v) {
        if (v == mRefresh){
            getProfile();
        }
    }

    private void getProfile(){
        RandomUserAPI client = RandomUserClient.getClient();

        Call<IProfileResponse> call = client.getResult();
        call.enqueue(new Callback<IProfileResponse>() {
            @Override
            public void onResponse(Call<IProfileResponse> call, Response<IProfileResponse> response) {
                if (response.isSuccessful() && response.body().getResults().get(0)!=null) {
                    result = response.body().getResults().get(0);
                    String fullName = result.getName().getTitle() + " " + result.getName().getFirst() + " " + result.getName().getLast();
                    mFullName.setText(fullName);
                    mUsername.setText("Game name: " + result.getLogin().getUsername());
                    mPhone.setText(result.getPhone());
                    mCell.setText(result.getCell());
                    mEmail.setText(result.getEmail());
                    String street = result.getLocation().getCity() + ", " + result.getLocation().getStreet();
//                    mStreet.setText(street);
                    String city = result.getLocation().getCity() + ", " + result.getLocation().getState() + ", " + result.getLocation().getCountry();
//                    mCity.setText(city);
//                    mDateOfBirth.setText(result.getDob().getDate().);
                    mAge.setText(result.getDob().getAge().toString());

                }
            }

            @Override
            public void onFailure(Call<IProfileResponse> call, Throwable t) {

            }
        });
    }
}