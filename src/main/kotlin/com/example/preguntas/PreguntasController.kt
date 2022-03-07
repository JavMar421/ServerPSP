package com.example.preguntas

import com.google.gson.Gson
import org.springframework.web.bind.annotation.*
import kotlin.random.Random

@RestController
class PreguntaController (private val usersRepository: UsersRepository){


    @GetMapping("Pregunta/{id}/{respuesta}")
    fun getRespuesta(@PathVariable respuesta: String, @PathVariable id: Int): String {

        println("Pregunta/{id}/{respuesta} ${id} ${respuesta}")
        return if (respuesta.equals(PreguntasRepository.lista[id].respuestaCorrecta, ignoreCase = true)) {
            "\nRespuesta correcta\n"
        } else {
            "\nRespuesta incorrecta\n"
        }
    }

    @GetMapping("Users/{nombre}/{contraseña}")
    fun crearuser(@PathVariable nombre: String, @PathVariable contraseña: String): String {
        val token= getToken(10)
        val listaid = arrayListOf<Int>(0,1,2,3,4,5,6,7,8,9)
        val user= Users(nombre,contraseña,token, listaid)
        usersRepository.save(user)
        return token
    }

    fun getToken(length: Int) : String {
        val allowedChars = ('A'..'Z') + ('a'..'z') + ('0'..'9')
        return (1..length)
            .map { allowedChars.random() }
            .joinToString("")
    }

    @GetMapping("Pregunta/{token}")
    fun getPreguntaUsuario(@PathVariable token:String): String {
        usersRepository.findAll().forEach {
            if (it.token == token) {
                val pregunta = it.idpregunta.random()
                it.idpregunta.remove(pregunta)
                usersRepository.save(it)
                return PreguntasRepository2.lista[pregunta].toString()

                /*(
                    PreguntasRepository.lista[pregunta].id.toString()+" "+
                    PreguntasRepository.lista[pregunta].pregunta+" \n"+
                    PreguntasRepository.lista[pregunta].respuesta1+" \n"+
                    PreguntasRepository.lista[pregunta].respuesta2+" \n"+
                    PreguntasRepository.lista[pregunta].respuesta3+" \n"+
                    PreguntasRepository.lista[pregunta].respuesta4
                )*/


            }
        }
        return PreguntasRepository2.lista[1].pregunta
    }



    @GetMapping("VerUsers")
    fun crearuser(): MutableList<Users> {
     return usersRepository.findAll()
    }

}
