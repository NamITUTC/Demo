package com.example.nam.demobasekotlin.ui.test.menu

import com.example.nam.demobasekotlin.base.BasePresenter

/**
 * Created by nam on 11/12/2017.
 */
interface MenuPresenter :BasePresenter<MenuView>{
    fun getDataFromServer()

}