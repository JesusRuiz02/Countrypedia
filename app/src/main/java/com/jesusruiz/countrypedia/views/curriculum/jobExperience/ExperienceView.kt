package com.jesusruiz.countrypedia.views.curriculum.jobExperience

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
import androidx.compose.ui.unit.dp
import com.jesusruiz.countrypedia.R

@Composable
fun ExperienceView(modifier: Modifier = Modifier){

    ElevatedCard (modifier = modifier
        .fillMaxWidth()
        .padding(vertical = 12.dp),
        shape = RoundedCornerShape(16.dp),
        colors = CardDefaults.cardColors(
            containerColor = MaterialTheme.colorScheme.surface
        )) {
        Column(modifier = modifier.padding(10.dp)) {
            Row(verticalAlignment = Alignment.CenterVertically) {
                Text(
                    stringResource(R.string.relevante_experiences_txt),
                    modifier = Modifier.padding(vertical = 10.dp, horizontal = 10.dp),
                    style = MaterialTheme.typography.titleMedium)
                Icon(painter = painterResource(R.drawable.ic_work),
                    contentDescription = null)
            }

            Box(modifier
                .fillMaxWidth()
                .height(1.5.dp)
                .background(Color.DarkGray))
            val megacableExperience: List<String> = listOf(
                stringResource(R.string.mega_experience_1),
                stringResource(R.string.mega_experience_2),
                stringResource(R.string.mega_experience3)
            )
            val smartWashExperience: List<String> = listOf(
                stringResource(R.string.smart_experience_1),
                stringResource(R.string.smart_experience_2),
                stringResource(R.string.smart_wash_experience_3),
                stringResource(R.string.smartwash_experience_3)

            )
            val noteAppExperience: List<String> = listOf(
                stringResource(R.string.note_experience_1),
                stringResource(R.string.note_experience2)
            )
            val gameAppExperience: List<String> = listOf(
                stringResource(R.string.sdk_google_play_services_implementation_txt),
                stringResource(R.string.programming_and_designing_gameplay_txt),
                stringResource(R.string.responsible_for_the_game_s_publication_on_the_play_store_txt)
            )
            ExperienceItem(modifier = Modifier.padding(vertical = 5.dp), jobTitle = stringResource(R.string.Megacable_work),
                date = "may 2025 - now", jobDescription = megacableExperience )
            Box(modifier
                .fillMaxWidth()
                .height(1.5.dp)
                .background(Color.DarkGray))
            ExperienceItem(modifier = Modifier.padding(vertical = 5.dp), jobTitle = stringResource(R.string.laundry_schedule_manager_txt),
                date = "nov 2025 - en 2026", jobDescription = smartWashExperience )
            Box(modifier
                .fillMaxWidth()
                .height(1.5.dp)
                .background(Color.DarkGray))
            ExperienceItem(modifier = Modifier.padding(vertical = 5.dp), jobTitle = stringResource(R.string.jetpack_compose_app_note_txt),
                date = "sept 2025 - oct 2026", jobDescription = noteAppExperience )
            Box(modifier
                .fillMaxWidth()
                .height(1.5.dp)
                .background(Color.DarkGray))
            ExperienceItem(modifier = Modifier.padding(vertical = 5.dp), jobTitle = stringResource(R.string.hyper_casual_game_gun_run_published_on_playstore_txt),
                date = "", jobDescription = gameAppExperience )
        }
    }

}