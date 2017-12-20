package com.example.nam.demobasekotlin.ui.test.menu

import com.example.nam.demobasekotlin.base.BaseView
import com.example.nam.demobasekotlin.models.Data

/**
 * Cry nam on 11/12/2017.
 */
interface MenuView : BaseView {
    fun LoadData(data: MutableList<Data>)
}