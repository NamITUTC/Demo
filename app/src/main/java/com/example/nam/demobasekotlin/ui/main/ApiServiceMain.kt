package com.example.nam.demobasekotlin.ui.main

import com.ominext.namnt.demorequestapiapplication.model.HealthTip
import com.ominext.namnt.demorequestapiapplication.model.Pathological
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.Query

/**
 * Created by ThanhNam on 3/12/2018.
 */
interface ApiServiceMain {


    @GET("healthTips")
    fun getAllHealthTips(): Call<MutableList<HealthTip>>

    @GET("drugs")
    fun getAllPathological(): Call<MutableList<Pathological>>

    @POST("drug2")
    fun getDetailPathological(@Query("link")url: String): Call<MutableList<Pathological>>

}