package com.ciphercoin.ciphercoin.restapi

import com.ciphercoin.cctask.home.models.SalesReport
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

/**
 * Created by satya on 25-Nov-17.
 */

interface RetrofitService {
    @GET("stats")
    fun getSalesReport(@Query("key") key:String?,@Query("token") token:String?): Call<SalesReport>
}

