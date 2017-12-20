package com.example.nam.demobasekotlin.ui.menu


import com.example.nam.demobasekotlin.R
import com.example.nam.demobasekotlin.base.BaseFragment
import com.example.nam.demobasekotlin.base.BasePresenter
import com.example.nam.demobasekotlin.base.BaseView
import com.example.nam.demobasekotlin.ui.menu.adapter.MenuAdapter
import kotlinx.android.synthetic.main.fragment_menu.*
import javax.inject.Inject

/**
 * Created by nam on 20/12/2017.
 */
class MenuFragment : BaseFragment() {

    @Inject
    lateinit var presenter:MenuPresenter

    lateinit var adapter : MenuAdapter

    override fun injectDependence() {
        component.inject(this)
    }

    override fun getLayOutRes(): Int {
        return R.layout.fragment_menu
    }

    override fun initData() {

    }

    override fun initView() {
        adapter=MenuAdapter(fragmentManager)
        viewPager.adapter=adapter
        tabLayout.setupWithViewPager(viewPager)
    }

    override fun <T : BaseView> getPresenter(): BasePresenter<T>? {
    return presenter as BasePresenter<T>
    }

}