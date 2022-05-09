package com.kosh.geodemo.controller

import com.kosh.geodemo.dto.CountryDto
import com.kosh.geodemo.service.CountryService
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/countries")
class CountryController (
        private val countryService: CountryService,
) {


    @GetMapping
    fun getAll() : List<CountryDto> = countryService.getAll()

}