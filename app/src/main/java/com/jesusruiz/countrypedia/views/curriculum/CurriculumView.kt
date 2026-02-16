package com.jesusruiz.countrypedia.views.curriculum

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.core.tween
import androidx.compose.animation.fadeIn
import androidx.compose.animation.slideInHorizontally
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.jesusruiz.countrypedia.navigation.Screen
import com.jesusruiz.countrypedia.ui.theme.CountrypediaTheme
import com.jesusruiz.countrypedia.views.curriculum.education.EducationView
import com.jesusruiz.countrypedia.views.curriculum.jobExperience.ExperienceView

@Composable
fun CurriculumView(navController: NavController){
    val visible = remember { mutableStateOf(false) }
    val principalModifier = Modifier
    LaunchedEffect(Unit) { visible.value = true }
    Column(horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.spacedBy(12.dp),
            modifier = principalModifier
                .fillMaxSize()
                .verticalScroll(rememberScrollState())
                .padding(horizontal = 10.dp)
    ) {
        AnimatedVisibility(
            visible = visible.value,
            enter = fadeIn(animationSpec = tween(1500)) + slideInHorizontally()
        ) {
            HeaderView(modifier = Modifier.padding(top = 50.dp))
        }
        EducationView(modifier = principalModifier)
        ExperienceView(principalModifier)
        Button(modifier = Modifier
            .padding(horizontal = 20.dp, vertical = 10.dp).fillMaxWidth() ,
            colors = ButtonDefaults.buttonColors(containerColor = MaterialTheme.colorScheme.primary),
            onClick = {
            navController.navigate(Screen.CountryHomeView.route)
        }) {
            Text(text = "Countrypedia")
        }
        Spacer(modifier = Modifier
            .fillMaxWidth()
            .height(30.dp))
    }
}


@Preview(showBackground = true)
@Composable

fun CurriculumPreview() {
    CountrypediaTheme {
        CurriculumView(navController = rememberNavController())
    }
}