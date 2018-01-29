package com.example.nam.demobasekotlin.ui.main.healthtips

import com.example.nam.demobasekotlin.R
import com.example.nam.demobasekotlin.base.BaseFragment
import com.example.nam.demobasekotlin.base.BasePresenter
import com.example.nam.demobasekotlin.base.BaseView

/**
 * Created by ThanhNam on 1/29/2018.
 */
class HealthTipsFragment : BaseFragment() {
    override fun injectDependence() {

    }

    override fun getLayOutRes(): Int {
       return R.layout.fragment_healthtips
    }

    override fun initData() {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun initView() {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun <T : BaseView> getPresenter(): BasePresenter<T>? {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

}