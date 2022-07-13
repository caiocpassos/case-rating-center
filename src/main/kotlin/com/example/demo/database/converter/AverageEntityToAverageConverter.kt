package com.example.demo.database.converter

import com.example.demo.database.model.AverageEntity
import com.example.demo.domain.entity.Average
import org.springframework.core.convert.converter.Converter
import org.springframework.stereotype.Component
import java.time.Instant

@Component
class AverageEntityToAverageConverter : Converter<AverageEntity, Average>{
    override fun convert(source: AverageEntity): Average = Average(
        merchantId = source.merchantId,
        lastUpdate = Instant.ofEpochMilli(source.lastUpdate),
        rateQuantity = source.rateQuantity,
        average = source.average
    )
}