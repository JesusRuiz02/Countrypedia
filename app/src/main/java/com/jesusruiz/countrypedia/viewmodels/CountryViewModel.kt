package com.jesusruiz.countrypedia.viewmodels

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.jesusruiz.countrypedia.data.datsource.CountryRepository
import com.jesusruiz.countrypedia.models.CountryModel
import com.jesusruiz.countrypedia.utils.Result
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject

enum class UI_STATE{
    LOADING,
    FAILED,
    READY
}

data class CountriesState(
    val countriesList: List<CountryModel> = listOf(),
    val country: CountryModel = CountryModel(),
    val countryUI: UI_STATE = UI_STATE.READY
)
@HiltViewModel
class CountryViewModel @Inject constructor(
    private val countryRepository: CountryRepository
) : ViewModel() {
    private val _countryDataState = mutableStateOf(CountriesState())

    val countryDataState : State<CountriesState> = _countryDataState

    fun getCountries(){
        viewModelScope.launch(Dispatchers.IO) {
           _countryDataState.value = _countryDataState.value.copy(countryUI = UI_STATE.LOADING)
           val result = countryRepository.getCountries()
            when(result){
                is Result.Success -> {
                    _countryDataState.value = _countryDataState.value.copy(countriesList = result.data, countryUI = UI_STATE.READY)
                }
                is Result.Error -> {
                    _countryDataState.value = _countryDataState.value.copy(countryUI = UI_STATE.FAILED)
                }
            }
        }
    }


    fun getCountryByName(name: String){
        val resultCountry = _countryDataState.value.countriesList.find { it.countryName == name }
        _countryDataState.value = _countryDataState.value.copy(country = resultCountry!!) }
}