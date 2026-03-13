package com.example.myprofileapp // Pastikan package ini sesuai dengan folder lo

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.animation.*
import androidx.compose.animation.core.tween
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MaterialTheme {
                MyProfileApp()
            }
        }
    }
}

@Composable
fun MyProfileApp() {
    // State untuk kontrol animasi masuk
    var visible by remember { mutableStateOf(false) }

    // Trigger animasi saat aplikasi pertama kali dimuat
    LaunchedEffect(Unit) {
        visible = true
    }

    // Penambahan Gradasi Biru tanpa merubah struktur [cite: 615]
    val blueGradient = Brush.verticalGradient(
        colors = listOf(
            Color(0xFFE3F2FD), // Biru Muda (Top)
            Color(0xFFBBDEFB), // Biru Menengah
            Color(0xFFFFFFFF)  // Putih (Bottom)
        )
    )

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(blueGradient)
            .padding(20.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        // Animasi Header dari atas ke bawah
        AnimatedVisibility(
            visible = visible,
            enter = fadeIn(tween(800)) + slideInVertically(initialOffsetY = { -200 })
        ) {
            ProfileHeader(name = "Gian Ivander")
        }

        Spacer(modifier = Modifier.height(16.dp))

        // Animasi Konten dari bawah ke atas
        AnimatedVisibility(
            visible = visible,
            enter = fadeIn(tween(1000)) + slideInVertically(initialOffsetY = { 200 })
        ) {
            Column(horizontalAlignment = Alignment.CenterHorizontally) {
                Text(
                    text = "Mahasiswa Teknik Informatika ITERA yang tertarik pada IoT dan Perangkat Lunak.",
                    textAlign = TextAlign.Center,
                    color = Color.DarkGray,
                    modifier = Modifier.padding(horizontal = 10.dp)
                )

                Spacer(modifier = Modifier.height(24.dp))

                // Penggunaan Reusable Card [cite: 629]
                ProfileCard()

                Spacer(modifier = Modifier.height(24.dp))

                // Tombol dengan warna yang serasi dengan gradasi
                Button(
                    onClick = { /* Action Edit Profile */ },
                    shape = RoundedCornerShape(50),
                    colors = ButtonDefaults.buttonColors(containerColor = Color(0xFF1976D2)),
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(50.dp)
                ) {
                    Text("Edit Profile", color = Color.White)
                }
            }
        }
    }
}

@Composable
fun ProfileHeader(name: String) {
    Column(horizontalAlignment = Alignment.CenterHorizontally) {
        Box(contentAlignment = Alignment.Center) {
            // Lingkaran background (Outer Box) [cite: 186]
            Box(
                modifier = Modifier
                    .size(140.dp)
                    .clip(CircleShape)
                    .background(Color(0xFFBBDEFB).copy(alpha = 0.5f))
            )

            // Foto profile (Image dengan Clip) [cite: 395, 401]
            // Pastikan lo punya file 'profile.png/jpg' di res/drawable
            Image(
                painter = painterResource(id = R.drawable.profile),
                contentDescription = "Profile Picture",
                modifier = Modifier
                    .size(120.dp)
                    .clip(CircleShape)
                    .border(2.dp, Color(0xFF1976D2), CircleShape),
                contentScale = ContentScale.Crop
            )
        }

        Spacer(modifier = Modifier.height(12.dp))

        Text(
            text = name,
            fontSize = 22.sp,
            fontWeight = FontWeight.Bold,
            color = Color(0xFF0D47A1)
        )
    }
}

@Composable
fun ProfileCard() {
    Card(
        modifier = Modifier.fillMaxWidth(),
        elevation = CardDefaults.cardElevation(4.dp), // Elevasi Card [cite: 428]
        colors = CardDefaults.cardColors(containerColor = Color.White)
    ) {
        Column(
            modifier = Modifier.padding(16.dp),
            verticalArrangement = Arrangement.spacedBy(12.dp) // Jarak antar item [cite: 199]
        ) {
            InfoItem(
                icon = Icons.Default.Email,
                label = "Email",
                value = "gian.123140040@student.itera.ac.id"
            )
            InfoItem(
                icon = Icons.Default.Call,
                label = "Phone",
                value = "08972398245"
            )
            InfoItem(
                icon = Icons.Default.LocationOn,
                label = "Location",
                value = "Lampung, Indonesia"
            )
        }
    }
}

@Composable
fun InfoItem(icon: ImageVector, label: String, value: String) {
    Row(
        verticalAlignment = Alignment.CenterVertically,
        modifier = Modifier.fillMaxWidth() // Menyusun horizontal [cite: 172]
    ) {
        Icon(
            imageVector = icon,
            contentDescription = label,
            tint = Color(0xFF1976D2),
            modifier = Modifier.size(24.dp)
        )

        Spacer(modifier = Modifier.width(12.dp))

        Column {
            Text(
                text = label,
                fontSize = 12.sp,
                color = Color.Gray
            )
            Text(
                text = value,
                fontSize = 15.sp,
                fontWeight = FontWeight.Medium,
                color = Color.Black
            )
        }
    }
}