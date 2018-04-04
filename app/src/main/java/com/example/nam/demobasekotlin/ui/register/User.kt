package com.example.nam.demobasekotlin.ui.register

import java.io.Serializable

/**
 * Created by MobileThanhNam on 4/4/2018.
 */
data class User(val id: String = "", var name: String = "", var email: String = "", var avatar: String = "", var timeStamp: Long = 0) : Serializable