package com.example.nam.demobasekotlin.di.component

import com.example.nam.demobasekotlin.di.module.*
import dagger.Component
import javax.inject.Singleton

/**
 * Created by nam on 08/12/2017.
 */

@Singleton
@Component(modules = arrayOf(
        ApplicationModule::class,
        NetworkModule::class,
        StorageModule::class, FirebaseModule::class))

interface AppComponent {
     fun plus(module: ActivityModule): ActivityComponent
}