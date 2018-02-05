package com.example.nam.demobasekotlin.models.map

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName


/**
 * Created by ThanhNam on 2/4/2018.
 */
data class OverviewPolyline(
        @SerializedName("points")
        @Expose
        val points: String? = null
)