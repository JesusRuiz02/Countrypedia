package com.jesusruiz.countrypedia.views.curriculum.jobExperience

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.core.tween
import androidx.compose.animation.fadeIn
import androidx.compose.animation.fadeOut
import androidx.compose.animation.slideInVertically
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import com.jesusruiz.countrypedia.R
import com.jesusruiz.countrypedia.views.curriculum.DescriptionItem

@Composable
fun ExperienceItem(modifier: Modifier = Modifier, jobTitle: String = "Work", jobDescription: List<String>, date: String = "2025-2026", initialValue: Boolean = true  ){
    val visible = remember { mutableStateOf(initialValue) }
    val iconView = if(visible.value){ painterResource(R.drawable.ic_arrow_up) } else{ painterResource(R.drawable.ic_arrow_down)}
    Column(modifier = modifier
        .fillMaxWidth()
        .padding(horizontal = 10.dp)) {
        Row(
            modifier = Modifier
                .padding(horizontal = 5.dp)
                .fillMaxWidth()
                .clickable{
                    visible.value = !visible.value
                }, verticalAlignment = Alignment.CenterVertically
        ) {
            Icon(painter = iconView,
                modifier = Modifier.size(20.dp),
                tint = MaterialTheme.colorScheme.primary,
                contentDescription = null)
            Spacer(modifier = Modifier.width(8.dp))
            Text(
                maxLines = 1,
                overflow = TextOverflow.Ellipsis,
                text = jobTitle,
                style = MaterialTheme.typography.titleSmall,
                fontWeight = FontWeight.Bold,
                color = MaterialTheme.colorScheme.primary
            )
            Spacer(modifier = Modifier.weight(1f))
            Text(
                text = date,
                style = MaterialTheme.typography.titleSmall,
                color = Color.Gray
            )
        }
        AnimatedVisibility(
            visible = visible.value,
            enter = fadeIn() + slideInVertically(initialOffsetY = { it }),
            exit = fadeOut(
                animationSpec = tween(durationMillis = 500)
            )
        ){
            Column() {
                jobDescription.forEach {
                        description -> DescriptionItem(description = description, modifier = Modifier.padding(vertical = 5.dp))
                }
            }

        }

    }
}

