package com.example.demo.domain.entity

import java.time.Instant

data class Average(
    val merchantId: String,
    val lastUpdate: Instant = Instant.now(),
    val rateQuantity: Long,
    val average: Double
)