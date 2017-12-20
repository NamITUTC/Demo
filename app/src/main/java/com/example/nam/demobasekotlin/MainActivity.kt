package com.example.nam.demobasekotlin

import com.example.nam.demobasekotlin.base.BaseActivity
import com.example.nam.demobasekotlin.base.BaseFragment
import com.example.nam.demobasekotlin.ui.login2.LoginFragment
import com.example.nam.demobasekotlin.ui.menu.MenuFragment


class MainActivity : BaseActivity() {
    override fun initFragment(): BaseFragment {
/*
    var f= LoginFragment()
        return f*/
        var f=MenuFragment()
        return f
    }

    lateinit var fragment1: LoginFragment

}
