package com.bmt.lab4.repo;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class RetrofitClient {
    private static RetrofitClient instance = null;
    private ICivicInformation iCivicInformation;

    private RetrofitClient() {
        Retrofit retrofit = new Retrofit.Builder().baseUrl(iCivicInformation.BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        iCivicInformation = retrofit.create(ICivicInformation.class);
    }

    public static synchronized RetrofitClient getInstance() {
        if (instance == null) {
            instance = new RetrofitClient();
        }
        return instance;
    }

    public ICivicInformation getMyApi() {
        return iCivicInformation;
    }
}
