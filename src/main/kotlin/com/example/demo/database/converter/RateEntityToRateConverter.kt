package com.example.demo.database.converter

import com.example.demo.database.model.RateEntity
import com.example.demo.domain.entity.Rate
import org.springframework.core.convert.converter.Converter
import org.springframework.stereotype.Component
import java.time.Instant

@Component
class RateEntityToRateConverter : Converter<RateEntity, Rate> {

    override fun convert(source: RateEntity): Rate {
        return Rate(
            merchantId = source.merchantId,
            clientId = source.clientId,
            orderId = source.orderId,
            value = source.value,
            createdAt = Instant.ofEpochMilli(source.createdAt)
        )
    }
}