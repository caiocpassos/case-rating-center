package com.example.demo.http.dto

import org.springframework.lang.NonNullFields
import java.time.LocalDateTime


data class ErrorView(
    val timestamp: LocalDateTime = LocalDateTime.now(),
    val status: Int,
    val error: String,
    val message: String? = null,
    val path: String,
    val messageList: Map<String, String?>? = null
)