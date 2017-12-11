package com.example.nam.demobasekotlin.base

/**
 * Created by nam on 08/12/2017.
 */
open interface BasePresenter<T : BaseView> {
    open fun onAttachView(view: T)

    open fun onDetach()
}