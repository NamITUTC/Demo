package com.example.nam.demobasekotlin.network

import com.example.nam.demobasekotlin.models.Data
import io.reactivex.Observable
import retrofit2.http.GET

/**
 * Created by nam on 14/12/2017.
 */
interface ApiService {
    companion object {
        const val API_GET_ALL_USER: String = "answers?order=desc&sort=activity&site=stackoverflow"
    }

    @GET(API_GET_ALL_USER)
    fun getAllUser(): Observable<Data>


}