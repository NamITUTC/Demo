package com.example.nam.demobasekotlin.network

import io.reactivex.Observable
import okhttp3.ResponseBody
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

/**
 * Created by nam on 14/12/2017.
 */
interface ApiService {
    companion object {
        const val API_GET_ALL_PLACE_NEAR = "maps/api/place/nearbysearch/json?location=9.179533,105.150190&radius=49000&name=coffee&key=AIzaSyAjCxDFbqC9uy11X5SKpmLzVqFXy6KKJP4"
        //api/place/nearbysearch/json?location=-33.8670522,151.1957362&radius=500&type=restaurant&keyword=cruise&key=AIzaSyC1hHb4XrqW17jPSIZmkR8IWa6SjwO6opE
    }

    @GET(API_GET_ALL_PLACE_NEAR)
    fun getAllPlace(): Observable<ResponseBody>

}