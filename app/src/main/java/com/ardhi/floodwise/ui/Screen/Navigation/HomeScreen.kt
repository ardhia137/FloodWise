package com.ardhi.floodwise.ui.Screen.Navigation

import android.util.Log
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Notifications
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import coil.compose.rememberImagePainter
import com.ardhi.floodwise.R
import com.ardhi.floodwise.ui.Component.CardArtikel
import com.ardhi.floodwise.ui.Component.CardKetinggianAir
import com.ardhi.floodwise.ui.Navigation.Screen
import com.ardhi.floodwise.ui.theme.BackgroundColor
import com.ardhi.floodwise.ui.theme.PrimaryColor
import com.ardhi.floodwise.ui.theme.SecondaryColor
import com.ardhi.floodwise.ui.theme.TextGrey
import com.ardhi.floodwise.ui.theme.ThirdColor

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun HomeScreen(navController: NavController,) {
    // Menggunakan Scaffold untuk menempatkan AppBar dan konten
    Scaffold(
        topBar = {
            TopAppBar(
                title = {
                    Text(
                        text = "FloodWise",
                        fontWeight = FontWeight.Bold,
                        fontSize = 24.sp,
                        color = Color.White
                    )
                },

                colors = TopAppBarDefaults.smallTopAppBarColors(
                    containerColor = PrimaryColor // Mengganti backgroundColor dengan containerColor
                ),
                actions = {
                    // Menambahkan ikon di pojok kanan atas
                    IconButton(onClick = {  try {
                        navController.navigate("artikel")
                    } catch (e: IllegalArgumentException) {
                        Log.e("NavigationError", "Navigation failed: ${e.message}")
                    }}) {
                        Icon(
                            imageVector = Icons.Filled.Notifications,
                            contentDescription = "Notifikasi",
                            tint = Color.White // Ubah warna ikon sesuai kebutuhan
                        )
                    }
                }
            )
        },
        content = { paddingValues ->
            // Konten yang dapat di-scroll
            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .background(BackgroundColor)
                    .verticalScroll(rememberScrollState()) // Membuat konten bisa di-scroll
                    .padding(
                        top = paddingValues.calculateTopPadding(),

                        bottom = 10.dp // Atur padding bawah ke 0dp
                    ) // Menambahkan padding dari Scaffold untuk konten
            ) {
                // Status Ketinggian Air
                WeatherCard()
                StatusKetinggian(navController)
                Artikel(navController)

            }
        }
    )
}

@Composable
fun Artikel(navController: NavController){
    Column(modifier = Modifier) {
        Row(
            modifier = Modifier.fillMaxWidth().padding(horizontal = 10.dp),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ){
            Text(
                text = "Artikel",
                fontWeight = FontWeight.Bold,
                fontSize = 18.sp
            )
            TextButton(onClick = { navController.navigate(Screen.Artikel.route) }) {
                Text(
                    text = "Lihat Semua",
                    fontWeight = FontWeight.Light,
                    color = SecondaryColor,
                    fontSize = 18.sp
                )
            }
        }
        LazyRow(
            modifier = Modifier.padding(top = 8.dp)
        ) {
            items(2) { index ->
                CardArtikel (index,230)
            }
        }
    }
}

@Composable
fun StatusKetinggian(navController: NavController,){
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(8.dp)
    ) {
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ){
            Text(
                text = "Status Ketinggian Air",
                fontWeight = FontWeight.Bold,
                fontSize = 18.sp
            )
            TextButton(onClick = { navController.navigate(Screen.Status.route) }) {
                Text(
                    text = "Lihat Semua",
                    fontWeight = FontWeight.Light,
                    color = SecondaryColor,
                    fontSize = 18.sp
                )
            }
        }
        CardKetinggianAir()
    }
}

@Composable
fun WeatherCard() {
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(ThirdColor) // Background biru muda
    ) {
        // Skyline background (from drawable), letakkan lebih dulu
        Image(
            painter = painterResource(id = R.drawable.city),
            contentDescription = null,
            modifier = Modifier
                .fillMaxWidth()
                .height(100.dp)
                .align(Alignment.BottomCenter),
            contentScale = ContentScale.Crop
        )

        // Column yang berisi teks dan info cuaca
        Row (
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceBetween
        ){
            Column(
//                modifier = Modifier.padding(16.dp),
                verticalArrangement = Arrangement.SpaceAround,
                horizontalAlignment = Alignment.Start
            ) {
                // City and location
                Text(
                    text = "Setiabudi",
                    style = MaterialTheme.typography.bodyLarge.copy(
                        fontWeight = FontWeight.Bold,
                        fontSize = 24.sp
                    ),
                    color = Color.White
                )
                Text(
                    text = "Bandung",
                    style = MaterialTheme.typography.bodyMedium,
                    color = Color.White
                )
                Spacer(modifier = Modifier.height(16.dp))

                // Weather info

                Text(
                    text = "30°C",
                    style = MaterialTheme.typography.bodyLarge.copy(
                        fontWeight = FontWeight.Bold,
                        fontSize = 48.sp
                    ),
                    color = Color.White
                )
                Spacer(modifier = Modifier.width(8.dp))



                // Weather description
                Text(
                    text = "Sebagian Berawan",
                    style = MaterialTheme.typography.bodyMedium.copy(fontSize = 16.sp),
                    color = Color.White,
                    textAlign = TextAlign.Center
                )
            }
            Image(
                painter = painterResource(id = R.drawable.cloudy),
                contentDescription = "Cloud Icon",
                modifier = Modifier.size(100.dp),
            )
        }
    }
}