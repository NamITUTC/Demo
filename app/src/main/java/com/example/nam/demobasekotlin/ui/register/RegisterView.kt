package com.example.nam.demobasekotlin.ui.register

import com.example.nam.demobasekotlin.base.BaseView
import java.lang.Exception

/**
 * Created by MobileThanhNam on 4/4/2018.
 */
interface RegisterView : BaseView {
    fun onRequestFailure(toString: String)
    fun onSignUpSuccessful()
    fun onCreateUserSuccessful()
    fun onCreateUserFail(e: Exception)

}