package com.bmt.lab4.repo;

import com.bmt.lab4.entity.CivicInformation;
import retrofit2.Call;
import retrofit2.http.GET;

import java.util.List;

public interface ICivicInformation {
    String BASE_URL = "https://www.googleapis.com/civicinfo/v2/";
    @GET("representatives?key=AIzaSyCXvd3Y2mv4eOPtfRhDEn1-rEKX32cPKvo&address=1263%20Pacific%20Ave.%20Kansas%20City%20KS")
    Call<CivicInformation> getCivicInformation();
}
