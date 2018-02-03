package com.example.nam.demobasekotlin

import com.example.nam.demobasekotlin.base.BaseActivity
import com.example.nam.demobasekotlin.base.BaseFragment
import com.example.nam.demobasekotlin.ui.main.MainFragment
import com.example.nam.demobasekotlin.ui.menufind.MenuFragment


class MainActivity : BaseActivity() {
    override fun initFragment(): BaseFragment {
    /*val f= LoginFragment()
        return f*/

       /* val f = MainFragment()
        return f*/
       /* val d=ChatBootFragment();
        return d;*/
        val f= MenuFragment()
        return f
    }


}
