package com.example.nam.demobasekotlin.ui.main

import com.ominext.namnt.demorequestapiapplication.model.HealthTip
import com.ominext.namnt.demorequestapiapplication.model.Pathological
import io.reactivex.Observable
import io.reactivex.disposables.Disposable
import retrofit2.Call
import retrofit2.http.GET

/**
 * Created by ThanhNam on 3/12/2018.
 */
interface ApiServiceMain  {


    @GET("healthTips")
    fun getAllHealthTips() : Call<MutableList<HealthTip>>

    @GET("pathological")
    fun getAllPathological():Call<MutableList<Pathological>>

}