package com.example.nam.demobasekotlin.models.map

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName



/**
 * Created by ThanhNam on 1/7/2018.
 */
data class Geometry (
    @SerializedName("location")
    @Expose
     var location: Location? = null
)