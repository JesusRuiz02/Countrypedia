package com.jesusruiz.countrypedia.views.curriculum

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.jesusruiz.countrypedia.R
import com.jesusruiz.countrypedia.ui.theme.CountrypediaTheme

@Composable
fun CurriculumView(){
    Column(horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier
            .fillMaxSize()
            .verticalScroll(rememberScrollState())
    ) {
        Image(modifier = Modifier
            .height(200.dp)
            .width(200.dp)
            .padding(top = 50.dp, bottom = 20.dp)
            .clip(CircleShape),
            painter = painterResource(id = R.drawable.profile_picture ),
            contentDescription = "Profile Picture",
        )
        Text( text = stringResource(R.string.name_home_txt), style = MaterialTheme.typography.titleLarge, modifier = Modifier.padding(horizontal = 10.dp))

        Spacer(modifier = Modifier.height(20.dp))

        Text()

    }
}


@Preview(showBackground = true)
@Composable
fun CurriculumPreview() {
    CountrypediaTheme {
        CurriculumView()
    }
}