package com.jesusruiz.countrypedia.views.countries

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material3.Card
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
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import coil3.compose.AsyncImage
import com.jesusruiz.countrypedia.R
import com.jesusruiz.countrypedia.ui.theme.CountrypediaTheme
import com.jesusruiz.countrypedia.viewmodels.CountryViewModel
import com.jesusruiz.countrypedia.viewmodels.UI_STATE
import com.jesusruiz.countrypedia.views.ShimmerListItem

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun CountryView(navController: NavController, country: String,countryViewModel: CountryViewModel){
    val state by countryViewModel.countryDataState
    LaunchedEffect(Unit){
        countryViewModel.getLocalCountry(country)
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
        if(state.countryUI == UI_STATE.FAILED){
            ErrorCountryComponent(modifier = Modifier.padding(paddingValues)) {
                countryViewModel.getCountryByName(country)
            }
        }
        else{
            ShimmerListItem(modifier = Modifier.padding(paddingValues), isLoading = state.countryUI == UI_STATE.LOADING,
                contentAfterLoading = {
                    Column(Modifier.padding(paddingValues)) {
                        if (state.country.countryName.isNotEmpty()){
                            AsyncImage(
                                model = state.country.imageFlag,
                                contentDescription = "Flag: $country",
                                modifier = Modifier
                                    .fillMaxWidth()
                                    .aspectRatio(1.5f)
                                    .clip(RoundedCornerShape(4.dp))
                                    .padding(20.dp)
                                ,
                                contentScale = ContentScale.Crop,
                                placeholder = painterResource(R.drawable.ic_flag),
                                error = painterResource(R.drawable.ic_flag)
                            )
                        }
                        Card(modifier = Modifier
                            .fillMaxWidth()
                            .padding(10.dp)) {
                            Column(verticalArrangement = Arrangement.spacedBy(10.dp),
                                modifier = Modifier.padding(10.dp)) {
                                CountryInfoRow(stringResource(R.string.capital_txt) +": ", state.country.capital)
                                CountryInfoRow(stringResource(R.string.population_txt), state.country.population.toString())
                                CountryInfoRow(stringResource(R.string.area_txt), state.country.area.toString())
                                CountryInfoRow(stringResource(R.string.region_txt), state.country.region)
                                CountryInfoRow(stringResource(R.string.subregion_txt), state.country.subRegion)
                            }

                        }
                    }
                }
            )
        }

    }

}

@Composable
fun CountryInfoRow(label: String, value: String) {
    Row(modifier = Modifier.fillMaxWidth()) {
        Text(text = "$label: ", fontWeight = FontWeight.Bold)
        Text(text = value)
    }
}
@Preview(showBackground = true)
@Composable
fun CountryPreview() {
    CountrypediaTheme {
    }
}