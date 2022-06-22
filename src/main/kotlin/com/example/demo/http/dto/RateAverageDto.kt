package com.example.demo.http.dto

import javax.validation.constraints.NotEmpty
import javax.validation.constraints.NotNull

data class RateAverageDto(
    @field:NotNull(message = "Merchant ID can't be null")
    @field:NotEmpty(message = "Merchant ID can't be empty")
    val merchantId: String,

    val rateValue: Double
)