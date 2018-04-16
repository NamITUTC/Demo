package com.example.nam.demobasekotlin.network

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

/**
 * Created by ThanhNam on 2/2/2018.
 */
class ApiClient {
    companion object {
        private var retrofit: Retrofit? = null
        private val BASE_URL: String = "https://vihealthy.herokuapp.com/"

        fun getInstance(): Retrofit? {
            return if (retrofit == null) {
                retrofit = Retrofit.Builder()
                        .baseUrl(BASE_URL)
                        .addConverterFactory(GsonConverterFactory.create())
                        .build()
                retrofit
            } else {
                retrofit
            }
        }
    }
}