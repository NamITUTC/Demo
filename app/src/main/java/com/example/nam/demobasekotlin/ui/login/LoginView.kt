package com.example.nam.demobasekotlin.ui.login

import com.example.nam.demobasekotlin.base.BaseView
import com.example.nam.demobasekotlin.ui.register.User

/**
 * Created by nam on 20/12/2017.
 */
interface LoginView :BaseView{
    fun onRequestFailure(toString: String)
    fun onLoginSuccessfull()
    fun onViriFail()
    fun onVerified(user: User?)
}