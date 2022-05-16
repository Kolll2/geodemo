package com.kosh.geodemo.service.impl

import com.kosh.geodemo.dto.CountryDto
import com.kosh.geodemo.entity.CountryEntity
import com.kosh.geodemo.repository.CountryRepository
import com.kosh.geodemo.service.CountryService
import org.springframework.data.domain.PageRequest
import org.springframework.data.repository.findByIdOrNull
import org.springframework.stereotype.Service

private const val LOAD_PAGE_SIZE = 10

@Service
class CountryServiceImpl(
    private val countryRepository: CountryRepository,
) : CountryService {
    override fun getOrderByNamePage(): List<CountryDto> {
        return countryRepository.findByOrderByName()
            .map { it.toDto() }
    }

    override fun getOrderByNamePage(page: Int): List<CountryDto> {
        if (page == -1) return getOrderByNamePage()
        return countryRepository.findByOrderByName(PageRequest.of(page, LOAD_PAGE_SIZE))
            .map { it.toDto() }
    }

    override fun getById(id: Int): CountryDto =
        countryRepository.findByIdOrNull(id)
            ?.toDto()
            ?: throw RuntimeException("Country not found")

    override fun search(prefix: String): List<CountryDto> =
        countryRepository.findByNameStartsWithIgnoreCaseOrderByName(prefix)
            .map { it.toDto() }

    private fun CountryEntity.toDto(): CountryDto =
        CountryDto(
            id = this.id,
            name = this.name,
            population = this.population,
        )
}