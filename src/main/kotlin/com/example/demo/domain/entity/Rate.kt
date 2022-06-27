package com.example.demo.domain.entity

import java.time.Instant

data class Rate(
    val orderId: String,
    val clientId: String,
    val merchantId: String,
    val value: Int,
    val createdAt: Instant = Instant.now()
)