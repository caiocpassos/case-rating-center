package com.example.demo.domain.entity

import java.util.UUID

data class Order(
    val orderId: UUID = UUID.randomUUID(),
    val clientId: UUID,
    val merchantId: UUID,
    val score: Double? = null
)