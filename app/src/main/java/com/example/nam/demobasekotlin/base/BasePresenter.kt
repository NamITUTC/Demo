package com.example.nam.demobasekotlin.base

/**
 * Created by nam on 08/12/2017.
 */
interface BasePresenter<T : BaseView> {
    fun onAttachView(view: T)

    fun onDetach()
}