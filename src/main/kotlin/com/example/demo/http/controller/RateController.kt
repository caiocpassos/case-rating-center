package com.example.demo.http.controller

import com.example.demo.domain.usecase.AddRateUseCase
import com.example.demo.domain.usecase.GetMerchantAverageUseCase
import com.example.demo.domain.usecase.GetRatesByMerchantIdUseCase
import com.example.demo.http.converter.RateDtoToRateConverter
import com.example.demo.http.dto.RateDto
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
import javax.validation.Valid

@RestController
@RequestMapping("/rates")
class RateController(
    private val addRateUseCase: AddRateUseCase,
    private val getMerchantAverageUseCase: GetMerchantAverageUseCase,
    private val getRatesByMerchantIdUseCase: GetRatesByMerchantIdUseCase,
    private val rateDtoToRateConverter: RateDtoToRateConverter
) {

    @PostMapping
    suspend fun addRate(@Valid @RequestBody rating: RateDto) =
        addRateUseCase.add(rateDtoToRateConverter.convert(rating))

    @GetMapping("/{clientId}")
    suspend fun getRatesByClientIdUseCase(@PathVariable clientId: String) =
        getRatesByMerchantIdUseCase.getBy(clientId)

    @GetMapping("/media/{merchantId}")
    suspend fun getMerchantAverage(@PathVariable merchantId: String) =
        getMerchantAverageUseCase.getAverage(merchantId)
}