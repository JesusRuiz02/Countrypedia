package com.jesusruiz.countrypedia.views.countries

import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringArrayResource
import androidx.compose.ui.res.stringResource
import androidx.navigation.NavController
import com.jesusruiz.countrypedia.R
import com.jesusruiz.countrypedia.viewmodels.CountryInputAction
import com.jesusruiz.countrypedia.viewmodels.CountryViewModel

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun HomeCountryView(navController: NavController, countryViewModel: CountryViewModel){
    val state by countryViewModel.countryDataState
    val countriesArray = stringArrayResource(id = R.array.countries_array)
    val countriesList = countriesArray.toList()
    LaunchedEffect(Unit) {
        countryViewModel.onAction(CountryInputAction.CountriesChanged(countriesList))
    }
    Scaffold(topBar = {
        TopAppBar(title = {
            Text(text = stringResource( R.string.countries_title_txt))},
            navigationIcon = {
                IconButton(onClick = {
                    navController.popBackStack()
                }){
                    Icon(imageVector = Icons.AutoMirrored.Filled.ArrowBack,
                        contentDescription = "")
                }
            })
    }){
        paddingValues ->
            LazyColumn(modifier = Modifier.padding(paddingValues)) {
                items(state.stringCountriesList){
                        country ->
                    CountryItem(country, onClick = {
                        navController.navigate("Country/${country}")
                    })
                }
            }

    }
}