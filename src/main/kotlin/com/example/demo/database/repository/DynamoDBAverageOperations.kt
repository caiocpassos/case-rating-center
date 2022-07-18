package com.example.demo.database.repository

import com.example.demo.database.model.AverageEntity
import com.example.demo.domain.adapter.AverageRepository
import com.example.demo.domain.entity.Average
import com.example.demo.domain.entity.Rate
import kotlinx.coroutines.future.await
import kotlinx.coroutines.reactive.awaitLast
import org.springframework.core.convert.ConversionService
import org.springframework.stereotype.Repository
import software.amazon.awssdk.enhanced.dynamodb.DynamoDbAsyncTable
import software.amazon.awssdk.enhanced.dynamodb.Key
import software.amazon.awssdk.enhanced.dynamodb.model.QueryConditional
import java.time.Instant

@Repository
class DynamoDBAverageOperations(
    private val averageDbRateTable: DynamoDbAsyncTable<AverageEntity>,
    private val conversionService: ConversionService
) : AverageRepository {

    override suspend fun saveAverage(partitionKey: String, newRate: Rate) {
        val averageList = findAverage(partitionKey)

        if (averageList.isEmpty()) {
            createAverageByFirstRate(newRate)
            return
        }

        val retrievedAverage = averageList.first()

        val averageCalc =
            ((retrievedAverage.average * retrievedAverage.rateQuantity) + (newRate.value * 1)) / (retrievedAverage.rateQuantity + 1)

        val updatedAverage = retrievedAverage.copy(
            rateQuantity = retrievedAverage.rateQuantity + 1,
            average = averageCalc
        )
        averageDbRateTable.updateItem(updatedAverage).await()
    }

    override suspend fun getMerchantAverage(partitionKey: String): Average {
        val retrievedAverage = findAverage(partitionKey)

        return conversionService.convert(
            retrievedAverage, Average::class.java
        )!!
    }

    override suspend fun findAverage(partitionKey: String): List<AverageEntity> {
        val key = Key.builder().partitionValue(partitionKey).build()

        return averageDbRateTable
            .query(QueryConditional.keyEqualTo(key))
            .awaitLast()
            .items()

    }

    suspend fun createAverageByFirstRate(rate: Rate) {
        val averageEntity = AverageEntity(
            merchantId = rate.merchantId,
            lastUpdate = Instant.now().toEpochMilli(),
            rateQuantity = 1,
            average = rate.value.toDouble()
        )
        averageDbRateTable.putItem(averageEntity).await()
    }

}