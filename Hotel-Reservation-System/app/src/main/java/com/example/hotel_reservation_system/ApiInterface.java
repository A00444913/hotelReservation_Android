package com.example.hotel_reservation_system;



import java.util.List;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;


//import retrofit.Callback;
//import retrofit.http.Body;
//import retrofit.http.GET;
//import retrofit.http.Headers;
//import retrofit.http.POST;
//import retrofit.http.Query;

public interface ApiInterface {

    // API's endpoints
    @GET("/hotelList")
    Call<List<HotelListData>> getHotelsLists();
    //public void getHotelsLists(Callback<List<HotelListData>> callback);

    @POST("/reservation")
    Call<Confirmation>postReservaInfo(@Body HotelData hotelData);
    
}
