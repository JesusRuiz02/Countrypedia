package com.jesusruiz.countrypedia.views.curriculum.education


import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

import com.jesusruiz.countrypedia.ui.theme.CountrypediaTheme

@Composable
fun EducationView(modifier: Modifier = Modifier){
    Column(modifier = modifier) {
        Text("Educación",
            modifier = Modifier.padding(vertical = 10.dp),
            style = MaterialTheme.typography.titleMedium)
        EducationItem(modifier = Modifier.padding(vertical = 5.dp),title = "Diplomado en diseño y programación de apps",
            date = "2024-2025", description = "Por la universidad Anahuac")
        EducationItem(modifier = Modifier.padding(vertical = 5.dp),title = "Ing. en desarrrollo de software interactivos",
            date = "2020-2024", description = "Por la universidad Amerike, egresado con promedio de 9.6")
        EducationItem(modifier = Modifier.padding(vertical = 5.dp),title = "Unreal Echo Training By Amber México",
            date = "2021-2022", description = "Unreal Engine Course")
    }
}

@Preview(showBackground = true)
@Composable
fun EducationCurriculumPreview() {
    CountrypediaTheme {
        EducationView()
    }
}