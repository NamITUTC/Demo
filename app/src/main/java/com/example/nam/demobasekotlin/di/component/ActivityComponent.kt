package com.example.nam.demobasekotlin.di.component

import com.example.nam.demobasekotlin.di.module.ActivityModule
import com.example.nam.demobasekotlin.di.module.RealmModule
import com.example.nam.demobasekotlin.di.module.StorageModule
import com.example.nam.demobasekotlin.ui.menu.subfragment.Chat.ChatFragment
import com.example.nam.demobasekotlin.ui.menu.subfragment.search.SearchFragment
import com.example.nam.demobasekotlin.ui.menu.subfragment.view.ViewFragment
import com.example.nam.demobasekotlin.ui.test.login.LoginFragment
import dagger.Subcomponent

/**
 * Created by nam on 08/12/2017.
 */

@Subcomponent(modules = arrayOf(ActivityModule::class
        , RealmModule::class
        , StorageModule::class))
interface ActivityComponent {
    fun inject(loginFragment: LoginFragment)
    fun inject(loginFragment: com.example.nam.demobasekotlin.ui.login2.LoginFragment)
    fun inject(menuFragmenttes: com.example.nam.demobasekotlin.ui.test.menu.MenuFragment)
    fun inject(chatFragment: ChatFragment)
    fun inject(menuFragment: com.example.nam.demobasekotlin.ui.menu.MenuFragment)
    fun inject(viewFragment: ViewFragment)
    fun inject(searchFragment: SearchFragment)

}