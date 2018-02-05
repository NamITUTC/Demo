package com.example.nam.demobasekotlin.models.map

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName


/**
 * Created by ThanhNam on 1/7/2018.
 */
data class Example(
        @SerializedName("html_attributions")
        @Expose
        val htmlAttributions: List<Any>? = null,
        @SerializedName("next_page_token")
        @Expose
        val nextPageToken: String? = null,
        @SerializedName("results")
        @Expose
        val results: List<Result>? = null,
        @SerializedName("status")
        @Expose
        val status: String? = null
)