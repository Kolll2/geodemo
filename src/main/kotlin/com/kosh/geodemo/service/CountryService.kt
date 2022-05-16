package com.kosh.geodemo.service

import com.kosh.geodemo.dto.CountryDto

interface CountryService {
    fun getOrderByNamePage(): List<CountryDto>
    fun getOrderByNamePage(page: Int): List<CountryDto>
}