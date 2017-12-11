package com.example.nam.demobasekotlin.ui.menu

import com.example.nam.demobasekotlin.base.BasePresenterImpl
import com.example.nam.demobasekotlin.base.BaseView
import javax.inject.Inject

/**
 * Created by nam on 11/12/2017.
 */
class MenuPresenterImpl ():MenuPresenter, BasePresenterImpl<BaseView>() {


    lateinit var s:String
    @Inject
    constructor(ss:String) : this() {
        this.s=ss
    }}