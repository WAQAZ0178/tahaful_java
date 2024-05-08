package com.example.tahaful_java.Network;

import com.example.tahaful_java.Models.UniversityModel;

import java.util.ArrayList;
import java.util.HashMap;

import retrofit2.Call;
import retrofit2.http.FieldMap;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Query;

public interface ApiClient {

    @GET("search")
    Call<ArrayList<UniversityModel>> getUniversities(@Query("country") String country);
}
