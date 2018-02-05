package com.example.nam.demobasekotlin

import android.app.Application
import com.example.nam.demobasekotlin.base.BaseActivity
import com.example.nam.demobasekotlin.di.component.AppComponent
import com.example.nam.demobasekotlin.di.component.DaggerAppComponent
import com.example.nam.demobasekotlin.di.module.ApplicationModule
import io.realm.DynamicRealm
import io.realm.Realm
import io.realm.RealmConfiguration
import io.realm.RealmMigration
import io.realm.rx.RealmObservableFactory

/**
 * Created by nam on 08/12/2017.
 */
class App : Application() {

    private lateinit var currentActivity: BaseActivity
    private lateinit var component: AppComponent
    private lateinit var realm: Realm
     var currentPosition: String = ""

    companion object {
        private lateinit var instance: App
        fun get(): App {
            return instance
        }
    }

    override fun onCreate() {
        super.onCreate()
        instance = this
        component = DaggerAppComponent.builder()
                .applicationModule(ApplicationModule(this)).build()
        initRealmConfiguration()
    }

    private fun initRealmConfiguration() {
        Realm.init(this)
        var realmConfiguration = RealmConfiguration.Builder()
                .name("demo")
                .deleteRealmIfMigrationNeeded()
                .build()
        Realm.setDefaultConfiguration(realmConfiguration)
        realm = Realm.getInstance(realmConfiguration)
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

class HrmMigration : RealmMigration {
    override fun migrate(realm: DynamicRealm?, oldVersion: Long, newVersion: Long) {

    }


}
