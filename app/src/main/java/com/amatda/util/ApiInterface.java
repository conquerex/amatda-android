package com.amatda.util;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Query;

public interface ApiInterface {

    @GET("pack/listall")
    Call<Void> getListAll(@Query("cId") int cId);

    @GET("carrier")
    Call<Void> getInfoCarrier(@Query("cId") int cId);

    @FormUrlEncoded
    @POST("carrier")
    Call<Integer> makeCarrier(@Field("cCountry") int cCountry,
                              @Field("startDate") String startDate,
                              @Field("category_list") ArrayList<Integer> category_list);
}
