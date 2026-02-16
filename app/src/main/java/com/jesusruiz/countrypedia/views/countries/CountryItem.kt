package com.jesusruiz.countrypedia.views.countries

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.jesusruiz.countrypedia.ui.theme.CountrypediaTheme

@Composable
fun CountryItem(countryName: String, onClick : ()-> Unit){
        Card(modifier = Modifier
            .fillMaxWidth()
            .padding(10.dp)
            .clickable{
                onClick()
            },
            shape = RoundedCornerShape(topEnd = 10.dp, topStart = 10.dp, bottomEnd = 10.dp, bottomStart = 10.dp),
            colors = CardDefaults.cardColors(containerColor = MaterialTheme.colorScheme.primary)

        ) {
            Column(modifier = Modifier.padding(10.dp), horizontalAlignment = Alignment.CenterHorizontally ) {
                Text( text = countryName, color = Color.White, modifier = Modifier.fillMaxWidth().padding(horizontal = 16.dp), fontSize = 20.sp)
            }
        }
}

@Preview(showBackground = true)
@Composable
fun CountryItemPreview() {
    CountrypediaTheme {
       CountryItem(onClick = {}, countryName = "Argentina")
    }
}