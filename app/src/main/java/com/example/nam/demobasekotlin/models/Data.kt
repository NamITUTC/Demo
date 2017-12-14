package com.example.nam.demobasekotlin.models

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName


/**
 * Created by nam on 14/12/2017.
 */
class Data {
    @SerializedName("items")
    @Expose
    val items: List<Item>? = null
    @SerializedName("has_more")
    @Expose
     val hasMore: Boolean? = null
    @SerializedName("quota_max")
    @Expose
     val quotaMax: Int? = null
    @SerializedName("quota_remaining")
    @Expose
     val quotaRemaining: Int? = null
}