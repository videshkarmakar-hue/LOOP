package com.videshkarmakar.loop.ui.component

import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.animation.core.tween
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.interaction.collectIsPressedAsState
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.navigationBarsPadding
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.filled.Report
import androidx.compose.material.icons.filled.Settings
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.videshkarmakar.loop.ui.theme.Matte
import com.videshkarmakar.loop.ui.theme.Neu

data class BottomNavItem(
    val route: String,
    val label: String,
    val icon: ImageVector
)

val bottomNavItems = listOf(
    BottomNavItem(route = "home", label = "Home", icon = Icons.Filled.Home),
    BottomNavItem(route = "creator", label = "Creator", icon = Icons.Filled.Person),
    BottomNavItem(route = "report_feedback", label = "Report", icon = Icons.Filled.Report),
    BottomNavItem(route = "settings", label = "Settings", icon = Icons.Filled.Settings)
)

private val PressSpec = tween<Float>(durationMillis = 110)

/**
 * Bottom navigation: four equally weighted slots on a floating matte bar.
 *
 * The current section is stated with colour only -- the active slot turns coral, the rest stay in
 * the muted ink tone -- so nothing moves between tabs and no sliding pill has to be animated. It
 * is a launcher for the four top-level sections, not a second progress indicator.
 *
 * Press feedback is the one piece of transient state: it is feedback for the finger, and without
 * it the bar feels unresponsive.
 */
@Composable
fun LoopBottomNavigation(
    onNavigate: (String) -> Unit,
    modifier: Modifier = Modifier,
    activeRoute: String? = null
) {

    Box(
        modifier = modifier
            .fillMaxWidth()
            .navigationBarsPadding()
            .padding(horizontal = 24.dp, vertical = 12.dp)
            .height(64.dp)
            .shadow(
                elevation = 10.dp,
                shape = RoundedCornerShape(26.dp),
                ambientColor = Neu.shadow,
                spotColor = Neu.shadow
            )
            .clip(RoundedCornerShape(26.dp))
            .background(Matte.Surface.copy(alpha = 0.94f))
            .border(1.dp, Color.White.copy(alpha = 0.10f), RoundedCornerShape(26.dp)),
        contentAlignment = Alignment.Center
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .height(64.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            bottomNavItems.forEach { item ->
                val interactionSource = remember { MutableInteractionSource() }
                val isPressed by interactionSource.collectIsPressedAsState()
                val pressScale by animateFloatAsState(
                    targetValue = if (isPressed) 0.90f else 1f,
                    animationSpec = PressSpec,
                    label = "navPress"
                )

                Column(
                    modifier = Modifier
                        .weight(1f)
                        .clip(RoundedCornerShape(18.dp))
                        .clickable(
                            interactionSource = interactionSource,
                            indication = null
                        ) { onNavigate(item.route) }
                        .padding(vertical = 8.dp)
                        // Applied at draw time: Modifier.size(24.dp * scale) would re-measure and
                        // re-layout the icon on every frame of the press animation.
                        .graphicsLayer {
                            scaleX = pressScale
                            scaleY = pressScale
                        },
                    horizontalAlignment = Alignment.CenterHorizontally,
                    verticalArrangement = Arrangement.Center
                ) {
                    val contentColor = if (item.route == activeRoute) Matte.Coral else Matte.TextMuted

                    Icon(
                        imageVector = item.icon,
                        contentDescription = item.label,
                        tint = contentColor,
                        modifier = Modifier.size(24.dp)
                    )
                    Text(
                        text = item.label,
                        color = contentColor,
                        fontSize = 10.sp,
                        fontWeight = FontWeight.Medium,
                        maxLines = 1
                    )
                }
            }
        }
    }
}


