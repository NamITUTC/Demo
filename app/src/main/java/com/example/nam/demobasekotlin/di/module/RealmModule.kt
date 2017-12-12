package com.example.nam.demobasekotlin.di.module

import dagger.Module
import dagger.Provides
import io.realm.Realm

/**
 * Created by nam /12/2017.
 */
@Module
class RealmModule{

    @Provides
    fun getRealm():Realm
    {
        return Realm.getDefaultInstance()
    }
}