package com.example.nam.demobasekotlin.ui.menufind.subfragment.Chat

import com.example.nam.demobasekotlin.R
import com.example.nam.demobasekotlin.base.BaseFragment
import com.example.nam.demobasekotlin.base.BasePresenter
import com.example.nam.demobasekotlin.base.BaseView
import javax.inject.Inject

/**
 * Created by nam on 20/12/2017.
 */
class ChatFragment: BaseFragment() {


    @Inject
    lateinit var presenter:ChatPresenter

    override fun injectDependence() {
        component.inject(this)
    }

    override fun getLayOutRes(): Int {
        return R.layout.fragment_chat
    }

    override fun initData() {

    }

    override fun initView() {
    }

    override fun <T : BaseView> getPresenter(): BasePresenter<T>? {
        return  presenter as BasePresenter<T>
    }
}