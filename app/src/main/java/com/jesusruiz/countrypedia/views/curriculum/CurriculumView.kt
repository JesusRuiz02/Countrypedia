package com.jesusruiz.countrypedia.views.curriculum

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.wrapContentWidth
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.jesusruiz.countrypedia.navigation.Screen
import com.jesusruiz.countrypedia.ui.theme.CountrypediaTheme
import com.jesusruiz.countrypedia.views.curriculum.education.EducationView
import com.jesusruiz.countrypedia.views.curriculum.jobExperience.ExperienceView

@Composable
fun CurriculumView(navController: NavController){
    val principalModifier = Modifier
    Column(horizontalAlignment = Alignment.CenterHorizontally,
        modifier = principalModifier
            .fillMaxSize()
            .verticalScroll(rememberScrollState())
    ) {
       HeaderView(modifier = principalModifier.wrapContentWidth())
        EducationView(modifier = principalModifier)
        ExperienceView(principalModifier)
        Button(onClick = {
            navController.navigate(Screen.CountryHomeView.route)
        }) {
            Text(text = "Countrypedia")
        }
    }
}


@Preview(showBackground = true)
@Composable

fun CurriculumPreview() {
    CountrypediaTheme {
        CurriculumView(navController = rememberNavController())
    }
}