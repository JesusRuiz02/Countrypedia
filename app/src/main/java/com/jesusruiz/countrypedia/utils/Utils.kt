package com.jesusruiz.countrypedia.utils

import com.jesusruiz.countrypedia.data.remote.CountryDto
import com.jesusruiz.countrypedia.models.CountryModel

fun CountryDto.toDomain(): CountryModel{
    return CountryModel(
        countryName = name.common,
        population = population,
        area = area,
        region = region,
        subRegion = subregion,
        imageFlag = flags.png,
        vectorFlag = flags.svg,
        capital = capital?.firstOrNull() ?: "No capital"
    )
}