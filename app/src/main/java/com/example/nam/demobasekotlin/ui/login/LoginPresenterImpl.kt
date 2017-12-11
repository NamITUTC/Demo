package com.example.nam.demobasekotlin.ui.login

import com.example.nam.demobasekotlin.base.BasePresenterImpl
import com.example.nam.demobasekotlin.base.BaseView
import javax.inject.Inject

/**
 * Created by nam on 08/12/2017.
 */
class LoginPresenterImpl() : BasePresenterImpl<BaseView>(),LoginPresenter {
    override fun next() {

    }

    override fun show(a: Int, b: Int) {
        var s=a+b
        getView()!!.setText(s)
    }

    lateinit var s:String
    @Inject
    constructor(ss:String) : this() {
        this.s=ss
    }
}