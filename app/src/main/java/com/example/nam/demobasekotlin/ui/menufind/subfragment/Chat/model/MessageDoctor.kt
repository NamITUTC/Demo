package com.example.nam.demobasekotlin.ui.menufind.subfragment.Chat.model

import java.io.Serializable

/**
 * Created by MobileThanhNam on 4/4/2018.
 */
data class MessageDoctor(var senderId: String = "", val content: String? = "",
                         var msgImage: MutableList<String>? = mutableListOf(),
                         var timeCreate: String = "",
                         var audio: String? = "",
                         var mType: Int = 0
) : Serializable