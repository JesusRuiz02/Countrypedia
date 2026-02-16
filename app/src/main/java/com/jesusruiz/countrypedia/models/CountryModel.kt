package com.jesusruiz.countrypedia.models

data class CountryModel(
    val countryName: String = "",
    val population: Long = 0,
    val area: Double = 0.0,
    val region: String = "",
    val subRegion: String = "",
    val capital: String = "",
    val imageFlag: String = "",
    val vectorFlag: String = ""
)