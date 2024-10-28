package com.ardhi.floodwise.ui.Screen

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBackIosNew
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.ardhi.floodwise.ui.Component.CardArtikel
import com.ardhi.floodwise.ui.theme.BackgroundColor
import com.ardhi.floodwise.ui.theme.BorderColor
import com.ardhi.floodwise.ui.theme.PrimaryColor

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ArtikelScreen(onBackClick: () -> Unit,) {
    var query by remember { mutableStateOf("") } // State untuk query pencarian
    var active by remember { mutableStateOf(false) } // State untuk mengontrol aktif/tidaknya SearchBar

    Scaffold(
        topBar = {
            TopAppBar(
                title = {
                    Text(
                        text = "Artikel",
                        fontSize = 24.sp,
                        color = Color.White
                    )
                },
                colors = TopAppBarDefaults.smallTopAppBarColors(
                    containerColor = PrimaryColor
                ),
                navigationIcon = {
                    IconButton(onClick = { onBackClick() }) {
                        Icon(Icons.Filled.ArrowBackIosNew, contentDescription = "Kembali", tint = Color.White)
                    }
                }
            )
        }
    ) { paddingValues ->
        LazyColumn(
            modifier = Modifier
                .fillMaxSize()
                .background(BackgroundColor)
                .padding(
                    top = paddingValues.calculateTopPadding() - 15.dp,
                    bottom = paddingValues.calculateBottomPadding(),
                    start = 8.dp,
                    end = 8.dp
                ),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {
            item {
                // SearchBar dengan semua parameter yang diperlukan
                SearchBar(
                    query = query,
                    leadingIcon = {
                        Icon(Icons.Filled.Search, contentDescription = "Search")
                    }, // Menambahkan ikon pencarian
                    placeholder = {
                        Text("Search")
                    },
                    onQueryChange = { query = it }, // Mengupdate query ketika user mengetik
                    active = active,
                    onActiveChange = { active = it }, // Mengatur state aktif/tidaknya SearchBar
                    onSearch = { /* Aksi ketika tombol cari ditekan, misal fetch artikel */ },
                    colors = SearchBarDefaults.colors(
                        containerColor = BorderColor, // Mengubah warna kontainer SearchBar

                    ),
                    modifier = Modifier.padding(bottom = 15.dp),
                    content = { /* Content bisa diisi item artikel atau lainnya sesuai kebutuhan */ }
                )
            }
            // Konten artikel lainnya bisa ditambahkan di sini
            items(10) { index ->
                CardArtikel(
                    null,
                    null
                )
                Spacer(modifier = Modifier.padding(vertical = 10.dp))
            }
        }
    }
}
