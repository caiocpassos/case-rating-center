package com.example.demo.domain.usecase

import com.example.demo.domain.adapter.RateRepository
import com.example.demo.domain.entity.Average
import com.example.demo.domain.entity.Rate
import io.mockk.coEvery
import io.mockk.coVerify
import io.mockk.every
import io.mockk.impl.annotations.InjectMockKs
import io.mockk.impl.annotations.MockK
import io.mockk.junit5.MockKExtension
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.test.runBlockingTest
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertDoesNotThrow
import org.junit.jupiter.api.extension.ExtendWith
import java.util.UUID

@Suppress("DEPRECATION")
@ExtendWith(MockKExtension::class)
internal class GetMerchantAverageUseCaseTest {

    @MockK
    private lateinit var rateRepository: RateRepository

    @InjectMockKs
    private lateinit var sut: GetMerchantAverageUseCase

    @Test
    @ExperimentalCoroutinesApi
    fun `Should call rateRepository getMerchantAverage method with the correct parameters`(): Unit = runBlockingTest {
        val merchantId = "1f772f9245da09f0e28abb87bb29f309649322f8"

        val average = Average(
            merchantId = merchantId,
            rateQuantity = 1,
            average = 3.9
        )

        coEvery {
            rateRepository.getMerchantAverage(average.merchantId)
        } returns average

        assertDoesNotThrow {
            sut.getAverage(merchantId)
        }
    }
}