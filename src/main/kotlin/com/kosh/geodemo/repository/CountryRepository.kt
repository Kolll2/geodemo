package com.kosh.geodemo.repository

import com.kosh.geodemo.entity.CountryEntity
import org.springframework.data.domain.Pageable
import org.springframework.data.repository.CrudRepository

interface CountryRepository : CrudRepository<CountryEntity, Int> {

    fun findByOrderByName(): List<CountryEntity>
    fun findByOrderByName(pageable: Pageable): List<CountryEntity>
}