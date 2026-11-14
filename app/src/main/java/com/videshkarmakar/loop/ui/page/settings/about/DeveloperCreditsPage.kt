package com.videshkarmakar.loop.ui.page.settings.about

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.CameraAlt
import androidx.compose.material.icons.outlined.Language
import androidx.compose.material.icons.outlined.MusicNote
import androidx.compose.material.icons.outlined.PlayArrow
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Icon
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalUriHandler
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.AsyncImage

private val Obsidian = Color(0xFF121316)
private val SurfaceCard = Color(0xFF1B1C22)
private val SurfacePill = Color(0xFF21232B)
private val SurfaceBorder = Color(0xFF2A2C35)
private val PillBorder = Color(0xFF272933)
private val DividerColor = Color(0xFF272933)
private val CrimsonSunset = Color(0xFFF75254)
private val TextPrimary = Color(0xFFF1F5F9)
private val TextSecondary = Color(0xFFCBD5E1)
private val TextMuted = Color(0xFF94A3B8)

@Composable
fun DeveloperCreditsPage(
    onNavigateBack: () -> Unit
) {
    val uriHandler = LocalUriHandler.current

    Surface(
        modifier = Modifier.fillMaxSize(),
        color = Obsidian
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .verticalScroll(rememberScrollState())
                .padding(horizontal = 20.dp)
                .padding(top = 12.dp, bottom = 24.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Box(modifier = Modifier.padding(top = 8.dp, bottom = 16.dp)) {
                Box(
                    modifier = Modifier
                        .size(112.dp)
                        .clip(CircleShape)
                        .background(Color(0xFF16171D))
                        .border(2.dp, Color(0xFF242630), CircleShape)
                        .padding(4.dp),
                    contentAlignment = Alignment.Center
                ) {
                    AsyncImage(
                        model = "https://cdn.phototourl.com/member/2026-09-11-84fc2df9-c2a9-4384-a9b8-25290f7a1a3d.png",
                        contentDescription = "Videsh Karmakar profile portrait",
                        modifier = Modifier
                            .fillMaxSize()
                            .clip(CircleShape),
                        contentScale = ContentScale.Crop
                    )
                }
                Box(
                    modifier = Modifier
                        .align(Alignment.BottomEnd)
                        .padding(bottom = 4.dp, end = 8.dp)
                        .size(14.dp)
                        .clip(CircleShape)
                        .background(CrimsonSunset)
                        .border(2.dp, Obsidian, CircleShape)
                )
            }

            Text(
                text = "Videsh Karmakar",
                fontSize = 24.sp,
                fontWeight = FontWeight.Bold,
                color = Color.White,
                letterSpacing = (-0.3).sp,
                textAlign = TextAlign.Center
            )
            Spacer(modifier = Modifier.height(6.dp))
            Text(
                text = "An Independent Freestyle Developer",
                fontSize = 14.sp,
                fontWeight = FontWeight.Medium,
                color = TextMuted,
                textAlign = TextAlign.Center
            )

            Spacer(modifier = Modifier.height(24.dp))

            ProfileCard(title = "Developer Credits") {
                CreditRow("Designed & Developed", "Videsh Karmakar")
                HorizontalDivider(
                    modifier = Modifier.padding(vertical = 14.dp),
                    thickness = 1.dp,
                    color = DividerColor
                )
                CreditRow("UI/UX Design", "Videsh Karmakar")
            }

            Spacer(modifier = Modifier.height(16.dp))

            ProfileCard(title = "Special Thanks") {
                Text(
                    text = "Thanks to everyone who contributed feedback, ideas, testing, and support during the development of this application.",
                    fontSize = 14.sp,
                    lineHeight = 22.sp,
                    color = TextSecondary,
                    fontWeight = FontWeight.Normal
                )
            }

            Spacer(modifier = Modifier.height(16.dp))

            Column(modifier = Modifier.fillMaxWidth()) {
                Text(
                    text = "Connect With Developer",
                    fontSize = 16.sp,
                    fontWeight = FontWeight.SemiBold,
                    color = TextPrimary,
                    modifier = Modifier.padding(horizontal = 4.dp),
                    letterSpacing = (-0.2).sp
                )
                Spacer(modifier = Modifier.height(12.dp))
                Column(verticalArrangement = Arrangement.spacedBy(10.dp)) {
                    ConnectPill(
                        icon = Icons.Outlined.Language,
                        label = "Website",
                        onClick = { uriHandler.openUri("https://videshkarmakar.carrd.co/") }
                    )
                    ConnectPill(
                        icon = Icons.Outlined.MusicNote,
                        label = "Spotify",
                        onClick = { uriHandler.openUri("https://open.spotify.com/artist/2eJEzi0mzJB60zVJf0OjWP") }
                    )
                    ConnectPill(
                        icon = Icons.Outlined.CameraAlt,
                        label = "Instagram",
                        onClick = { uriHandler.openUri("https://www.instagram.com/code.red_videsh/") }
                    )
                    ConnectPill(
                        icon = Icons.Outlined.PlayArrow,
                        label = "YouTube",
                        onClick = { uriHandler.openUri("https://www.youtube.com/@videshkarmakar2000") }
                    )
                    ConnectPill(
                        icon = Icons.Outlined.Language,
                        label = "Facebook",
                        onClick = { uriHandler.openUri("https://www.facebook.com/gfx.videsh") }
                    )
                }
            }

            Spacer(modifier = Modifier.height(20.dp))

            Row(
                modifier = Modifier.padding(top = 12.dp, bottom = 8.dp),
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.Center
            ) {
                Text(text = "Made with ", fontSize = 14.sp, color = TextMuted, fontWeight = FontWeight.Medium)
                Text(text = "❤️", fontSize = 14.sp)
                Text(text = " in India ", fontSize = 14.sp, color = TextMuted, fontWeight = FontWeight.Medium)
                Text(text = "🇮🇳", fontSize = 14.sp)
            }
        }
    }
}

