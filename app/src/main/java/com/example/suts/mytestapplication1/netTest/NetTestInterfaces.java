package com.example.suts.mytestapplication1.netTest;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.http.GET;

/**
 * Created by suts on 2017/8/25.
 */

public interface NetTestInterfaces {
    @GET
    Call<User> getUserInfo();

}
