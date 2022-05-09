package com.example.demo.http.dto

import java.util.UUID

data class OrderForm(
    val clientId: UUID,
    val merchantId: UUID
)