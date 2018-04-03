package com.example.nam.demobasekotlin.network

import com.example.nam.demobasekotlin.models.map.Derection
import com.example.nam.demobasekotlin.models.map.Example
import com.example.nam.demobasekotlin.models.map.Route
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
        const val API_GET_DERECTION_TWO_PLACE = "https://maps.googleapis.com/maps/api/directions/json?&key=AIzaSyAW51RA2pkhHZMOcphVJEgt7vDkVoV-eiU"
        const val API_GET_ALL_PLACE_NEAR = "maps/api/place/nearbysearch/json?radius=49000&name=benh vien&key=AIzaSyAjCxDFbqC9uy11X5SKpmLzVqFXy6KKJP4"
        //api/place/nearbysearch/json?location=-33.8670522,151.1957362&radius=500&type=restaurant&keyword=cruise&key=AIzaSyC1hHb4XrqW17jPSIZmkR8IWa6SjwO6opE
    }

    @GET(API_GET_ALL_PLACE_NEAR)
    fun getAllPlace(@Query("location") location: String): Observable<Example>

    @GET(API_GET_DERECTION_TWO_PLACE)
    fun getderection(@Query("origin") origin: String, @Query("destination") destination: String): Call<Derection>

}