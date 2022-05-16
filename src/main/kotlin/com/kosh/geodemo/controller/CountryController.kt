package com.kosh.geodemo.controller

import com.kosh.geodemo.dto.CountryDto
import com.kosh.geodemo.service.CountryService
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/countries")
class CountryController(
    private val countryService: CountryService,
) {

    @GetMapping
    fun getAll(@RequestParam(defaultValue = "-1") page: Int): List<CountryDto> = countryService.getOrderByNamePage(page)

    @GetMapping("/{id}")
    fun getById(@PathVariable("id") id: Int): CountryDto =
        countryService.getById(id)

    @GetMapping("/search")
    fun searchCountry(@RequestParam("prefix") prefix: String): List<CountryDto> = countryService.search(prefix)
}