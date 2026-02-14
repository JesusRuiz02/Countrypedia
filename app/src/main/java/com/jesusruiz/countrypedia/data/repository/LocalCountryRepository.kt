package com.jesusruiz.countrypedia.data.repository

import com.jesusruiz.countrypedia.data.datsource.CountryRepository
import com.jesusruiz.countrypedia.models.CountryModel
import com.jesusruiz.countrypedia.utils.Result
import javax.inject.Inject

class LocalCountryRepository @Inject constructor() : CountryRepository {
    override suspend fun getCountries(): Result<List<CountryModel>> {
        val fakeCountryList = listOf(
            CountryModel("Argentina",21,31,"America","Sudamerica"),
            CountryModel("México", 2131231,11221233, "America", "NorteAmerica"),
            CountryModel("Noruega", 2131231,214914194, "Europa", "NorteEuropa"),

        )
        kotlinx.coroutines.delay(1000)
        return Result.Success(fakeCountryList)
    }
}