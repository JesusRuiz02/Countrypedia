package com.jesusruiz.countrypedia.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import androidx.navigation.navigation
import com.jesusruiz.countrypedia.viewmodels.CountryViewModel
import com.jesusruiz.countrypedia.views.countries.CountryView
import com.jesusruiz.countrypedia.views.countries.HomeCountryView
import com.jesusruiz.countrypedia.views.curriculum.CurriculumView

sealed class Screen(val route: String){
    data object CurriculumView :Screen("Curriculum")
    data object CountryHomeView: Screen("CountriesHome")
    data object CountryView: Screen("Country/{countryName}"){
        fun createRoute(countryName: String) = "Country/${countryName}"
    }
}

@Composable
fun NavManager(){
    val navController = rememberNavController()
    NavHost(navController = navController, startDestination = Screen.CurriculumView.route){
        composable(Screen.CurriculumView.route) {
            CurriculumView(navController)
        }

        navigation(route = "countries_graph", startDestination = Screen.CountryHomeView.route){
            composable(Screen.CountryHomeView.route) {

                val countryViewModel: CountryViewModel = CountryViewModel()
                HomeCountryView(navController, countryViewModel)
            }
            composable(Screen.CountryView.route,
                arguments = listOf(navArgument("countryName"){type = NavType.StringType})
            ) {
                    backstackEntry ->
                val countryViewModel = CountryViewModel()
                val countryName = backstackEntry.arguments?.getString("countryName")?: ""
                CountryView(navController = navController, country = countryName, countryViewModel = countryViewModel )
            }
        }


    }
}