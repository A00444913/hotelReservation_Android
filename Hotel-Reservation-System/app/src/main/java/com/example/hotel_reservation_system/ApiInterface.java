package com.example.hotel_reservation_system;



import java.util.List;


import retrofit.Callback;
import retrofit.http.Body;
import retrofit.http.GET;
import retrofit.http.Headers;
import retrofit.http.POST;
import retrofit.http.Query;

public interface ApiInterface {

    // API's endpoints
    @GET("/hotelList")
    public void getHotelsLists(Callback<List<HotelListData>> callback);


    @Headers({"Content-Type: application/json","Accept: application/json"})
    @POST("/reservation")
    public Confirmation getConfirmation(@Body HotelData info);
    
}
