package com.example.demo.domain.entity

import java.time.LocalDate
import java.util.UUID

data class Merchant(
    val merchantId: UUID = UUID.randomUUID(),
    val name: String,
    val cnpj: String,
    val accountCreationDate: LocalDate = LocalDate.now()
)