package com.jesusruiz.countrypedia.viewmodels

import android.util.Log
import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import com.jesusruiz.countrypedia.models.CountryModel

data class CountriesState(
    val countriesList: List<CountryModel> = listOf(
        CountryModel("Argentina",21,31,"affa","qeq"),
        CountryModel("México")
    ),
    val country: CountryModel = CountryModel()
)
class CountryViewModel: ViewModel() {
    private val _countryDataState = mutableStateOf(CountriesState())

    val countryDataState : State<CountriesState> = _countryDataState


    fun getCountryByName(name: String){
        val resultCountry = _countryDataState.value.countriesList.find { it.countryName == name }
        _countryDataState.value = _countryDataState.value.copy(country = resultCountry!!) }
}