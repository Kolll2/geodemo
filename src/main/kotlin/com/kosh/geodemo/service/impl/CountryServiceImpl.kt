package com.kosh.geodemo.service.impl

import com.kosh.geodemo.dto.CountryDto
import com.kosh.geodemo.service.CountryService
import org.springframework.stereotype.Service

@Service
class CountryServiceImpl : CountryService {
    override fun getAll(): List<CountryDto> {
        return listOf(
                CountryDto(1, "Germany", 1_000_000),
                CountryDto(2, "Russia", 1_000_000)
        )
    }
}