package com.jesusruiz.countrypedia.views.curriculum

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
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
    Row(modifier = modifier.fillMaxWidth()
        .padding(5.dp),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.SpaceEvenly) {
        Image(modifier = Modifier
            .height(200.dp)
            .width(100.dp)
            .padding(top = 50.dp, bottom = 20.dp) ,
            painter = painterResource(id = R.drawable.profile_picture ),
            contentDescription = "Profile Picture",
        )
        Column {
            Row(verticalAlignment = Alignment.CenterVertically,
            ){
                Spacer(modifier = Modifier
                    .height(10.dp)
                    .width(30.dp)
                    .background(Color.LightGray)
                )
                Column(horizontalAlignment = Alignment.Start) {
                    Text(text = "Android Engineer", style = MaterialTheme.typography.bodySmall  )
                    Text( text = stringResource(R.string.name_home_txt), style = MaterialTheme.typography.titleLarge, modifier = Modifier.padding(horizontal = 10.dp), fontWeight = FontWeight.Bold)
                }
                Spacer(modifier = Modifier
                    .padding(horizontal = 10.dp)
                    .height(100.dp)
                    .width(1.5.dp)
                    .background(Color.LightGray))
                Column(horizontalAlignment =  Alignment.Start){
                    Text(text = "Contact Info",
                        style = MaterialTheme.typography.titleSmall,
                        fontWeight = FontWeight.Bold  )
                    Text( text = "jesruizman@gmail.com",
                        style = TextStyle(
                            fontSize = 9.sp
                        ),
                        modifier = Modifier.padding(horizontal = 10.dp),color = Color.Gray)
                    Text(text = "+526121586629", style = TextStyle(
                        fontSize = 12.sp
                    ),
                        color = Color.Gray)
                }
            }
            Row(verticalAlignment = Alignment.CenterVertically, modifier = Modifier.padding(top = 10.dp)){
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
                    .size(20.dp)
                    .padding(horizontal = 10.dp),
                    painter = painterResource(id = R.drawable.ic_launcher_background),
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

@Preview(showBackground = true)
@Composable
fun HeaderCurriculumPreview() {
    CountrypediaTheme {
        HeaderView()
    }
}