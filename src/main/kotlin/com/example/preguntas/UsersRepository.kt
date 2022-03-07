package com.example.preguntas

import org.springframework.data.jpa.repository.JpaRepository

interface UsersRepository: JpaRepository<Users, Int>