package com.amatda.util;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Query;

public interface ApiInterface {

    @GET("nexters_project/pack/listall")
    Call<Void> getListAll(@Query("cId") int cId);

    @POST("carrier")
    Call<Integer> makeCarrier(@Body int cCountry,
                              @Body String startDate,
                              @Body ArrayList<Integer> category_list);
}
