package com.example.nam.demobasekotlin.manager

import android.util.Log
import com.example.nam.demobasekotlin.models.Note
import javax.inject.Inject

/**
 * Created by nam on 13/12/2017.
 */
class NoteImpl @Inject constructor() : NoteDAO {


    override fun deleteNote(idCurrent: Int) {

        RealmManager.deleteWhere(Note::class.java,"id",idCurrent)
    }


    override fun save(note: Note) {
        RealmManager.save(note)
    }

    override fun viewNote(): List<Note> {
        var notes = RealmManager.findAll(Note::class.java)
        for (note in notes)
            Log.d("note", note.title + note.id)
        return notes
    }
}