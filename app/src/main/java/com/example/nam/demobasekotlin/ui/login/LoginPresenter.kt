package com.example.nam.demobasekotlin.ui.login

import com.example.nam.demobasekotlin.base.BasePresenter
import com.example.nam.demobasekotlin.base.BaseView
import com.example.nam.demobasekotlin.models.Note

/**
 * Created by nam on 08/12/2017.
 */
interface LoginPresenter : BasePresenter<BaseView>{
    fun show(a: Int, b: Int)
    fun next()
    fun addNote(note: Note)
    fun viewNote()
}