package com.example.demo.database.model

import software.amazon.awssdk.enhanced.dynamodb.mapper.annotations.DynamoDbAttribute
import software.amazon.awssdk.enhanced.dynamodb.mapper.annotations.DynamoDbBean
import software.amazon.awssdk.enhanced.dynamodb.mapper.annotations.DynamoDbPartitionKey
import software.amazon.awssdk.enhanced.dynamodb.mapper.annotations.DynamoDbSortKey

@DynamoDbBean
data class RateEntity(
    @get:DynamoDbPartitionKey
    @get:DynamoDbAttribute("merchantId")
    var merchantId: String,

    @get:DynamoDbSortKey
    @get:DynamoDbAttribute("createdAt")
    var createdAt: Long,

    @get:DynamoDbAttribute("orderId")
    var orderId: String,

    @get:DynamoDbAttribute("clientId")
    var clientId: String,

    @get:DynamoDbAttribute("value")
    var value: Int
)