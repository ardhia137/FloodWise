package com.ardhi.floodwise.ui.Component

import android.icu.text.ListFormatter.Width
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import coil.compose.rememberImagePainter

@Composable
fun CardArtikel(index : Int?, width: Int?) {
    Card(
        modifier = Modifier
            .then(if (width != null) Modifier.width(width.dp) else Modifier.fillMaxWidth())
            .padding(
                start = if (index == 0) 16.dp else 8.dp, // Jarak kiri untuk item pertama
                end = if (index == 1) 16.dp else 8.dp,
            ),
        shape = RoundedCornerShape(8.dp),
        elevation = CardDefaults.cardElevation(4.dp),
        colors = CardDefaults.cardColors(Color.White)) {
        Column {
            Image(
                painter = rememberImagePainter(data = "https://web.bpbd.jatimprov.go.id/wp-content/uploads/2023/10/flood.png"),
                contentDescription = null,
                contentScale = ContentScale.Crop,
                modifier = Modifier
                    .height(147.dp)
                    .fillMaxWidth()
            )
            Text(
                text = "Banjir: Pengertian, Penyebab, dan Dampaknya",
                fontWeight = FontWeight.Bold,
                modifier = Modifier.padding(top = 8.dp, start = 8.dp, end = 8.dp)
            )
            Text(
                text = "Jawa Timur, sebuah provinsi di Indonesia, dikenal akan keindahan alamnya yang beragam...",
                modifier = Modifier.padding(horizontal = 8.dp, vertical = 4.dp),
                maxLines = 3
            )
        }
    }
}