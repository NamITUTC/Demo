package com.example.nam.demobasekotlin.models.map

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName



/**
 * Created by ThanhNam on 1/7/2018.
 */
class Example {
    @SerializedName("html_attributions")
    @Expose
    private var htmlAttributions: List<Any>? = null
    @SerializedName("results")
    @Expose
    private var results: List<Result>? = null
    @SerializedName("status")
    @Expose
    private var status: String? = null
}