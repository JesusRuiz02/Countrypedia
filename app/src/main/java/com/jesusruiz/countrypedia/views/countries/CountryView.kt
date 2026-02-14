package com.jesusruiz.countrypedia.views.countries

import android.util.Log
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
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
import androidx.compose.ui.graphics.Color
import androidx.navigation.NavController
import com.jesusruiz.countrypedia.viewmodels.CountryViewModel

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun CountryView(navController: NavController, country: String,countryViewModel: CountryViewModel){
    val state by countryViewModel.countryDataState
    LaunchedEffect(Unit){
        countryViewModel.getCountryByName(country)
        Log.d("Country", state.country.toString())
    }
    LaunchedEffect(state.country.countryName) {
        Log.d("Country", state.country.toString())

    }
    Scaffold(topBar = {
        TopAppBar(title = {
            Text(text = country)},
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
        Column(Modifier.padding(paddingValues)) {
            Text(text = state.country.countryName)
            Text(text = "Name: ${state.country.population}")
            Text(text = "Name: ${state.country.area}")
            Text(text = "Name: ${state.country.region}")
            Text(text = "Name: ${state.country.subRegion}")
        }
    }

}