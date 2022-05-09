package com.example.demo.http.dto

import java.util.UUID

data class AverageView(
    val merchantId: UUID,
    val average: Double = 0.0
)