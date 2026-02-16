package com.jesusruiz.countrypedia.views.curriculum

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ElevatedCard
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalUriHandler
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.jesusruiz.countrypedia.R
import com.jesusruiz.countrypedia.ui.theme.CountrypediaTheme


@Composable
fun HeaderView(modifier: Modifier = Modifier){
    val uriHandler = LocalUriHandler.current
    ElevatedCard (modifier = modifier
        .fillMaxWidth(),
        shape = RoundedCornerShape(16.dp),
        colors = CardDefaults.cardColors(
            containerColor = MaterialTheme.colorScheme.surface
        ) ) {
        Row(modifier = Modifier.fillMaxWidth()
            .padding(15.dp),
            verticalAlignment = Alignment.CenterVertically,) {
            Image(modifier = Modifier
                .height(110.dp)
                .width(80.dp),
                painter = painterResource(id = R.drawable.profile_picture ),
                contentDescription = null,
            )
            Spacer(modifier = Modifier.width(12.dp))
            Column(modifier = Modifier.weight(1f)) {
                Row(verticalAlignment = Alignment.CenterVertically,
                ){
                    Box(modifier = Modifier
                        .width(20.dp)
                        .height(1.5.dp)
                        .background(Color.LightGray))
                    Column(modifier = Modifier.padding(horizontal = 8.dp).weight(1f)) {
                        Text(text = "Android Engineer", style = MaterialTheme.typography.labelSmall  )
                        Text( text = stringResource(R.string.name_home_txt)
                            , style = MaterialTheme.typography.titleMedium
                            ,  fontWeight = FontWeight.Bold,
                            maxLines = 1)
                    }
                    Box(modifier = Modifier
                        .height(50.dp)
                        .width(1.5.dp)
                        .background(Color.LightGray))
                    Column(modifier = Modifier.padding(start = 8.dp)){
                        Text(text = "Contact Info", style = MaterialTheme.typography.labelSmall, fontWeight = FontWeight.Bold  )
                        Text( text = "jesruizman@gmail.com", style = TextStyle(fontSize = 9.sp), color = Color.Gray)
                        Text(text = "+526121586629", style = TextStyle(fontSize = 10.sp), color = Color.Gray)
                    }
                }
                Row(verticalAlignment = Alignment.CenterVertically, modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.spacedBy(8.dp)){
                    Spacer(modifier = Modifier
                        .height(2.dp)
                        .width(20.dp)
                        .background(Color.Gray))
                    Image(modifier = Modifier
                        .size(20.dp)
                        .padding(5.dp),
                        painter = painterResource(id = R.drawable.ic_linkedin),
                        contentDescription = "Linkedin Icon"
                    )
                    Text(
                        modifier = Modifier.clickable{
                            uriHandler.openUri("https://www.linkedin.com/in/jesus-ru1z-20-08-02-lmm/")
                        },
                        text = "jesus-ru1z-20-08-02-lmm",
                        style = TextStyle(
                            fontSize = 12.sp
                        )
                    )
                    Image(modifier = Modifier
                        .size(10.dp),
                        painter = painterResource(id = R.drawable.ic_git),
                        contentDescription = "Github Icon"
                    )
                    Text(
                        modifier = Modifier.clickable{
                            uriHandler.openUri("https://github.com/JesusRuiz02") },
                        text = "JesusRuiz02",
                        style = TextStyle(
                            fontSize = 12.sp
                        )
                    )
                    Spacer(modifier = Modifier
                        .height(2.dp)
                        .padding(start = 5.dp)
                        .width(20.dp)
                        .background(Color.Gray))

                }
            }

        }

    }


}

@Preview(showBackground = true)
@Composable
fun HeaderCurriculumPreview() {
    CountrypediaTheme {
        HeaderView()
    }
}