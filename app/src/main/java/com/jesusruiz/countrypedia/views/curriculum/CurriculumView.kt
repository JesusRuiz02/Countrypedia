package com.jesusruiz.countrypedia.views.curriculum

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentWidth
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.jesusruiz.countrypedia.ui.theme.CountrypediaTheme
import com.jesusruiz.countrypedia.views.curriculum.education.EducationView

@Composable
fun CurriculumView(){
    Column(horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier
            .fillMaxSize()
            .verticalScroll(rememberScrollState())
    ) {
       HeaderView(modifier = Modifier.wrapContentWidth())
        EducationView()
        Spacer(modifier = Modifier.height(600.dp))

    }
}


@Preview(showBackground = true)
@Composable
fun CurriculumPreview() {
    CountrypediaTheme {
        CurriculumView()
    }
}