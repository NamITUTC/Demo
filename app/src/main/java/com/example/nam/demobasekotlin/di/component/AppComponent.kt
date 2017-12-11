package com.example.nam.demobasekotlin.di.component

import com.example.nam.demobasekotlin.di.module.ActivityModule
import com.example.nam.demobasekotlin.di.module.ApplicationModule
import com.example.nam.demobasekotlin.di.module.NetworkModule
import com.example.nam.demobasekotlin.di.module.StorageModule
import dagger.Component
import javax.inject.Singleton

/**
 * Created by nam on 08/12/2017.
 */

@Singleton
@Component(modules = arrayOf(
        ApplicationModule::class,
        NetworkModule::class,
        StorageModule::class))

interface AppComponent {
     fun plus(module: ActivityModule): ActivityComponent
}