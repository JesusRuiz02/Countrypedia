package com.jesusruiz.countrypedia.navigation

import androidx.compose.animation.core.tween
import androidx.compose.animation.fadeOut
import androidx.compose.animation.slideInHorizontally
import androidx.compose.animation.slideOutHorizontally
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.hilt.lifecycle.viewmodel.compose.hiltViewModel
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
                backStackEntry ->
                val parentEntry = remember(backStackEntry){
                    navController.getBackStackEntry("countries_graph")
                }
                val countryViewModel: CountryViewModel = hiltViewModel(parentEntry)
                HomeCountryView(navController, countryViewModel)
            }
            composable(Screen.CountryView.route,
                arguments = listOf(navArgument("countryName"){type = NavType.StringType}),
                enterTransition = { slideInHorizontally(initialOffsetX = { 1000 }) },
                popExitTransition = { slideOutHorizontally(targetOffsetX = {it},
                    animationSpec = tween(durationMillis = 250)
                ) + fadeOut(animationSpec = tween(durationMillis = 250))
                }
            ) {
                        backstackEntry ->
                val parentEntry = remember(backstackEntry){
                    navController.getBackStackEntry("countries_graph")
                }
                val countryViewModel: CountryViewModel = hiltViewModel(parentEntry)
                val countryName = backstackEntry.arguments?.getString("countryName")?: ""
                CountryView(navController = navController, country = countryName, countryViewModel = countryViewModel )
            }
        }


    }
}