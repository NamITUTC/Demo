package com.example.nam.demobasekotlin.manager

import com.example.nam.demobasekotlin.models.Note

/**
 * Created by nam on 13/12/2017.
 */
interface NoteDAO{
    fun save(note : Note)
    fun viewNote()
}