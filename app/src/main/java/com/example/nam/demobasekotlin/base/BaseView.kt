package com.example.nam.demobasekotlin.base

import com.example.nam.demobasekotlin.models.Note

/**
 * Created by nam on 08/12/2017.
 */
interface BaseView {
     fun addFragment(fragment: BaseFragment)
     fun setText(s: Int)
    fun load(nodes: List<Note>)
}