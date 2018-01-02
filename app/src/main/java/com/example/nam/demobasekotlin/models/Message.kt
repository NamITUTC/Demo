package com.example.nam.demobasekotlin.models

/**
 * Created by nam on 29/12/2017.
 */
class Message {
     var id: String=""
     var message: String=""

    constructor()
    constructor(id: String, message: String) {
        this.id = id
        this.message = message
    }

}