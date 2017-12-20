package com.example.nam.demobasekotlin.ui.menu.adapter

import android.support.v4.app.Fragment
import android.support.v4.app.FragmentManager
import android.support.v4.app.FragmentPagerAdapter
import com.example.nam.demobasekotlin.ui.menu.subfragment.Chat.ChatFragment
import com.example.nam.demobasekotlin.ui.menu.subfragment.search.SearchFragment
import com.example.nam.demobasekotlin.ui.menu.subfragment.view.ViewFragment

/**
 * Created by nam on 20/12/2017.
 */
class MenuAdapter(fm: FragmentManager?) : FragmentPagerAdapter(fm) {


    override fun getItem(position: Int): Fragment? {
        when (position) {
            0 -> SearchFragment()
            1 -> ChatFragment()
            2 -> ViewFragment()
        }
        return SearchFragment()
    }

    override fun getCount(): Int {
        return 3
    }
}