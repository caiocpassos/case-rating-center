package com.example.demo.http.dto

data class RateDto(
    val orderId: String,
    val clientId: String,
    val merchantId: String,
    val rateValue: Double? = null
)