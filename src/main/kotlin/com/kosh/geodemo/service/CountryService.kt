package com.kosh.geodemo.service

import com.kosh.geodemo.dto.CountryDto

interface CountryService {
    fun getAll(): List<CountryDto>
}