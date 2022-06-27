package com.example.demo.http.converter

import com.example.demo.domain.entity.Rate
import com.example.demo.http.dto.RateDto
import org.springframework.core.convert.converter.Converter
import org.springframework.stereotype.Component

@Component
class RateDtoToRateConverter : Converter<RateDto, Rate> {
    override fun convert(source: RateDto) = Rate(
        orderId = source.orderId!!,
        clientId = source.clientId!!,
        merchantId = source.merchantId!!,
        value = source.rateValue
    )

}