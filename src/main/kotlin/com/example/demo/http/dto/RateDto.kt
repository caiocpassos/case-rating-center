package com.example.demo.http.dto

import javax.validation.constraints.Max
import javax.validation.constraints.Min
import javax.validation.constraints.NotEmpty
import javax.validation.constraints.NotNull

data class RateDto(

    @field:NotEmpty(message = "Order ID can't be empty")
    @field:NotNull(message = "Order ID can't be null")
    val orderId: String?,

    @field:NotEmpty(message = "Client ID can't be empty")
    @field:NotNull(message = "Client ID can't be null")
    val clientId: String?,

    @field:NotEmpty(message = "Merchant ID can't be empty")
    @field:NotNull(message = "Merchant ID can't be null")
    val merchantId: String?,

    @field:Max(5, message = "Max value of rate is 5")
    @field:Min(1, message = "Min value of rate is 1")
    val rateValue: Int
)