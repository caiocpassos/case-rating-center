package com.example.demo.domain.usecase

import com.example.demo.domain.adapter.RateRepository
import com.example.demo.domain.entity.Rate
import io.mockk.coEvery
import io.mockk.coVerify
import io.mockk.every
import io.mockk.impl.annotations.InjectMockKs
import io.mockk.impl.annotations.MockK
import io.mockk.junit5.MockKExtension
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertDoesNotThrow
import org.junit.jupiter.api.assertThrows
import org.junit.jupiter.api.extension.ExtendWith
import java.util.UUID

@ExtendWith(MockKExtension::class)
internal class GetRatesByMerchantIdUseCaseTestc {

    @MockK
    private lateinit var rateRepository: RateRepository

    @InjectMockKs
    private lateinit var sut: GetRatesByMerchantIdUseCase

    @Test
    fun `Should call rateRepository GetRatesByMerchantId method with the correct parameters`() {
        val merchantId = "1f772f9245da09f0e28abb87bb29f309649322f8"
        val rateList: MutableList<Rate> = mutableListOf(
            Rate(
                orderId = "40bd001563085fc35165329ea1ff5c5ecbdbbeef",
                clientId = "61c1c54a79d253cbf93ae59067f3bc1be3bb52a1",
                merchantId = merchantId,
                value = 4
            )
        )

        every {
            rateRepository.getRatesByMerchantId(merchantId)
        } returns rateList

        assertDoesNotThrow {
            sut.getBy(merchantId)
        }
    }

}