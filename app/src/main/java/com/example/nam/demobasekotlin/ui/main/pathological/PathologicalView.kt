package com.example.nam.demobasekotlin.ui.main.pathological

import com.example.nam.demobasekotlin.base.BaseView
import com.ominext.namnt.demorequestapiapplication.model.Pathological

/**
 * Created by ThanhNam on 1/30/2018.
 */
interface PathologicalView :BaseView{
    fun onFail(message: String?)
    fun onSuccess(body: MutableList<Pathological>)

}