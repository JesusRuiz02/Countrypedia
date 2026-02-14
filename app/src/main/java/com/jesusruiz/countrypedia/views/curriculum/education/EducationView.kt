package com.jesusruiz.countrypedia.views.curriculum


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
        
    }
}

@Preview(showBackground = true)
@Composable
fun EducationCurriculumPreview() {
    CountrypediaTheme {
        EducationView()
    }
}