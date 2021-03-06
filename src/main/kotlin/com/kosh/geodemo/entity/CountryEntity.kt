package com.kosh.geodemo.entity

import javax.persistence.*

@Entity
@Table(name = "country")
class CountryEntity(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Int = 0,
    val name: String = "",
    val population: Long = 0,
)