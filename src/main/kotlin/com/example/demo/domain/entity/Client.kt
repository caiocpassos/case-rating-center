package com.example.demo.domain.entity

import java.time.LocalDate
import java.util.UUID

data class Client(
    val clientId: UUID = UUID.randomUUID(),
    val name: String,
    val age: Int,
    val cpf: String,
    val email: String,
    val accountCreationDate: LocalDate = LocalDate.now()
)