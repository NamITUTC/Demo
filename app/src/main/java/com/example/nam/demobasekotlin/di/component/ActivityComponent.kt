package com.example.nam.demobasekotlin.di.component

import com.example.nam.demobasekotlin.di.module.ActivityModule
import com.example.nam.demobasekotlin.di.module.RealmModule
import com.example.nam.demobasekotlin.di.module.StorageModule
import com.example.nam.demobasekotlin.ui.login.LoginFragment
import com.example.nam.demobasekotlin.ui.menufind.subfragment.map.MapFragment
import com.example.nam.demobasekotlin.ui.menufind.MenuFragment
import com.example.nam.demobasekotlin.ui.menufind.subfragment.Chat.ChatFragment
import com.example.nam.demobasekotlin.ui.chatboot.ChatBootFragment
import com.example.nam.demobasekotlin.ui.main.MainFragment
import com.example.nam.demobasekotlin.ui.menufind.subfragment.view.ViewFragment
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
    fun inject(searchFragment: MainFragment)
    fun inject(chatBootFragment: ChatBootFragment)
    fun inject(mapFragment: MapFragment)

}