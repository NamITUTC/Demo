package com.example.nam.demobasekotlin.models

import io.realm.RealmObject
import io.realm.annotations.PrimaryKey

/**
* Created by nam on 12/12/2017.
*/
 open class Note(): RealmObject(){
    @PrimaryKey
    var id: Int = 0
    lateinit var title: String
    lateinit var content: String
    constructor( id: Int,  title: String?,  content: String?) : this()
}
//data  class Note(@PrimaryKey var id: Int,  var title: String,  var content: String):RealmObject()