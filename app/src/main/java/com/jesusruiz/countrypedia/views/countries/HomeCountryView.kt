package com.jesusruiz.countrypedia.views.countries

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.navigation.NavController
import com.jesusruiz.countrypedia.R
import com.jesusruiz.countrypedia.models.CountryModel
import com.jesusruiz.countrypedia.viewmodels.CountryViewModel
import com.jesusruiz.countrypedia.viewmodels.UI_STATE

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun HomeCountryView(navController: NavController, countryViewModel: CountryViewModel){
    val state by countryViewModel.countryDataState
    LaunchedEffect(Unit) {
        countryViewModel.getCountries()
    }
    Scaffold(topBar = {
        TopAppBar(title = {
            Text(text = stringResource(R.string.countries_title_txt))},
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
        if (state.countryUI == UI_STATE.LOADING)
        {
            Box(
                Modifier
                    .fillMaxSize()
                    .padding(paddingValues)
            ) {
                CircularProgressIndicator(
                    modifier = Modifier.align(Alignment.Center),
                    color = MaterialTheme.colorScheme.secondary
                )
            }
        }
        else{
            LazyColumn(modifier = Modifier.padding(paddingValues)) {
                items(state.countriesList){
                        country ->
                    CountryItem(country.countryName) {
                        navController.navigate("Country/${country.countryName}")
                    }
                }
            }
        }

    }
}