package com.example.demo.database.converter

import com.example.demo.database.model.RateEntity
import com.example.demo.domain.entity.Rate
import org.springframework.core.convert.converter.Converter
import org.springframework.stereotype.Component

@Component
class RateToRateEntityConverter : Converter<Rate, RateEntity>{

    override fun convert(source: Rate): RateEntity {
        return RateEntity(
            merchantId = source.merchantId,
            clientId = source.clientId,
            orderId = source.orderId,
            value = source.value,
            createdAt = source.createdAt.toEpochMilli()
        )
    }

}