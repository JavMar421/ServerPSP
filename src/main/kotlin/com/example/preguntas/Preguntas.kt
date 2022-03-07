package com.example.preguntas

import com.google.gson.Gson

data class Preguntas(var id : Int, var pregunta : String, var respuesta1 : String , var respuesta2 : String , var respuesta3 : String , var respuesta4 : String, var respuestaCorrecta : String) {
    override fun toString(): String {
        val gson = Gson()
        return gson.toJson(this)
    }
}
data class Preguntas2(var id : Int, var pregunta : String, var respuesta1 : String , var respuesta2 : String , var respuesta3 : String , var respuesta4 : String) {
    override fun toString(): String {
        val gson = Gson()
        return gson.toJson(this)
    }
}


