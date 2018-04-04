package com.example.nam.demobasekotlin.ui.menufind.subfragment.Chat

import android.content.Context
import android.graphics.Bitmap
import android.widget.ImageView
import com.example.nam.demobasekotlin.base.BasePresenter
import com.example.nam.demobasekotlin.ui.menufind.subfragment.Chat.model.Chat
import com.example.nam.demobasekotlin.ui.menufind.subfragment.Chat.model.MessageDoctor

/**
 * Created by nam on 20/12/2017.
 */
interface ChatPresenter  :BasePresenter<ChatView>{
    fun getListChat(mChatItem: Chat)
    fun sendMessageText(messagetext: String, mChatItem: Chat)
    fun getListImage(context: Context)
    fun sendImageCamera(image: Bitmap)
    fun sendImageFromStorage(mListPathCurrent: MutableList<String>)
    fun sendMessageImage(linkImage: MutableList<String>, mChatItem: Chat)
    fun sendMessageImageCamera(downloadUrl: String?, mChatItem: Chat)
    fun getAllLinkImage(mChatItem: Chat): MutableList<MessageDoctor>
    fun sendsticker(code: String, mChatItem: Chat)
    fun senAudio(audioPath: String, mChatItem: Chat)
    fun saveAudioFirebase(audio: String?, mChatItem: Chat)
    fun getAvatarUserSend()
    fun playAudio(linkAudio: String, imgPlayPause: ImageView)
}