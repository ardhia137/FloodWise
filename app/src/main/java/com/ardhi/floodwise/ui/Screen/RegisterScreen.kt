package com.ardhi.floodwise.ui.Screen

import android.util.Log
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
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
import com.ardhi.floodwise.ui.theme.PrimaryColor
import com.ardhi.floodwise.ui.theme.SecondaryColor

@Composable
fun RegisterScreen(navController: NavController, modifier: Modifier = Modifier) {
    var email by remember { mutableStateOf("") }
    var nama by remember { mutableStateOf("") }
    var password by remember { mutableStateOf("") }
    var Rpassword by remember { mutableStateOf("") }
    var passwordVisible by remember { mutableStateOf(false) }
    var RpasswordVisible by remember { mutableStateOf(false) }
    var rememberMe by remember { mutableStateOf(false) }

    Box(modifier = modifier
        .fillMaxSize()
        .background(Color(0xFFF1F1F1))) {
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .fillMaxHeight(0.20f)
                .background(PrimaryColor)
        )
        Column {
            Column( modifier = Modifier
                .fillMaxWidth()
                .fillMaxHeight(0.24f)
                .padding(16.dp),
                horizontalAlignment = Alignment.Start,
                verticalArrangement = Arrangement.Bottom
            ){
                Text(
                    text = "Hai, Mari Bergabung! 👋",
                    fontSize = 24.sp,
                    color = Color.White,
                    fontWeight = FontWeight.Bold,
                    textAlign = TextAlign.Center
                )
                Spacer(modifier = Modifier.height(8.dp))
                Text(
                    text = "Daftar Gratis Untuk Selamanya",
                    fontSize = 16.sp,
                    color = Color.White.copy(alpha = 0.7f),
                    textAlign = TextAlign.Center
                )
                Spacer(modifier = Modifier.height(32.dp))
            }
            Column(
                modifier = Modifier.fillMaxSize()
                    .padding(horizontal = 16.dp),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                CustomOutlinedTextField(
                    value = nama,
                    onValueChange = { nama = it },
                    label = "Nama",
                )
                Spacer(modifier = Modifier.height(8.dp))
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
                CustomOutlinedTextField(
                    value = Rpassword,
                    onValueChange = { Rpassword = it },
                    label = "Ulangi Password",
                    isPassword = true,
                    passwordVisible = RpasswordVisible,
                    onPasswordVisibilityChange = { RpasswordVisible = !RpasswordVisible },
                    keyboardType = KeyboardType.Password
                )
                Spacer(modifier = Modifier.height(20.dp))
                CustomButton(text = "Daftar", onClick = {
                    Log.d(email,password)
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
                        text = "Sudah punya akun?",
                        fontWeight = FontWeight.Medium,
                        fontSize = 18.sp,
                        color = Color.Black,
                    )
                    TextButton(
                        onClick = { navController.navigate("login") },
                    ) {
                        Text("Masuk",
                            fontWeight = FontWeight.Medium,
                            fontSize = 18.sp,
                            color = SecondaryColor)
                    }
                }
            }
        }
    }
}