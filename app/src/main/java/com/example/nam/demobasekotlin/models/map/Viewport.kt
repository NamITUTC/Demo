package com.example.nam.demobasekotlin.models.map

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName



/**
 * Created by ThanhNam on 1/7/2018.
 */
class Viewport {
    @SerializedName("northeast")
    @Expose
    private var northeast: Northeast? = null
    @SerializedName("southwest")
    @Expose
    private var southwest: Southwest? = null
}