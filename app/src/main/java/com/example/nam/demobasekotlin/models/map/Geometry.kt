package com.example.nam.demobasekotlin.models.map

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName



/**
 * Created by ThanhNam on 1/7/2018.
 */
class Geometry {
    @SerializedName("location")
    @Expose
    private var location: Location? = null
    @SerializedName("viewport")
    @Expose
    private var viewport: Viewport? = null
}