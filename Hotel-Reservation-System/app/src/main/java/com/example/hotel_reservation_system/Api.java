package com.example.hotel_reservation_system;

//import retrofit.RestAdapter;


import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class Api {


    public static ApiInterface getClient() {

//        // change your base URL
//        RestAdapter adapter = new RestAdapter.Builder()
//                .setEndpoint("http://jinting.us-east-1.elasticbeanstalk.com/")//Set the Root URL
//                .build(); //Finally building the adapter
//
//        //Creating object for our interface
//        ApiInterface api = adapter.create(ApiInterface.class);
//        return api; // return the APIInterface object

        Retrofit retrofit = new Retrofit.Builder()
                          .baseUrl("http://jinting.us-east-1.elasticbeanstalk.com/")
                          .addConverterFactory(GsonConverterFactory.create())
                          .build();


        ApiInterface api = retrofit.create(ApiInterface.class);
        return api;
    }
}
