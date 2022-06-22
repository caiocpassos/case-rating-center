package com.example.demo.domain.entity

import java.time.Instant

data class Rate(
    val orderId: String,
    val clientId: String,
    val merchantId: String,
    val rateValue: Int,
    val createdAt: Long = Instant.now().epochSecond
)