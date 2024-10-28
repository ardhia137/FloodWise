package com.ardhi.floodwise.ui.Component

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.ardhi.floodwise.R
import com.ardhi.floodwise.ui.theme.TextGrey

@Composable
fun CardKetinggianAir() {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 8.dp)
            .background(Color.White, RoundedCornerShape(10.dp))
            .padding(16.dp),
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically
    ) {
        Column {
            Text(text = "Setiabudi", fontWeight = FontWeight.Bold, fontSize = 18.sp)
            Spacer(modifier = Modifier.height(15.dp))
            Row(verticalAlignment = Alignment.CenterVertically){
                Image(
                    painter = painterResource(id = R.drawable.accept),
                    contentDescription = "accept Icon",
                    modifier = Modifier.size(15.dp)
                )
                Spacer(modifier = Modifier.width(5.dp))
                Text(text = "Normal", color = TextGrey)
            }
        }
        Column{
            Text(text = "13:00", color = TextGrey)
            Spacer(modifier = Modifier.height(15.dp))
            Row(verticalAlignment = Alignment.CenterVertically){
                Text(text = "-5", fontWeight = FontWeight.Bold, fontSize = 22.sp)
                Column(
                    modifier = Modifier
                        .wrapContentHeight()
                        .padding(start = 5.dp),
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    Text(
                        text = "cm",
                        fontSize = 10.sp,)
                    Icon(
                        painter = painterResource(id = R.drawable.down),
                        contentDescription = "down icon",
                        modifier = Modifier
                            .size(17.dp)
                            .offset(y = -7.dp)
                    )
                }
            }
        }
    }
}