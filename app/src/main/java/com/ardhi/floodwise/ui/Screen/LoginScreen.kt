package com.ardhi.floodwise.ui.Screen

import android.util.Log
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import com.ardhi.floodwise.ui.Component.CustomButton
import com.ardhi.floodwise.ui.Component.CustomOutlineButton
import com.ardhi.floodwise.ui.Component.CustomOutlinedTextField
import com.ardhi.floodwise.ui.theme.BackgroundColor
import com.ardhi.floodwise.ui.theme.PrimaryColor
import com.ardhi.floodwise.ui.theme.SecondaryColor

@Composable
fun LoginScreen(navController: NavController, modifier: Modifier = Modifier) {
    var email by remember { mutableStateOf("") }
    var password by remember { mutableStateOf("") }
    var passwordVisible by remember { mutableStateOf(false) }
    var rememberMe by remember { mutableStateOf(false) }

    Box(modifier = modifier
        .fillMaxSize()
        .background(BackgroundColor)) {
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .fillMaxHeight(0.5f)
                .background(PrimaryColor)
        )
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(16.dp),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {
            Text(
                text = "Hallo, Selamat Datang! 👋",
                fontSize = 24.sp,
                color = Color.White,
                fontWeight = FontWeight.Bold,
                textAlign = TextAlign.Center
            )
            Spacer(modifier = Modifier.height(8.dp))
            Text(
                text = "Masuk Untuk Melanjutkan",
                fontSize = 16.sp,
                color = Color.White.copy(alpha = 0.7f),
                textAlign = TextAlign.Center
            )
            Spacer(modifier = Modifier.height(32.dp))
            Card(
                shape = RoundedCornerShape(10.dp),
                modifier = Modifier.fillMaxWidth(),
                colors = CardDefaults.cardColors(containerColor = Color.White)
            ) {
                Column(
                    modifier = Modifier.padding(16.dp),
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    CustomOutlinedTextField(
                        value = email,
                        onValueChange = { email = it },
                        label = "Email",
                        keyboardType = KeyboardType.Email
                    )
                    Spacer(modifier = Modifier.height(8.dp))
                    CustomOutlinedTextField(
                        value = password,
                        onValueChange = { password = it },
                        label = "Password",
                        isPassword = true,
                        passwordVisible = passwordVisible,
                        onPasswordVisibilityChange = { passwordVisible = !passwordVisible },
                        keyboardType = KeyboardType.Password
                    )
                    Spacer(modifier = Modifier.height(8.dp))
                    Row(
                        modifier = Modifier.fillMaxWidth(),
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        Checkbox(
                            checked = rememberMe,
                            onCheckedChange = { rememberMe = it },
                            colors = CheckboxDefaults.colors(checkedColor = Color.Black, uncheckedColor = Color.Black) // Menjaga warna checkbox
                        )
                        Text(
                            text = "Remember Me",
                             color = Color.Black,
                            modifier = Modifier.weight(1f)
                        )
                        TextButton(onClick = { /* TODO: Lupa Password Action */ }) {
                            Text("Lupa Password?", color = SecondaryColor)
                        }
                    }
                    Spacer(modifier = Modifier.height(16.dp))
                    CustomButton(text = "Masuk", onClick = {
                        navController.navigate("main") {
                            popUpTo("login") { inclusive = true } // Menghapus layar login dari stack
                        }
                    })
                    Spacer(modifier = Modifier.height(8.dp))
                    CustomOutlineButton(text = "Lanjutkan Dengan Google", onClick = { /*TODO*/ })
                    Spacer(modifier = Modifier.height(16.dp))
                    Row(
                        modifier = Modifier.fillMaxWidth(),
                        verticalAlignment = Alignment.CenterVertically,
                        horizontalArrangement = Arrangement.Center
                    ) {
                        Text(
                            text = "Belum punya akun?",
                            fontWeight = FontWeight.Medium,
                            fontSize = 18.sp,
                            color = Color.Black,
                        )
                        TextButton(
                            onClick = { navController.navigate("register")},
                        ) {
                            Text("Daftar",
                                fontWeight = FontWeight.Medium,
                                fontSize = 18.sp,
                                color = SecondaryColor)
                        }
                    }
                }
            }
        }
    }
}
