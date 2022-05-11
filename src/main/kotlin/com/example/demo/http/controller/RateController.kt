package com.example.demo.http.controller

import com.example.demo.domain.entity.Rate
import com.example.demo.domain.usecase.rating.AddRateUseCase
import com.example.demo.domain.usecase.rating.GetAllRatesUseCase
import com.example.demo.domain.usecase.rating.GetMerchantAverageUseCase
import com.example.demo.http.converter.RateDtoToRatingConverter
import com.example.demo.http.dto.RateDto
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/rates")
class RateController(
    private val addRateUseCase: AddRateUseCase,
    private val getAllRatesUseCase: GetAllRatesUseCase,
    private val getMerchantAverageUseCase: GetMerchantAverageUseCase,
    private val rateDtoToRatingConverter: RateDtoToRatingConverter
) {

    @PostMapping
    fun addRate(@RequestBody rating: RateDto) =
        addRateUseCase.add(rateDtoToRatingConverter.convert(rating))

    @GetMapping
    fun getAllRates() = getAllRatesUseCase.getAll()

    @GetMapping("/media/{merchantId}")
    fun getMerchantAverage(@PathVariable merchantId: String) = getMerchantAverageUseCase.getAverage(merchantId)
}