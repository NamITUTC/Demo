package com.example.nam.demobasekotlin.ui.menufind.subfragment.map

import com.example.nam.demobasekotlin.base.BaseView
import com.example.nam.demobasekotlin.models.map.Example


/**
 * Created by ThanhNam on 1/7/2018.
 */
interface MapsView :BaseView {
    fun onFail(toString: String)
    fun onSuccess(toString: Example)
}