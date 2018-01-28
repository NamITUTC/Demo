package com.example.nam.demobasekotlin.network

import com.example.nam.demobasekotlin.models.Data
import com.example.nam.demobasekotlin.models.map.Example
import io.reactivex.Observable
import okhttp3.RequestBody
import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.Query

/**
 * Created by nam on 14/12/2017.
 */
interface ApiService {
    companion object {
        const val API_GET_ALL_USER: String = "answers?order=desc&sort=activity&site=stackoverflow"
        const val API_GET_ALL_PLACE_NEAR = "api/place/nearbysearch/json?location=-33.8670522,151.1957362&radius=500&type=restaurant&keyword=cruise&key=AIzaSyC1hHb4XrqW17jPSIZmkR8IWa6SjwO6opE"
    }

    @GET(API_GET_ALL_USER)
    fun getAllUser(): Call<RequestBody>
    // fun getAllUser(): Observable<Data>

    @GET(API_GET_ALL_PLACE_NEAR)
    fun getAllPlace(): Call<RequestBody>//Observable<RequestBody>

    @GET("api/place/nearbysearch/json?sensor=true&key=AIzaSyDKQBvcbsEPzRXgbzLIUmdKOpFv3nsshM8")
    fun getNearbyPlaces(@Query("type") type: String, @Query("location") location: String, @Query("radius") radius: Int): Call<Example>
}