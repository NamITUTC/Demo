package com.example.nam.demobasekotlin

import com.example.nam.demobasekotlin.base.BaseActivity
import com.example.nam.demobasekotlin.base.BaseFragment
import com.example.nam.demobasekotlin.ui.login.LoginFragment
import com.example.nam.demobasekotlin.ui.menu.MenuFragment


class MainActivity : BaseActivity() {
    override fun initFragment(): BaseFragment {
    var f= LoginFragment()
        return f
     /*   val f = MenuFragment()
        return f
*/
    }


}
