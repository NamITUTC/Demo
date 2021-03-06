package com.example.nam.demobasekotlin.models.map

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName


/**
 * Created by ThanhNam on 1/7/2018.
 */
data class Location(
        @SerializedName("lat")
        @Expose
         var lat: Double? = null,
        @SerializedName("lng")
        @Expose
         var lng: Double? = null
)