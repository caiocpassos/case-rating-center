package com.example.demo.database.repository

import com.example.demo.database.model.RateEntity
import com.example.demo.domain.adapter.RateRepository
import com.example.demo.domain.entity.Rate
import com.example.demo.domain.entity.RateAverage
import kotlinx.coroutines.future.await
import kotlinx.coroutines.runBlocking
import org.springframework.core.convert.ConversionService
import org.springframework.stereotype.Repository
import software.amazon.awssdk.enhanced.dynamodb.DynamoDbAsyncTable


@Repository
class DynamoDBRateOperations(
    private val dynamoDbRateTable: DynamoDbAsyncTable<RateEntity>,
    private val conversionService: ConversionService
) : RateRepository {

    override fun addRate(rate: Rate): Unit = runBlocking {
        val rateEntity = conversionService.convert(
            rate, RateEntity::class.java
        )

        dynamoDbRateTable.putItem(rateEntity).await()
    }

    override fun getAllRates(): MutableList<Rate> {
        TODO("Not yet implemented")
    }

    override suspend fun getRatesByMerchantId(merchantId: String): MutableList<Rate> {
        TODO("Not yet implemented")
    }

    override suspend fun getMerchantAverage(merchantId: String): RateAverage {
        TODO("Not yet implemented")
    }

}