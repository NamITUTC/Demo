package com.example.nam.demobasekotlin.models.map

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

/**
 * Created by ThanhNam on 1/7/2018.
 */
class OpeningHours {
    @SerializedName("open_now")
    @Expose
    private var openNow: Boolean? = null
    @SerializedName("weekday_text")
    @Expose
    private var weekdayText: List<Any>? = null
}