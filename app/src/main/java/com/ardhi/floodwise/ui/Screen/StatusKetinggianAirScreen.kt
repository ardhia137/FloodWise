package com.ardhi.floodwise.ui.Screen

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.ArrowBackIosNew
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.ardhi.floodwise.ui.Component.CardKetinggianAir
import com.ardhi.floodwise.ui.theme.BackgroundColor
import com.ardhi.floodwise.ui.theme.PrimaryColor

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun StatusKetinggianAirScreen(
    onBackClick: () -> Unit,
) {
    Scaffold(
        topBar = {
            TopAppBar(
                title = {
                    Text(
                        text = "Status Ketinggian Air",
                        fontWeight = FontWeight.Bold,
                        fontSize = 24.sp,
                        color = Color.White
                    )
                },
                colors = TopAppBarDefaults.smallTopAppBarColors(
                    containerColor = PrimaryColor // Mengganti backgroundColor dengan containerColor
                ),
                navigationIcon = {
                    IconButton(onClick = { onBackClick()}) {
                        Icon(Icons.Filled.ArrowBackIosNew, contentDescription = "Kembali", tint = Color.White)
                    }
                }
            )
        }
    ) { paddingValues ->
        // Konten utama
        LazyColumn(
            modifier = Modifier
                .fillMaxSize()
                .background(BackgroundColor)
                .padding(paddingValues)
                .padding(horizontal = 8.dp),
            horizontalAlignment = Alignment.CenterHorizontally,

        ) {
            items(10) { index ->
           CardKetinggianAir()
                }
        }
    }
}
