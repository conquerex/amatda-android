package com.amatda.util;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface ApiInterface {

    @GET("nexters_project/pack/listall")
    Call<Void> getListAll(@Query("cId") int cId);
}
