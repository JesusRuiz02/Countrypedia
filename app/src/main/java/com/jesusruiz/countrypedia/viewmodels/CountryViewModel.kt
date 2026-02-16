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

sealed class CountryInputAction{
    data class CountriesChanged(val value: List<String>) : CountryInputAction()
    object ClearCountry: CountryInputAction()
}

data class CountriesState(
    val countriesList: List<CountryModel> = listOf(),
    val stringCountriesList: List<String> = listOf(),
    val filterCountriesList: List<CountryModel> = listOf(),
    val country: CountryModel = CountryModel(),
    val countryUI: UI_STATE = UI_STATE.LOADING
)
@HiltViewModel
class CountryViewModel @Inject constructor(
    private val countryRepository: CountryRepository
) : ViewModel() {
    private val _countryDataState = mutableStateOf(CountriesState())

    val countryDataState : State<CountriesState> = _countryDataState

    fun onAction(action: CountryInputAction){
        when(action){
            is CountryInputAction.CountriesChanged ->{
                _countryDataState.value = _countryDataState.value.copy(stringCountriesList = action.value)
            }
            is CountryInputAction.ClearCountry ->
                _countryDataState.value = _countryDataState.value.copy(country = CountryModel())
        }
    }




    fun getLocalCountry(name: String){
        _countryDataState.value = _countryDataState.value.copy(countryUI = UI_STATE.LOADING)
        if (_countryDataState.value.countriesList.isNotEmpty()){
            val resultCountry = _countryDataState.value.countriesList.find { it.countryName == name }
            if (resultCountry != null){
                _countryDataState.value = _countryDataState.value.copy(country = resultCountry)
                _countryDataState.value = _countryDataState.value.copy(countryUI = UI_STATE.READY)
            }
            else{
                getCountryByName(name)
            }
        }
        else{
            getCountryByName(name)
        }
    }

    fun getCountryByName(name: String){
        onAction(CountryInputAction.ClearCountry)
        viewModelScope.launch(Dispatchers.IO) {
            val result = countryRepository.getCountryByName(name)
            when(result){
                is Result.Success -> {
                    val countryList: MutableList<CountryModel> = _countryDataState.value.countriesList.toMutableList()
                    countryList.add(result.data)
                    _countryDataState.value = _countryDataState.value.copy(country =  result.data, countryUI = UI_STATE.READY, countriesList = countryList)
                }
                is Result.Error -> {
                    _countryDataState.value = _countryDataState.value.copy(countryUI = UI_STATE.FAILED)

                }
            }
        }
    }
}