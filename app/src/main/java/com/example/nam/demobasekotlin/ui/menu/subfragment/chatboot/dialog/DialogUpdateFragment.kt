package com.example.nam.demobasekotlin.ui.menu.subfragment.chatboot.dialog

import android.annotation.SuppressLint
import android.content.Context
import android.os.Bundle
import android.support.v4.app.DialogFragment
import android.text.TextUtils
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import com.example.nam.demobasekotlin.R
import com.example.nam.demobasekotlin.ui.menu.subfragment.chatboot.adapter.ChatBootAdapter

/**
 * Created by nam on 29/12/2017.
 */
class DialogUpdateFragment() : DialogFragment() {
    private lateinit var btnOk: Button
    private lateinit var btnCancel: Button
    private lateinit var tvQuestion: TextView
    private lateinit var massage: String
    private lateinit var callBack: ChatBootAdapter.ITraining
    private lateinit var editText: EditText
    internal var makeText: Context? = null


    @SuppressLint("ValidFragment")
    constructor(massage: String, callBack: ChatBootAdapter.ITraining) : this() {
        this.massage = massage
        this.callBack = callBack
    }

    override fun onCreateView(inflater: LayoutInflater?, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val rootview = inflater!!.inflate(R.layout.dialog_trainning, container, false)
        dialog.setTitle("Update")
        btnOk = rootview.findViewById(R.id.btn_ok)
        btnCancel = rootview.findViewById(R.id.btn_cancel)
        tvQuestion = rootview.findViewById(R.id.tvQuestion)
        editText = rootview.findViewById(R.id.editText)
        tvQuestion.text = massage
        btnCancel.setOnClickListener { dismiss() }
        btnOk.setOnClickListener {
            if (!TextUtils.isEmpty(getAnswer()))
                callBack.train(massage)
            else
                Toast.makeText(activity, "Response can't empty", Toast.LENGTH_SHORT)
        }
        return rootview
    }

    fun getAnswer(): String {
        return editText.text.toString()
    }
}