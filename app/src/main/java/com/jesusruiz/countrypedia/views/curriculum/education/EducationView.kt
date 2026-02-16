package com.jesusruiz.countrypedia.views.curriculum.education


import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ElevatedCard
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.jesusruiz.countrypedia.R

import com.jesusruiz.countrypedia.ui.theme.CountrypediaTheme
import com.jesusruiz.countrypedia.views.curriculum.jobExperience.ExperienceItem

@Composable
fun EducationView(modifier: Modifier = Modifier){
    ElevatedCard (modifier = modifier
        .fillMaxWidth(),
        colors = CardDefaults.cardColors(
            containerColor = MaterialTheme.colorScheme.surface
        ),
        shape = RoundedCornerShape(16.dp)) {
        Column(modifier = modifier.padding(10.dp)) {
            Row(verticalAlignment = Alignment.CenterVertically) {
                Text(
                    stringResource(R.string.eduaction_txt),
                    modifier = Modifier.padding(vertical = 10.dp, horizontal = 10.dp),
                    style = MaterialTheme.typography.titleMedium)
                Icon(painter = painterResource(R.drawable.ic_school),
                    contentDescription = null)
            }

            Box(modifier
                .fillMaxWidth()
                .height(1.5.dp)
                .background(Color.DarkGray))
            ExperienceItem(modifier = Modifier.padding(vertical = 5.dp), jobTitle = stringResource(R.string.diploma_txt),
                date = "2024-2025", jobDescription = listOf(stringResource(R.string.anahuac_university_txt)))
            Box(modifier
                .fillMaxWidth()
                .height(1.5.dp)
                .background(Color.DarkGray))
            ExperienceItem(modifier = Modifier.padding(vertical = 5.dp), jobTitle = stringResource(R.string.career_txt),
                date = "2020-2024", jobDescription = listOf(stringResource(R.string.grad_grade_txt)) )
            Box(modifier
                .fillMaxWidth()
                .height(1.5.dp)
                .background(Color.DarkGray))
            ExperienceItem(modifier = Modifier.padding(vertical = 5.dp), jobTitle = stringResource(R.string.unreal_echo_training_by_amber_m_xico_txt),
                date = "2021-2022", jobDescription = listOf(stringResource(R.string.unreal_engine_course_txt)))
        }
    }

}

@Preview(showBackground = true)
@Composable
fun EducationCurriculumPreview() {
    CountrypediaTheme {
        EducationView()
    }
}