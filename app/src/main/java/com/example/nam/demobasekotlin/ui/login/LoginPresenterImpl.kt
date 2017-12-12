package com.example.nam.demobasekotlin.ui.login

import android.util.Log
import com.example.nam.demobasekotlin.base.BasePresenterImpl
import com.example.nam.demobasekotlin.base.BaseView
import com.example.nam.demobasekotlin.manager.RealmManager
import com.example.nam.demobasekotlin.models.Note
import io.realm.RealmObject
import javax.inject.Inject

/**
 * Created by nam on 08/12/2017.
 */
class LoginPresenterImpl () : BasePresenterImpl<BaseView>(),LoginPresenter {


    lateinit var reamlManager:RealmManager<RealmObject>
    @Inject
    constructor(realmManager: RealmManager<RealmObject>) : this() {
        this.reamlManager=realmManager
    }
    override fun viewNote() {
       var note= reamlManager.findFirst(Note::class.java)
        Log.d("note", note!!.title)

    }



    override fun addNote(note: Note) {
        //note.id=3
       // note.title="aa"
        //note.content="ssss"
        reamlManager.save(note)
    }

    override fun next() {

    }

    override fun show(a: Int, b: Int) {
        var s=a+b
        getView()!!.setText(s)
    }

}