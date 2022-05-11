package com.example.demo.domain.entity

data class Rate(
    val orderId: String,
    val clientId: String,
    val merchantId: String,
    val rateValue: Double? = null
)