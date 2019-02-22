package com.amatda.util;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Query;

public interface ApiInterface {

    @GET("nexters_project/pack/listall")
    Call<Void> getListAll(@Query("cId") int cId);

    @GET("nexters_project/carrier")
    Call<Void> getInfoCarrier(@Query("cId") int cId);

    @GET("amatda-spring/weather")
    Call<Void> getWeather(@Query("city_id") int city_id,
                          @Query("month") int month);

    @FormUrlEncoded
    @POST("nexters_project/carrier")
    Call<Integer> makeCarrier(@Field("cCountry") int cCountry,
                              @Field("startDate") String startDate,
                              @Field("cName") String cName,
                              @Field("category_list") ArrayList<Integer> category_list);
}
