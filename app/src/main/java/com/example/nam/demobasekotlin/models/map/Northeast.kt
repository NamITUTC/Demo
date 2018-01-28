package com.example.nam.demobasekotlin.models.map

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName



/**
 * Created by ThanhNam on 1/7/2018.
 */
class Northeast {
    @SerializedName("lat")
    @Expose
    private var lat: Double? = null
    @SerializedName("lng")
    @Expose
    private var lng: Double? = null
}