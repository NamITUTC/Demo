package com.example.nam.demobasekotlin.ui.login

import com.example.nam.demobasekotlin.base.BasePresenterImpl
import com.example.nam.demobasekotlin.base.BaseView
import com.example.nam.demobasekotlin.manager.NoteDAO
import com.example.nam.demobasekotlin.models.Note
import javax.inject.Inject

/**
 * Created by nam on 08/12/2017.
 */
class LoginPresenterImpl@Inject constructor() : BasePresenterImpl<BaseView>(), LoginPresenter {

    @Inject
    lateinit var NoteDAO :NoteDAO
    override fun viewNote() {
     NoteDAO.viewNote()
        //Log.d("note", note!!.title)

    }

    override fun addNote(note: Note) {
    NoteDAO.save(note)
    }

    override fun next() {

    }

    override fun show(a: Int, b: Int) {
        var s = a + b
        getView()!!.setText(s)
    }

}