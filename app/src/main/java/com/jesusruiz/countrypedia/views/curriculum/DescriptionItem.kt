package com.jesusruiz.countrypedia.views.curriculum

import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Circle
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@Composable
fun DescriptionItem(modifier: Modifier = Modifier, description: String = "description"){
    Row(modifier = modifier.fillMaxWidth(), verticalAlignment = Alignment.CenterVertically) {
        Icon(modifier = Modifier
            .size(20.dp)
            .padding(5.dp),
            imageVector = Icons.Default.Circle,
            contentDescription = "Linkedin Icon"
        )
        Text(text = description, modifier = Modifier.padding(horizontal = 5.dp))
    }

}