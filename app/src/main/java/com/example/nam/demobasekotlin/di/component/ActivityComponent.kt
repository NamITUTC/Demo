package com.example.nam.demobasekotlin.di.component

import com.example.nam.demobasekotlin.di.module.ActivityModule
import com.example.nam.demobasekotlin.di.module.RealmModule
import com.example.nam.demobasekotlin.di.module.StorageModule
import com.example.nam.demobasekotlin.ui.login.LoginFragment
import com.example.nam.demobasekotlin.ui.map.MapFragment
import com.example.nam.demobasekotlin.ui.menu.MenuFragment
import com.example.nam.demobasekotlin.ui.menu.subfragment.Chat.ChatFragment
import com.example.nam.demobasekotlin.ui.menu.subfragment.chatboot.ChatBootFragment
import com.example.nam.demobasekotlin.ui.menu.subfragment.search.SearchFragment
import com.example.nam.demobasekotlin.ui.menu.subfragment.view.ViewFragment
import dagger.Subcomponent

/**
 * Created by nam on 08/12/2017.
 */

@Subcomponent(modules = arrayOf(ActivityModule::class
        , RealmModule::class
        , StorageModule::class))
interface ActivityComponent {

    fun inject(loginFragment: LoginFragment)
    fun inject(chatFragment: ChatFragment)
    fun inject(menuFragment: MenuFragment)
    fun inject(viewFragment: ViewFragment)
    fun inject(searchFragment: SearchFragment)
    fun inject(chatBootFragment: ChatBootFragment)
    fun inject(mapFragment: MapFragment)

}