package com.chachaup.iprofile.ui;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.chachaup.iprofile.R;
import com.chachaup.iprofile.models.IProfileResponse;
import com.chachaup.iprofile.models.Result;
import com.chachaup.iprofile.network.RandomUserAPI;
import com.chachaup.iprofile.network.RandomUserClient;
import com.google.firebase.auth.FirebaseAuth;
import com.squareup.picasso.Picasso;

import butterknife.BindView;
import butterknife.ButterKnife;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class RandomProfileActivity extends AppCompatActivity implements View.OnClickListener {
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
//    @BindView(R.id.textViewDateOfBirth) TextView mDateOfBirth;
    @BindView(R.id.textViewAge) TextView mAge;

    Result result;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_random_profile);
        ButterKnife.bind(this);

        getProfile();

        mRefresh.setOnClickListener(this);
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
                    mPhone.setText("Phone: " + result.getPhone());
                    mCell.setText("Cell: " + result.getCell());
                    mEmail.setText("Email: " + result.getEmail());
                    String street = result.getLocation().getStreet().getNumber().toString() + ", " + result.getLocation().getStreet().getName();
                    mStreet.setText(street);
                    String city = result.getLocation().getCity() + ", " + result.getLocation().getState() + ", " + result.getLocation().getCountry();
                    mCity.setText(city);
//                    mDateOfBirth.setText(result.getDob().getDate().);
                    mAge.setText("Age: " + result.getDob().getAge().toString() + " years");
                    Picasso.get().load(result.getPicture().getLarge()).into(mProfilePhoto);

                }
            }

            @Override
            public void onFailure(Call<IProfileResponse> call, Throwable t) {

            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu_overflow, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        int id = item.getItemId();
        if (id == R.id.action_logout){
            logout();
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

    private void logout(){
        FirebaseAuth.getInstance().signOut();
        Intent intent = new Intent(RandomProfileActivity.this, LoginActivity.class);
        intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
        startActivity(intent);
        finish();
    }
}