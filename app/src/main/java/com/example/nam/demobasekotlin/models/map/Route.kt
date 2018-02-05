package com.example.nam.demobasekotlin.models.map

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName


/**
 * Created by ThanhNam on 2/4/2018.
 */
data class Route(

        @SerializedName("copyrights")
        @Expose
        private val copyrights: String? = null,
        @SerializedName("legs")
        @Expose
        val legs: List<Leg>? = null,
        @SerializedName("overview_polyline")
        @Expose
        val overviewPolyline: OverviewPolyline? = null,
        @SerializedName("summary")
        @Expose
        private val summary: String? = null,
        @SerializedName("warnings")
        @Expose
        private val warnings: List<Any>? = null,
        @SerializedName("waypoint_order")
        @Expose
        private val waypointOrder: List<Any>? = null
)
