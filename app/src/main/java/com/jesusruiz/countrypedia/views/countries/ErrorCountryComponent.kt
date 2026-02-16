package com.jesusruiz.countrypedia.views.countries

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Button
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.jesusruiz.countrypedia.R
import com.jesusruiz.countrypedia.ui.theme.CountrypediaTheme

@Composable
fun ErrorCountryComponent(modifier: Modifier = Modifier, onClick: () -> Unit){
    Row(verticalAlignment = Alignment.CenterVertically, modifier = modifier.fillMaxSize()) {
        Column(horizontalAlignment = Alignment.CenterHorizontally, verticalArrangement = Arrangement.spacedBy(30.dp)) {
            Icon(modifier = Modifier.size(200.dp),painter = painterResource(R.drawable.ic_sadface),
                contentDescription = null)
            Button(modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 20.dp),onClick = { onClick()}) {
                Text(text = stringResource(R.string.try_again_txt), style = MaterialTheme.typography.titleMedium)

            }
        }

    }
}

@Preview(showBackground = true)
@Composable
fun EducationItemCurriculumPreview() {
    CountrypediaTheme {
        ErrorCountryComponent(onClick = {

        })
    }
}

