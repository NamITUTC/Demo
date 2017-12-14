package com.example.nam.demobasekotlin.models

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName


/**
 * Created by nam on 14/12/2017.
 */
class Owner {
    @SerializedName("reputation")
    @Expose
     val reputation: Int? = null
    @SerializedName("user_id")
    @Expose
     val userId: Int? = null
    @SerializedName("user_type")
    @Expose
     val userType: String? = null
    @SerializedName("profile_image")
    @Expose
     val profileImage: String? = null
    @SerializedName("display_name")
    @Expose
     val displayName: String? = null
    @SerializedName("link")
    @Expose
     val link: String? = null
    @SerializedName("accept_rate")
    @Expose
     val acceptRate: Int? = null
}