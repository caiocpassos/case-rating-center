package com.example.demo.domain.adapter

import com.example.demo.database.model.AverageEntity
import com.example.demo.domain.entity.Average
import com.example.demo.domain.entity.Rate

interface AverageRepository {

    suspend fun saveAverage(partitionKey: String, newRate: Rate)

    suspend fun getMerchantAverage(partitionKey: String): Average

    suspend fun findAverage(partitionKey: String): List<AverageEntity>

}