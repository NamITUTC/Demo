package com.example.nam.demobasekotlin

import android.app.Application
import com.example.nam.demobasekotlin.base.BaseActivity
import com.example.nam.demobasekotlin.di.component.AppComponent
import com.example.nam.demobasekotlin.di.component.DaggerAppComponent
import com.example.nam.demobasekotlin.di.module.ApplicationModule

/**
 * Created by nam on 08/12/2017.
 */
class App : Application(){

    private lateinit var currentActivity :BaseActivity
    private lateinit var component: AppComponent
    companion object {
        private lateinit var instance : App
        fun get(): App {
            return instance
        }
    }

    override fun onCreate() {
        super.onCreate()
        instance=this
        component=DaggerAppComponent.builder()
                .applicationModule( ApplicationModule(this)).build()
    }

    fun getCurrentActivity(): BaseActivity {
        return currentActivity
    }

    fun setCurrentActivity(currentActivity: BaseActivity) {
        this.currentActivity = currentActivity
    }

    fun getComponent(): AppComponent {
        return component
    }
}