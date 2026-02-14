package com.jesusruiz.countrypedia.data.datsource

import com.jesusruiz.countrypedia.models.CountryModel
import com.jesusruiz.countrypedia.utils.Result

interface CountryRepository {

    suspend fun getCountries(): Result<List<CountryModel>>


}