package com.example.demo.database.model

import software.amazon.awssdk.enhanced.dynamodb.mapper.annotations.DynamoDbAttribute
import software.amazon.awssdk.enhanced.dynamodb.mapper.annotations.DynamoDbBean
import software.amazon.awssdk.enhanced.dynamodb.mapper.annotations.DynamoDbPartitionKey
import software.amazon.awssdk.enhanced.dynamodb.mapper.annotations.DynamoDbSortKey

@DynamoDbBean
data class AverageEntity(
    @get:DynamoDbPartitionKey
    @get:DynamoDbAttribute("merchantId")
    var merchantId: String,

    @get:DynamoDbSortKey
    @get:DynamoDbAttribute("lastUpdate")
    var lastUpdate: Long,

    @get:DynamoDbAttribute("rateQuantity")
    var rateQuantity: Long,

    @get:DynamoDbAttribute("average")
    var average: Double
) {
    companion object {
        fun getTableName() = "Average"
    }
}