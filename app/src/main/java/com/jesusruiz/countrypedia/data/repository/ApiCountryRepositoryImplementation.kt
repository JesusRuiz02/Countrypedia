package com.jesusruiz.countrypedia.data.repository

import android.util.Log
import com.jesusruiz.countrypedia.data.datsource.CountryRepository
import com.jesusruiz.countrypedia.data.remote.CountryApi
import com.jesusruiz.countrypedia.models.CountryModel
import com.jesusruiz.countrypedia.utils.Result
import com.jesusruiz.countrypedia.utils.toDomain
import javax.inject.Inject

class ApiCountryRepositoryImplementation @Inject constructor(
    private val api: CountryApi
): CountryRepository {
    override suspend fun getCountryByName(countryName: String): Result<CountryModel> {
        return try{
            val response = api.getCountryByName(countryName)
            if(response.isNotEmpty()){
                val countryDto = response[0]
                Result.Success(countryDto.toDomain())
            }else{
                Result.Error("El response esta vacio")
            }
        }
        catch (e: Exception){
            Log.d("error", e.toString())
            Result.Error("Ha ocurrido un error con la API", e)
        }
    }

}