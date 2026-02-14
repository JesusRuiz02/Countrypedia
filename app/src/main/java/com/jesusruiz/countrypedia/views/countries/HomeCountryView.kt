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
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.navigation.NavController
import com.jesusruiz.countrypedia.R
import com.jesusruiz.countrypedia.models.CountryModel
import com.jesusruiz.countrypedia.viewmodels.CountryViewModel

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun HomeCountryView(navController: NavController, countryViewModel: CountryViewModel){
    val templateCountries: List<CountryModel> = listOf(
        CountryModel("Argentina"),
        CountryModel("México")
    )
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
        LazyColumn(modifier = Modifier.padding(paddingValues)) {
            items(templateCountries){
                country ->
                CountryItem(country.countryName) {
                    navController.navigate("Country/${country.countryName}")
                }
            }
        }
    }
}