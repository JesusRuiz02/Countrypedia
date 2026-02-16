package com.jesusruiz.countrypedia.data.remote

import retrofit2.http.GET
import retrofit2.http.Path

interface CountryApi {


    @GET("v3.1/name/{countryName}?fields=name,capital,population,area,region,subregion,flags")
    suspend fun getCountryByName(@Path("countryName") name: String): List<CountryDto>
}