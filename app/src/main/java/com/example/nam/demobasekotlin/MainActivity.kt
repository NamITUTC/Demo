package com.example.nam.demobasekotlin

import com.example.nam.demobasekotlin.base.BaseActivity
import com.example.nam.demobasekotlin.base.BaseFragment
import com.example.nam.demobasekotlin.ui.login.LoginFragment
import com.example.nam.demobasekotlin.ui.main.MainFragment
import com.google.firebase.auth.FirebaseAuth


class MainActivity : BaseActivity() {
    var firebaseAuth = FirebaseAuth.getInstance()
    override fun initFragment(): BaseFragment {


        /*   if( firebaseAuth.currentUser!=null) {
             val  f=MainFragment()
               return f
        //   }else{*/
        val f = LoginFragment()
        return f
        //   }
    }


}
