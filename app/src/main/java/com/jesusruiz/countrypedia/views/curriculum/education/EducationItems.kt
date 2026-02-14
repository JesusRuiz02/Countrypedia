package com.jesusruiz.countrypedia.views.curriculum.education

import androidx.compose.material.icons.Icons
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.icons.filled.Circle
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.jesusruiz.countrypedia.ui.theme.CountrypediaTheme
import com.jesusruiz.countrypedia.views.curriculum.DescriptionItem

@Composable
fun EducationItem(modifier: Modifier = Modifier, title: String = "Universidad", date: String = "2022-2025", description: String = "Anahuac"){
    Column(modifier = modifier
        .fillMaxWidth()
        .padding(horizontal = 10.dp)) {
        Row(modifier = Modifier.fillMaxWidth()
            ,horizontalArrangement = Arrangement.SpaceBetween) {
            Text(text = title,
                style = MaterialTheme.typography.titleSmall,
                fontWeight = FontWeight.Bold)
            Text(text = date,
                style = MaterialTheme.typography.titleSmall,
                color = Color.Gray
            )
        }
        DescriptionItem(description = description)

    }
}

@Preview(showBackground = true)
@Composable
fun EducationItemCurriculumPreview() {
    CountrypediaTheme {
        EducationItem()
    }
}