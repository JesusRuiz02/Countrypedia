package com.jesusruiz.countrypedia.views.curriculum.jobExperience

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.jesusruiz.countrypedia.ui.theme.CountrypediaTheme
import com.jesusruiz.countrypedia.views.curriculum.DescriptionItem

@Composable
fun ExperienceItem(modifier: Modifier = Modifier, jobTitle: String = "Trabajo", jobDescription: List<String>, date: String = "2025-2026"  ){
    Column(modifier = modifier
        .fillMaxWidth()
        .padding(horizontal = 10.dp)) {
        Row(
            modifier = Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.SpaceBetween
        ) {
            Text(
                text = jobTitle,
                style = MaterialTheme.typography.titleSmall,
                fontWeight = FontWeight.Bold
            )
            Text(
                text = date,
                style = MaterialTheme.typography.titleSmall,
                color = Color.Gray
            )
        }
        jobDescription.forEach {
            description -> DescriptionItem(description = description, modifier = Modifier.padding(vertical = 5.dp))
        }
    }
}

