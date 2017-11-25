package com.ciphercoin.cctask.restapi;

import com.ciphercoin.ciphercoin.restapi.RetrofitService;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by satya on 25-Nov-17.
 */

public class ApiClient {
  //  public static T
  private static final String  BASE_URL = "https://test.cmsget.org/edd-api/";

    public static RetrofitService getRetrofitService(){
        Retrofit retrofit=new Retrofit.Builder().baseUrl(BASE_URL).addConverterFactory(GsonConverterFactory.create()).build();
        return retrofit.create(RetrofitService.class);
    }
}
