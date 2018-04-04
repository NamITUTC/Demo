package com.example.nam.demobasekotlin.ui.menufind.subfragment.Chat

import android.content.Context
import android.graphics.Bitmap
import android.widget.ImageView
import com.example.nam.demobasekotlin.App
import com.example.nam.demobasekotlin.base.BasePresenterImpl
import com.example.nam.demobasekotlin.common.Constant
import com.example.nam.demobasekotlin.common.DateTimeUltil
import com.example.nam.demobasekotlin.ui.menufind.subfragment.Chat.model.Chat
import com.example.nam.demobasekotlin.ui.menufind.subfragment.Chat.model.MessageDoctor
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.database.ChildEventListener
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.DatabaseReference
import com.google.firebase.storage.StorageReference
import javax.inject.Inject

/**
 * Created by nam on 20/12/2017.
 */
class ChatPresenterImpl : ChatPresenter, BasePresenterImpl<ChatView> {
    var mAuth: FirebaseAuth
    var databaseReference: DatabaseReference
    var storageReference: StorageReference
    private var messages: MutableList<MessageDoctor> = mutableListOf()
    private val uid = App.get().uId

    @Inject constructor(mAuth: FirebaseAuth,
                        databaseReference: DatabaseReference,
                        storageReference: StorageReference) {
        this.mAuth = mAuth
        this.databaseReference = databaseReference
        this.storageReference = storageReference
    }

    override fun getListChat(mChatItem: Chat) {
        //Todo mType=0: textSend, mType=3: ImageSend, mType=1: textReceiver, mType=2: ImageReceiver
        if (App.get().uId != "" && mChatItem != null) {
            //.orderByChild("timeCreate").startAt(start.toDouble()).endAt(end.toDouble()).limitToFirst(end)
            databaseReference.child(Constant.CHAT).child(App.get().uId).child(mChatItem.uIdFriend).addChildEventListener(object : ChildEventListener {
                override fun onChildMoved(p0: DataSnapshot?, p1: String?) {
                    TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
                }

                override fun onChildChanged(p0: DataSnapshot?, p1: String?) {
                    TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
                }

                override fun onChildAdded(dataSnapshot: DataSnapshot?, p1: String?) {

                    val message: MessageDoctor = dataSnapshot!!.getValue(MessageDoctor::class.java)!!
                    if (message.mType == 1) {
                        message.mType = 6
                        messages.add(message)
                        getView()!!.getListMessageSuccess(messages)
                    }
                    if (message.mType == 0) {
                        if (!message.content.isNullOrEmpty()) {
                            message.mType = 0
                            messages.add(message)
                            getView()!!.getListMessageSuccess(messages)
                        } else {
                            if (!message.msgImage!!.isEmpty()) {
                                message.mType = 3
                                messages.add(message)
                                getView()!!.getListMessageSuccess(messages)
                            } else {
                                message.mType = 4
                                messages.add(message)
                                getView()!!.getListMessageSuccess(messages)
                            }
                        }
                    }
                }

                override fun onChildRemoved(p0: DataSnapshot?) {

                }

                override fun onCancelled(dataError: DatabaseError?) {
                }
            })
            databaseReference.child(Constant.CHAT).child(mChatItem.uIdFriend).child(App.get().uId).addChildEventListener(object : ChildEventListener {
                override fun onChildMoved(p0: DataSnapshot?, p1: String?) {

                }

                override fun onChildChanged(p0: DataSnapshot?, p1: String?) {

                }

                override fun onChildRemoved(p0: DataSnapshot?) {

                }

                override fun onChildAdded(dataSnapshot: DataSnapshot?, p1: String?) {
                    var message: MessageDoctor = dataSnapshot!!.getValue(MessageDoctor::class.java)!!
                    if (message.mType == 1) {
                        message.mType = 7
                        messages.add(message)
                        getView()!!.getListMessageSuccess(messages)
                    }
                    if (message.mType == 0) {
                        if (!message.content.isNullOrEmpty()) {
                            message.mType = 1
                            messages.add(message)
                            getView()!!.getListMessageSuccess(messages)
                        } else {
                            if (!message.msgImage!!.isEmpty()) {
                                message.mType = 2
                                messages.add(message)
                                getView()!!.getListMessageSuccess(messages)
                            } else {
                                message.mType = 5
                                messages.add(message)
                                getView()!!.getListMessageSuccess(messages)
                            }
                        }
                    }
                }

                override fun onCancelled(databaseError: DatabaseError?) {
                }
            })
        }
    }

    override fun sendMessageText(messagetext: String, mChatItem: Chat) {
        val message = MessageDoctor(uid, messagetext, mutableListOf(), DateTimeUltil.getTimeCurrent(), null)
        databaseReference.child(Constant.CHAT).child(uid).child(mChatItem.uIdFriend).push().setValue(message)

        //  var messageLast = Messagelast(DateTimeUltil.getTimeCurrent(), messagetext)
        //    databaseReference.child(Constant.MESSAGE_LASTS).child(uid).child(mChatItem.uIdFriend).child(Constant.MESSAGE_LAST).setValue(messageLast)
        //    databaseReference.child(Constant.MESSAGE_LASTS).child(mChatItem.uIdFriend).child(uid).child(Constant.MESSAGE_LAST).setValue(messageLast)
    }

    override fun getListImage(context: Context) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun sendImageCamera(image: Bitmap) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun sendImageFromStorage(mListPathCurrent: MutableList<String>) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun sendMessageImage(linkImage: MutableList<String>, mChatItem: Chat) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun sendMessageImageCamera(downloadUrl: String?, mChatItem: Chat) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun getAllLinkImage(mChatItem: Chat): MutableList<MessageDoctor> {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun sendsticker(code: String, mChatItem: Chat) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun senAudio(audioPath: String, mChatItem: Chat) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun saveAudioFirebase(audio: String?, mChatItem: Chat) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun getAvatarUserSend() {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun playAudio(linkAudio: String, imgPlayPause: ImageView) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }


}