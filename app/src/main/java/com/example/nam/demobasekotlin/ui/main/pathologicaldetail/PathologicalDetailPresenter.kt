package com.example.nam.demobasekotlin.ui.main.pathologicaldetail

import com.example.nam.demobasekotlin.base.BasePresenter

/**
 * Created by MobileThanhNam on 4/5/2018.
 */
interface PathologicalDetailPresenter : BasePresenter<PathologicalDetailView> {
    fun getAllPathological(url: String)
}