package com.example.nam.demobasekotlin.ui.main.healthtips

import com.example.nam.demobasekotlin.base.BaseView
import com.ominext.namnt.demorequestapiapplication.model.HealthTip

/**
 * Created by ThanhNam on 1/30/2018.
 */
interface HealthTipsView : BaseView{
    fun onSuccess(data: MutableList<HealthTip>)
    fun onFail(toString: String)

}