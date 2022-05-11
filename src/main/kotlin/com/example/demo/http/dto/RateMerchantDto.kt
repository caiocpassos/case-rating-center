package com.example.demo.http.dto

data class RateMerchantDto(
    val merchantId: String,
    val rateValue: Double? = null
)