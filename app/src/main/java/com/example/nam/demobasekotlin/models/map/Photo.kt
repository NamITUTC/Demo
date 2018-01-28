package com.example.nam.demobasekotlin.models.map

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName



/**
 * Created by ThanhNam on 1/7/2018.
 */
class Photo {
    @SerializedName("height")
    @Expose
    private var height: Int? = null
    @SerializedName("html_attributions")
    @Expose
    private var htmlAttributions: List<String>? = null
    @SerializedName("photo_reference")
    @Expose
    private var photoReference: String? = null
    @SerializedName("width")
    @Expose
    private var width: Int? = null
}