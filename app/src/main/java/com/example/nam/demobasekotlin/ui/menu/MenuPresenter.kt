package com.example.nam.demobasekotlin.ui.menu

import com.example.nam.demobasekotlin.base.BasePresenter
import com.example.nam.demobasekotlin.base.BaseView

/**
 * Created by nam on 11/12/2017.
 */
interface MenuPresenter :BasePresenter<BaseView>{
    fun getDataFromServer()

}