package com.jesusruiz.countrypedia.data.repository

import com.jesusruiz.countrypedia.data.datsource.CountryRepository
import com.jesusruiz.countrypedia.models.CountryModel
import com.jesusruiz.countrypedia.utils.Result
import javax.inject.Inject


class LocalCountryRepository @Inject constructor() : CountryRepository {



    override suspend fun getCountryByName(countryName: String): Result<CountryModel> {
        val fakeCountryList = listOf(
            CountryModel("Argentina",21,31.212,"America","Sudamerica"),
            CountryModel("México", 2131231,1122123.21122, "America", "NorteAmerica"),
            CountryModel("Noruega", 2131231,214914194.1221, "Europa", "NorteEuropa"),

            )
        kotlinx.coroutines.delay(1000)
        return Result.Success(fakeCountryList[0])
    }

}