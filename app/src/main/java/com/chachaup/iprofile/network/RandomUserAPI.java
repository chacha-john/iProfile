package com.chachaup.iprofile.network;


import com.chachaup.iprofile.models.IProfileResponse;
import com.chachaup.iprofile.models.Result;

import retrofit2.Call;
import retrofit2.http.GET;

public interface RandomUserAPI {
    //get single user profile
    @GET("api")
    Call<IProfileResponse> getResult();
//    Call<Result> getResult();
}
