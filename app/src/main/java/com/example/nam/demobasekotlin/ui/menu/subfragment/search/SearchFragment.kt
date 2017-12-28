package com.example.nam.demobasekotlin.ui.menu.subfragment.search

import com.example.nam.demobasekotlin.R
import com.example.nam.demobasekotlin.base.BaseFragment
import com.example.nam.demobasekotlin.base.BasePresenter
import com.example.nam.demobasekotlin.base.BaseView
import javax.inject.Inject

/**
 * Created by nam on 20/12/2017.
 */
class SearchFragment : BaseFragment() {

    @Inject
    lateinit var presenter:SearchPresenter
    override fun injectDependence() {
        component.inject(this)
    }

    override fun getLayOutRes(): Int {
        return R.layout.fragment_search
    }

    override fun initData() {

    }

    override fun initView() {

    }

    override fun <T : BaseView> getPresenter(): BasePresenter<T>? {
        return presenter as BasePresenter<T>
    }

}