package com.example.demo.database.config

import com.example.demo.database.model.RateEntity
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import software.amazon.awssdk.auth.credentials.DefaultCredentialsProvider
import software.amazon.awssdk.enhanced.dynamodb.DynamoDbEnhancedAsyncClient
import software.amazon.awssdk.enhanced.dynamodb.TableSchema
import software.amazon.awssdk.services.dynamodb.DynamoDbAsyncClient
import java.net.URI

@Configuration
class DynamoDBConfig {

    @Bean
    fun getLocalDynamoDbAsyncClient(): DynamoDbAsyncClient {
        return DynamoDbAsyncClient.builder()
            .credentialsProvider(DefaultCredentialsProvider.create())
            .endpointOverride(URI.create("http://localhost:4566/000000000000/table"))
            .build()
    }

    @Bean
    fun getLocalDynamoDbEnhancedAsyncClient() = DynamoDbEnhancedAsyncClient.builder()
        .dynamoDbClient(getLocalDynamoDbAsyncClient())
        .build()

    @Bean
    fun rateDynamoDbAsyncTable(enhancedAsyncClient: DynamoDbEnhancedAsyncClient) = enhancedAsyncClient.table(
        "Rate",
        TableSchema.fromBean(RateEntity::class.java)
    )
}