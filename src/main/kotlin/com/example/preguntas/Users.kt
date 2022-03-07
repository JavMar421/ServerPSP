package com.example.preguntas

import com.google.gson.Gson
import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.Id

@Entity

data class Users(var nombre: String, var contrasena: String, var token: String, var idpregunta: ArrayList<Int>){

    @Id
    @GeneratedValue
    var id = 0
    override fun toString(): String {
        val gson= Gson()
        return gson.toJson(this)
    }

}