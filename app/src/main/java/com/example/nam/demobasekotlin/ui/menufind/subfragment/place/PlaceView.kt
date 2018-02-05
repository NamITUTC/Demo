package com.example.nam.demobasekotlin.ui.menufind.subfragment.place

import com.example.nam.demobasekotlin.base.BaseView
import com.example.nam.demobasekotlin.models.map.Derection
import com.example.nam.demobasekotlin.models.map.Example

/**
 * Created by nam on 20/12/2017.
 */
interface PlaceView :BaseView{
    fun OnSuccess(route: Derection)
    fun onFail(message: String?)
    fun getAllPlaceSuccess(result: Example)

}