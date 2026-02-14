package com.jesusruiz.countrypedia.models

data class CountryModel(
    val countryName: String = "",
    val population: Int = 0,
    val area: Int = 0,
    val region: String = "",
    val subRegion: String = ""
)