package com.noskill.profileavatar // Reemplaza con tu nombre de paquete

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Email
import androidx.compose.material.icons.filled.LocationOn
import androidx.compose.material.icons.filled.Phone
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.noskill.profileavatar.ui.theme.ProfileAvatarTheme // Reemplaza con el tema de tu app

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ProfileAvatarTheme {
                // Contenedor principal que centra la tarjeta en la pantalla
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = Color(0xFFF3F4F6) // bg-gray-100
                ) {
                    ProfileCardScreen()
                }
            }
        }
    }
}

@OptIn(ExperimentalLayoutApi::class)
@Composable
fun ProfileCardScreen() {
    // Box para centrar la tarjeta en la pantalla
    Box(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        contentAlignment = Alignment.Center
    ) {
        // Card simula el contenedor principal de la tarjeta
        Card(
            modifier = Modifier
                .fillMaxWidth()
                .wrapContentHeight(),
            shape = RoundedCornerShape(24.dp), // rounded-2xl
            elevation = CardDefaults.cardElevation(defaultElevation = 8.dp),
            colors = CardDefaults.cardColors(containerColor = Color.White)
        ) {
            // Columna principal para organizar el contenido verticalmente
            Column(
                modifier = Modifier.padding(32.dp),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {

                // --- SECCIÓN DE AVATAR Y NOMBRE ---
                Image(
                    painter = painterResource(id = R.drawable.avatar),
                    contentDescription = "Imagen de mi Avatar Bot",
                    contentScale = ContentScale.Crop,
                    modifier = Modifier
                        .size(128.dp)
                        .clip(CircleShape)
                        .border(4.dp, Color(0xFF34D399), CircleShape)
                )

                Spacer(modifier = Modifier.height(16.dp))

                Text(
                    text = "Keneth Benavidez",
                    fontSize = 22.sp,
                    fontWeight = FontWeight.Bold,
                    color = Color(0xFF1F2937)
                )

                Spacer(modifier = Modifier.height(4.dp))

                Text(
                    text = "Ingeniero de Software | Desarrollador Full Stack",
                    fontSize = 16.sp,
                    color = Color(0xFF6B7280)
                )

                // --- SECCIÓN DE CONTACTO ---
                Spacer(modifier = Modifier.height(32.dp))
                Column(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalAlignment = Alignment.Start
                ) {
                    Text(
                        text = "Contacto",
                        fontSize = 18.sp,
                        fontWeight = FontWeight.SemiBold,
                        color = Color(0xFF374151)
                    )
                    Spacer(modifier = Modifier.height(12.dp))
                    ContactRow(icon = Icons.Default.Email, text = "Kenethfigueroa07@gmail.com")
                    Spacer(modifier = Modifier.height(8.dp))
                    ContactRow(icon = Icons.Default.Phone, text = "+507 6295-8880")
                    Spacer(modifier = Modifier.height(8.dp))
                    ContactRow(icon = Icons.Default.LocationOn, text = "Panamá, Panamá")
                }

                // --- SECCIÓN DE REDES SOCIALES ---
                Spacer(modifier = Modifier.height(32.dp))
                Text(
                    text = "Redes",
                    fontSize = 18.sp,
                    fontWeight = FontWeight.SemiBold,
                    color = Color(0xFF374151)
                )
                Spacer(modifier = Modifier.height(16.dp))
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.Center,
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    SocialIcon(painter = painterResource(id = R.drawable.linkedin), url = "https://www.linkedin.com/in/keneth-benavidez-15983827b/")
                    Spacer(modifier = Modifier.width(20.dp))
                    SocialIcon(painter = painterResource(id = R.drawable.github), url = "https://github.com/NoSkill007")
                    Spacer(modifier = Modifier.width(20.dp))
                    SocialIcon(painter = painterResource(id = R.drawable.twitter), url = "https://youtu.be/xvFZjo5PgG0?si=mlrJlpyhLtK6fryb")
                }

                // --- SECCIÓN DE HABILIDADES ---
                Spacer(modifier = Modifier.height(32.dp))
                Text(
                    text = "Habilidades Profesionales",
                    fontSize = 18.sp,
                    textAlign = TextAlign.Center,
                    fontWeight = FontWeight.SemiBold,
                    color = Color(0xFF374151)
                )
                Spacer(modifier = Modifier.height(16.dp))

                FlowRow(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.Center,
                    verticalArrangement = Arrangement.spacedBy(8.dp),
                    maxItemsInEachRow = 4
                ) {
                    SkillChip("Desarrollo Full Stack", isPrimary = true)
                    SkillChip("Kotlin", isPrimary = true)
                    SkillChip("Jetpack Compose", isPrimary = true)
                    SkillChip("Java")
                    SkillChip("C")
                    SkillChip("SQL")
                    SkillChip("Git")
                    SkillChip("Scrum")
                }
            }
        }
    }
}

// Componente reutilizable para las filas de contacto
@Composable
fun ContactRow(icon: ImageVector, text: String) {
    Row(verticalAlignment = Alignment.CenterVertically) {
        Icon(
            imageVector = icon,
            contentDescription = null,
            tint = Color(0xFF10B981),
            modifier = Modifier.size(20.dp)
        )
        Spacer(modifier = Modifier.width(12.dp))
        Text(
            text = text,
            fontSize = 14.sp,
            color = Color(0xFF4B5563)
        )
    }
}

@Composable
fun SocialIcon(painter: Painter, url: String) { // <--- Y aquí se recibe el parámetro 'url'
    val context = LocalContext.current
    // La 'url' recibida se usa aquí para crear el Intent
    val intent = remember { Intent(Intent.ACTION_VIEW, Uri.parse(url)) }

    Box(
        modifier = Modifier
            .size(44.dp)
            .clip(CircleShape)
            .background(Color(0xFFF3F4F6))
            .clickable {
                // Al hacer clic, se ejecuta el intent y se abre el navegador
                context.startActivity(intent)
            }
            .padding(12.dp)
    ) {
        Icon(
            painter = painter,
            contentDescription = null,
            tint = Color(0xFF4B5563),
            modifier = Modifier.fillMaxSize()
        )
    }
}

// Componente para las "píldoras" de habilidades
@Composable
fun SkillChip(text: String, isPrimary: Boolean = false) {
    val backgroundColor = if (isPrimary) Color(0xFFD1FAE5) else Color(0xFFE5E7EB)
    val textColor = if (isPrimary) Color(0xFF065F46) else Color(0xFF1F2937)

    Surface(
        shape = RoundedCornerShape(16.dp),
        color = backgroundColor,
        modifier = Modifier.padding(horizontal = 4.dp)
    ) {
        Text(
            text = text,
            color = textColor,
            fontSize = 12.sp,
            fontWeight = FontWeight.Medium,
            modifier = Modifier.padding(horizontal = 12.dp, vertical = 6.dp)
        )
    }
}