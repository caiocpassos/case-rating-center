package com.example.demo.http.dto

import javax.validation.constraints.DecimalMax
import javax.validation.constraints.DecimalMin
import javax.validation.constraints.NotEmpty
import javax.validation.constraints.NotNull

data class RateDto(

    @field:NotEmpty
    @field:NotNull
    val orderId: String,

    @field:NotEmpty
    @field:NotNull
    val clientId: String,

    @field:NotEmpty
    @field:NotNull
    val merchantId: String,

    @field:DecimalMax("5.0")
    @field:DecimalMin("1.0")
    val rateValue: Double? = null
)