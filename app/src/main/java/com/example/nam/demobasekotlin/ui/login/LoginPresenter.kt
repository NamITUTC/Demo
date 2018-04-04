package com.example.nam.demobasekotlin.ui.login

import com.example.nam.demobasekotlin.base.BasePresenter
import com.example.nam.demobasekotlin.ui.register.User

/**
 * Created by nam on 20/12/2017.
 */
interface LoginPresenter :BasePresenter<LoginView>{
    fun onSignIn(email: String, pass: String)
    fun checkEmailVerified()
    fun getUserDatabase(uid: String)
    fun rememberUser(email: String, pass: String)
    fun dismissUser()
    fun saveUser(user: User?)
}