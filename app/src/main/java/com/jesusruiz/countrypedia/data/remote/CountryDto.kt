package com.jesusruiz.countrypedia.data.remote

data class CountryDto(
    val name: NameDto,
    val flags: FlagsDto,
    val population: Long,
    val capital: List<String>?,
    val region: String,
    val area: Double,
    val subregion: String
)

data class NameDto(
    val common: String
)

data class FlagsDto(
    val png:String,
    val svg: String
)