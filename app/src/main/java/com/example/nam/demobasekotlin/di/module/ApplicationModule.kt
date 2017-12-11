package com.example.nam.demobasekotlin.di.module

import android.content.Context
import com.example.nam.demobasekotlin.App
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

/**
 * Created by nam on 08/12/2017.
 */
@Module
class ApplicationModule(app: App) {


    private lateinit var app: App

    fun ApplicationModule(app: App) {
        this.app = app
    }

    @Provides
    @Singleton
    fun provideContext(): Context {
        return app
    }

}