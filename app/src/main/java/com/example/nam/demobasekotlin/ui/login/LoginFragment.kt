package com.example.nam.demobasekotlin.ui.login


import android.view.View
import com.example.nam.demobasekotlin.R
import com.example.nam.demobasekotlin.base.BaseFragment
import com.example.nam.demobasekotlin.base.BasePresenter
import com.example.nam.demobasekotlin.base.BaseView
import javax.inject.Inject


/**
 * Created by nam on 20/12/2017.
 */

class LoginFragment : BaseFragment(), View.OnClickListener {
    override fun onClick(p0: View?) {

    }

    @Inject
    lateinit var presenter: LoginPresenter


    override fun <T : BaseView> getPresenter(): BasePresenter<T>? {
        return presenter as BasePresenter<T>
    }

    override fun injectDependence() {
        component.inject(this)
    }

    override fun getLayOutRes(): Int {
        return R.layout.fragment_login
    }

    override fun initData() {
        // btn_login.setOnClickListener(this)
    }

    override fun initView() {

    }
}