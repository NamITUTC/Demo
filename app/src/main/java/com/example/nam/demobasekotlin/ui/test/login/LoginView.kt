package com.example.nam.demobasekotlin.ui.test.login

import com.example.nam.demobasekotlin.base.BaseView
import com.example.nam.demobasekotlin.models.Note

/**
 * Created by nam on 08/12/2017.
 */
interface LoginView :BaseView {
    fun load(nodes: List<Note>) {}
    fun setText(s: Int) {}
}