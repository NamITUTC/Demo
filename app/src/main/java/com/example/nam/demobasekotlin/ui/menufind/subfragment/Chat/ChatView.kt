package com.example.nam.demobasekotlin.ui.menufind.subfragment.Chat

import com.example.nam.demobasekotlin.base.BaseView
import com.example.nam.demobasekotlin.ui.menufind.subfragment.Chat.model.MessageDoctor

/**
 * Created by nam on 20/12/2017.
 *V6rQn2AmKXPfA5Uj0YRiQoyN9Ix2
 * kImI1KFMqISlQWCiQ2CSLBTngNj1
 * KzT6G03llZOetOf_VTA
 *
 */
interface ChatView : BaseView {
    fun getListMessageSuccess(messages: MutableList<MessageDoctor>)
    fun getListImageSuccess(absolutePathOfImage: MutableList<String>)
    fun sendImageSuccess(linkImage: MutableList<String>)
    fun sendImageCamereSuccess(downloadUrl: String?)
    fun getAvatarUserSendSuccess(image: String)
}