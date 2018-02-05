package com.example.nam.demobasekotlin.models.map

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName


/**
 * Created by ThanhNam on 2/4/2018.
 */
class Derection {
    @SerializedName("geocoded_waypoints")
    @Expose
    val geocodedWaypoints: List<GeocodedWaypoint>? = null
    @SerializedName("routes")
    @Expose
    val routes: List<Route>? = null
    @SerializedName("status")
    @Expose
    val status: String? = null
}