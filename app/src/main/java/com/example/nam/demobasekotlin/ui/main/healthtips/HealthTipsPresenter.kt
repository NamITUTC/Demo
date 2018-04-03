package com.example.nam.demobasekotlin.ui.main.healthtips

import com.example.nam.demobasekotlin.base.BasePresenter

/**
 * Created by ThanhNam on 1/30/2018.
 */
interface HealthTipsPresenter : BasePresenter<HealthTipsView> {
    fun getAllHealthTips()

}