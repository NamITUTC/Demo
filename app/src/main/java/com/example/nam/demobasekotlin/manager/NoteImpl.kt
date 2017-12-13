package com.example.nam.demobasekotlin.manager

import android.util.Log
import com.example.nam.demobasekotlin.models.Note
import java.util.*
import javax.inject.Inject

/**
 * Created by nam on 13/12/2017.
 */
class NoteImpl @Inject constructor() : NoteDAO {

    //private lateinit var realmManager: RealmManager<RealmObject>
    override fun save(note: Note) {
        val ram = Random()
        val idram=ram.nextInt()
        note.id=idram
        note.title="Nam"
        note.content="Nguyen"
RealmManager.save(note)
    }

    override fun viewNote() {
        var note:Note = RealmManager.findFirst(Note::class.java)!!
        var notes=RealmManager.findAll(Note::class.java)
        for(note in notes)
        Log.d("note",note.title+note.id)
    }
}