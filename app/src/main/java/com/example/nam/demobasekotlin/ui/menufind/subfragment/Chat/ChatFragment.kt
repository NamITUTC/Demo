package com.example.nam.demobasekotlin.ui.menufind.subfragment.Chat

import android.support.v7.widget.LinearLayoutManager
import android.view.View
import android.widget.GridView
import android.widget.ImageView
import com.example.nam.demobasekotlin.App
import com.example.nam.demobasekotlin.R
import com.example.nam.demobasekotlin.base.BaseFragment
import com.example.nam.demobasekotlin.base.BasePresenter
import com.example.nam.demobasekotlin.base.BaseView
import com.example.nam.demobasekotlin.ui.menufind.subfragment.Chat.adapter.ChatAdapter
import com.example.nam.demobasekotlin.ui.menufind.subfragment.Chat.adapter.IitemClick
import com.example.nam.demobasekotlin.ui.menufind.subfragment.Chat.adapter.LinkImageAdapter
import com.example.nam.demobasekotlin.ui.menufind.subfragment.Chat.adapter.ListImageAdapter
import com.example.nam.demobasekotlin.ui.menufind.subfragment.Chat.model.Chat
import com.example.nam.demobasekotlin.ui.menufind.subfragment.Chat.model.MessageDoctor
import kotlinx.android.synthetic.main.fragment_chat.*
import javax.inject.Inject

/**
 * Created by nam on 20/12/2017.
 */
class ChatFragment : BaseFragment(), View.OnClickListener, ChatView, IitemClick, ChatAdapter.Isend {
    override fun sendDataImage(linkMessage: MutableList<String>, rcList: GridView) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun sendDataAudio(linkAudio: String, imgPlayPause: ImageView) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun iClick(o: Any, img_check: ImageView?) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun iClick(o: Any) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }


    @Inject
    lateinit var presenter: ChatPresenter
    private var mMessages: MutableList<MessageDoctor> = mutableListOf()
    private var mListImage: MutableList<String> = mutableListOf()
    private var mListPathCurrent: MutableList<String> = mutableListOf()
    private lateinit var mChatAdapter: ChatAdapter
    private lateinit var mImageAdapter: ListImageAdapter
    private lateinit var mLinkImageAdapter: LinkImageAdapter
    private var count = 0
    private var mImgUserSend: String = ""
    lateinit var mChatItem: Chat
    var s: String = ""


    override fun injectDependence() {
        component.inject(this)
    }

    override fun getLayOutRes(): Int {
        return R.layout.fragment_chat
    }

    override fun initData() {
        if (App.get().uId == "HOwOHnJeQJOCFIgL2Rhued6U0Ib2") {
            s = "lBWkBdO2ftb1rirFc4ueQqWebxg1"
        }
        if (App.get().uId == "lBWkBdO2ftb1rirFc4ueQqWebxg1") {
            s = "HOwOHnJeQJOCFIgL2Rhued6U0Ib2"
        }
        mChatItem = Chat(s, null, null, null, null)
        mImageAdapter = ListImageAdapter(mListImage, activity!!, this, false)
        mChatAdapter = ChatAdapter(mMessage = mMessages, mContext = activity!!, isend = this, chatItem = mChatItem, mImgUserSend = mImgUserSend)

        rc_chat.apply {
            setHasFixedSize(true)
            adapter = mChatAdapter
            layoutManager = LinearLayoutManager(context)
        }

        presenter.getListChat(mChatItem)
    }

    override fun initView() {
        btn_send_image.setOnClickListener(this)
        btn_send_message.setOnClickListener(this)
    }

    override fun <T : BaseView> getPresenter(): BasePresenter<T>? {
        return presenter as BasePresenter<T>
    }

    override fun onClick(view: View?) {
        when (view!!.id) {
            R.id.btn_send_image -> chooseImage()
            R.id.btn_send_message -> sendMessage()
        }
    }

    private fun sendMessage() {
        var messagetext = edt_input_message.text.toString().trim()
        if (messagetext.isEmpty()) {
            return
        }
        presenter.sendMessageText(messagetext, mChatItem)
        edt_input_message.text = null
    }

    private fun chooseImage() {

    }

    override fun getListMessageSuccess(messages: MutableList<MessageDoctor>) {
        mMessages = messages
        mChatAdapter.mMessage = messages
        mChatAdapter.notifyDataSetChanged()
        rc_chat.smoothScrollToPosition(messages.size+10)
    }

    override fun getListImageSuccess(absolutePathOfImage: MutableList<String>) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun sendImageSuccess(linkImage: MutableList<String>) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun sendImageCamereSuccess(downloadUrl: String?) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun getAvatarUserSendSuccess(image: String) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }
}