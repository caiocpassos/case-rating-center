package com.example.demo.http.dto

import java.util.UUID

data class OrderView(
    val orderId: UUID,
    val clientName: String,
    val clientId: UUID,
    val merchantName: String,
    val merchantUUID: UUID,
    val rate: Double?
)