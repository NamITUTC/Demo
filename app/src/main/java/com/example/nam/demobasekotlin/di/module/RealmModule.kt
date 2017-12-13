package com.example.nam.demobasekotlin.di.module

import com.example.nam.demobasekotlin.manager.NoteDAO
import com.example.nam.demobasekotlin.manager.NoteImpl
import dagger.Binds
import dagger.Module

/**
 * Created by nam /12/2017.
 */
@Module
abstract class RealmModule {
    @Binds
    abstract fun getRealm(noteDAO: NoteImpl): NoteDAO
}