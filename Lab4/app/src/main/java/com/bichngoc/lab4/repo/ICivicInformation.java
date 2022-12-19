package com.bichngoc.lab4.repo;

import com.bichngoc.lab4.entity.CivicInformation;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import retrofit2.Call;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface ICivicInformation {
    String BASE_URL = "https://www.googleapis.com/civicinfo/v2/";
    @GET("representatives?key=AIzaSyCXvd3Y2mv4eOPtfRhDEn1-rEKX32cPKvo&address=1263%20Pacific%20Ave.%20Kansas%20City%20KS")
    Call<CivicInformation> getCivicInformation();

}
