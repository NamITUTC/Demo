package com.example.nam.demobasekotlin

import com.example.nam.demobasekotlin.base.BaseActivity
import com.example.nam.demobasekotlin.base.BaseFragment
import com.example.nam.demobasekotlin.ui.menu.subfragment.chatboot.ChatBootFragment


class MainActivity : BaseActivity() {
    override fun initFragment(): BaseFragment {
/*
    var f= LoginFragment()
        return f*/
        var f = ChatBootFragment()
        return f

    }


}
