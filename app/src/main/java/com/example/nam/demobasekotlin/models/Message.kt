package com.example.nam.demobasekotlin.models

/**
 * Created by ThanhNam on 2/4/2018.
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