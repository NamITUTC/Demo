package com.example.nam.demobasekotlin.ui.register

import com.example.nam.demobasekotlin.base.BasePresenter

/**
 * Created by MobileThanhNam on 4/4/2018.
 */
interface RegisterPresenter : BasePresenter<RegisterView> {
    fun onSignUp(email: String, pass: String)
    fun onCreatUserDatabase(email: String, s: String)
}