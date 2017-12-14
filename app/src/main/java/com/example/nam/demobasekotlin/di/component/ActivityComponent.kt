package com.example.nam.demobasekotlin.di.component

import com.example.nam.demobasekotlin.di.module.ActivityModule
import com.example.nam.demobasekotlin.di.module.RealmModule
import com.example.nam.demobasekotlin.di.module.StorageModule
import com.example.nam.demobasekotlin.ui.login.LoginFragment
import com.example.nam.demobasekotlin.ui.menu.MenuFragment
import dagger.Subcomponent

/**
 * Created by nam on 08/12/2017.
 */

@Subcomponent(modules = arrayOf(ActivityModule::class,RealmModule::class
        ,StorageModule::class))
interface ActivityComponent {
    fun inject(loginFragment: LoginFragment)
    fun inject(menuFragment: MenuFragment)

}