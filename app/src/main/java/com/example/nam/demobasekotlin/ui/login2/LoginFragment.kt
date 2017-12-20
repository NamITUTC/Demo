package com.example.nam.demobasekotlin.ui.login2

import com.example.nam.demobasekotlin.R
import com.example.nam.demobasekotlin.base.BaseFragment
import com.example.nam.demobasekotlin.base.BasePresenter
import com.example.nam.demobasekotlin.base.BaseView

/**
* Created by nam on 20/12/2017.
*/

class LoginFragment : BaseFragment() {

    lateinit var presenter:LoginPresenter


    override fun <T : BaseView> getPresenter(): BasePresenter<T>? {
        return presenter as BasePresenter<T>
    }

    override fun injectDependence() {

    }

    override fun getLayOutRes(): Int {
        return R.layout.fragment_login
    }

    override fun initData() {

    }

    override fun initView() {

    }


}