@Composable
private fun ProfileCard(
    title: String,
    content: @Composable () -> Unit
) {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .clip(RoundedCornerShape(16.dp))
            .background(SurfaceCard)
            .border(1.dp, SurfaceBorder, RoundedCornerShape(16.dp))
            .padding(20.dp)
    ) {
        Text(
            text = title,
            fontSize = 16.sp,
            fontWeight = FontWeight.SemiBold,
            color = TextPrimary,
            letterSpacing = (-0.2).sp
        )
        Spacer(modifier = Modifier.height(16.dp))
        content()
    }
}

@Composable
private fun CreditRow(label: String, value: String) {
    Row(
        modifier = Modifier.fillMaxWidth(),
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically
    ) {
        Text(
            text = label,
            fontSize = 14.sp,
            color = TextMuted,
            fontWeight = FontWeight.Normal
        )
        Text(
            text = value,
            fontSize = 14.sp,
            color = Color(0xFFE2E8F0),
            fontWeight = FontWeight.Medium
        )
    }
}

@Composable
private fun ConnectPill(
    label: String,
    onClick: () -> Unit,
    icon: ImageVector
) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .clip(RoundedCornerShape(12.dp))
            .background(SurfacePill)
            .border(1.dp, PillBorder, RoundedCornerShape(12.dp))
            .clickable(onClick = onClick)
            .padding(horizontal = 16.dp, vertical = 14.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Icon(
            imageVector = icon,
            contentDescription = label,
            tint = Color(0xFFCBD5E1),
            modifier = Modifier.size(20.dp)
        )
        Spacer(modifier = Modifier.width(14.dp))
        Text(
            text = label,
            fontSize = 14.sp,
            fontWeight = FontWeight.Medium,
            color = Color(0xFFE2E8F0)
        )
    }
}
