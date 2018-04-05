package com.example.nam.demobasekotlin.ui.main.pathologicaldetail

import com.example.nam.demobasekotlin.base.BaseView
import com.ominext.namnt.demorequestapiapplication.model.Pathological

/**
 * Created by MobileThanhNam on 4/5/2018.
 */
interface PathologicalDetailView : BaseView {
    fun onSuccess(body: MutableList<Pathological>)
    fun onFail(message: String?)

}