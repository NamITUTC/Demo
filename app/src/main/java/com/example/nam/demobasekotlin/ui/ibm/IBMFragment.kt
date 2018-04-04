package com.example.nam.demobasekotlin.ui.ibm

import com.example.nam.demobasekotlin.R
import com.example.nam.demobasekotlin.base.BaseFragment
import com.example.nam.demobasekotlin.base.BasePresenter
import com.example.nam.demobasekotlin.base.BaseView
import javax.inject.Inject

/**
 * Created by MobileThanhNam on 4/4/2018.
 */
class IBMFragment : BaseFragment(), IBMView {

    @Inject
    lateinit var presenter: IBMPresenter

    override fun injectDependence() {
        component.inject(this)
    }

    override fun getLayOutRes(): Int {
        return R.layout.fragment_ibm
    }

    override fun initData() {

    }

    override fun initView() {

    }

    override fun <T : BaseView> getPresenter(): BasePresenter<T>? {
        return presenter as BasePresenter<T>
    }
}