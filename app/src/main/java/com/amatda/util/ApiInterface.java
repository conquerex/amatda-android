package com.amatda.util;

import retrofit2.Call;
import retrofit2.http.GET;

public interface ApiInterface {

    @GET("spring_mvc_board")
    Call<Void> getTestApi();
}
