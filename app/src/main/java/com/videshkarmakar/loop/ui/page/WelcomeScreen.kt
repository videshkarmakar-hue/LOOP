package com.videshkarmakar.loop.ui.page

import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.animation.core.tween
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.interaction.collectIsPressedAsState
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
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowForward
import androidx.compose.material.icons.filled.CameraAlt
import androidx.compose.material.icons.filled.Facebook
import androidx.compose.material.icons.filled.Language
import androidx.compose.material.icons.filled.MusicNote
import androidx.compose.material.icons.filled.OpenInNew
import androidx.compose.material.icons.filled.PlayArrow
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.platform.LocalUriHandler
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.videshkarmakar.loop.R
import com.videshkarmakar.loop.ui.theme.MilkerFontFamily
import com.videshkarmakar.loop.ui.theme.Neu
import com.videshkarmakar.loop.ui.theme.neuInset
import com.videshkarmakar.loop.ui.theme.neuPressed
import com.videshkarmakar.loop.ui.theme.neuRaised

private data class SocialLink(
    val label: String,
    val url: String,
    val icon: ImageVector
)

private val socialLinks = listOf(
    SocialLink(
        label = "Website",
        url = "https://videshkarmakar.carrd.co/",
        icon = Icons.Filled.Language
    ),
    SocialLink(
        label = "Spotify",
        url = "https://open.spotify.com/artist/2eJEzi0mzJB60zVJf0OjWP",
        icon = Icons.Filled.MusicNote
    ),
    SocialLink(
        label = "Instagram",
        url = "https://www.instagram.com/code.red_videsh/",
        icon = Icons.Filled.CameraAlt
    ),
    SocialLink(
        label = "YouTube",
        url = "https://www.youtube.com/@videshkarmakar2000",
        icon = Icons.Filled.PlayArrow
    ),
    SocialLink(
        label = "Facebook",
        url = "https://www.facebook.com/gfx.videsh",
        icon = Icons.Filled.Facebook
    )
)

/** "https://www.youtube.com/@x" -> "youtube.com/@x", for the secondary line under each label. */
private fun String.displayHost(): String = removePrefix("https://").removePrefix("www.")

private val RowPressSpec = tween<Float>(durationMillis = 120)

/**
 * Shown once, on the very first launch after install.
 *
 * Gated by HAS_SHOWN_WELCOME in HomeEntry: the start destination is this screen until the user
 * taps Continue, after which the flag flips and every later launch goes straight to Home.
 *
 * The icon and the developer portrait are bundled as drawables rather than fetched, so the one
 * screen a user is guaranteed to see cannot fail on a cold network.
 */
@Composable
fun WelcomeScreen(
    onContinue: () -> Unit
) {
    val uriHandler = LocalUriHandler.current

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(MaterialTheme.colorScheme.background)
            .verticalScroll(rememberScrollState())
            .padding(horizontal = 28.dp, vertical = 40.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Spacer(modifier = Modifier.height(12.dp))

        Image(
            painter = painterResource(id = R.drawable.ic_onboarding_app_icon),
            contentDescription = "LOOP app icon",
            modifier = Modifier
                .size(104.dp)
                .neuRaised(cornerRadius = 28.dp, depth = 8.dp)
                .padding(16.dp)
                .clip(RoundedCornerShape(16.dp))
        )

        Spacer(modifier = Modifier.height(24.dp))

        Text(
            text = "LOOP",
            style = MaterialTheme.typography.displaySmall,
            fontFamily = MilkerFontFamily,
            color = MaterialTheme.colorScheme.onBackground
        )

        Spacer(modifier = Modifier.height(6.dp))

        Text(
            text = "Every Day, Every Download, Every Content.",
            style = MaterialTheme.typography.bodyMedium,
            color = MaterialTheme.colorScheme.onSurfaceVariant,
            textAlign = TextAlign.Center
        )

        Spacer(modifier = Modifier.height(32.dp))

        // ---- Developer ----
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .neuRaised(
                    cornerRadius = 24.dp,
                    depth = 6.dp,
                    fill = MaterialTheme.colorScheme.surfaceContainerLow
                )
                .border(
                    width = 1.dp,
                    color = MaterialTheme.colorScheme.outlineVariant,
                    shape = RoundedCornerShape(24.dp)
                )
                .padding(22.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Image(
                painter = painterResource(id = R.drawable.ic_onboarding_developer),
                contentDescription = "Developer portrait",
                modifier = Modifier
                    .size(72.dp)
                    .clip(CircleShape)
            )

            Spacer(modifier = Modifier.height(14.dp))

            Text(
                text = "Crafted by VIDESH KARMAKAR",
                style = MaterialTheme.typography.titleMedium,
                fontWeight = FontWeight.SemiBold,
                color = MaterialTheme.colorScheme.onSurface,
                textAlign = TextAlign.Center
            )

            Spacer(modifier = Modifier.height(10.dp))

            Text(
                text = "Thanks for Supporting My Project \u201CLOOP\u201D",
                style = MaterialTheme.typography.bodyMedium,
                color = MaterialTheme.colorScheme.onSurfaceVariant,
                textAlign = TextAlign.Center,
                lineHeight = 21.sp
            )
        }

        Spacer(modifier = Modifier.height(28.dp))

        // ---- Social links ----
        // A bordered list rather than a row of circular buttons: five circles with no labels is
        // the one layout a first-run screen cannot afford, because nothing tells a new user which
        // platform each glyph belongs to.
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .border(
                    width = 1.dp,
                    color = MaterialTheme.colorScheme.outlineVariant,
                    shape = RoundedCornerShape(22.dp)
                )
                .clip(RoundedCornerShape(22.dp))
        ) {
            socialLinks.forEachIndexed { index, link ->
                if (index > 0) {
                    Box(
                        modifier = Modifier
                            .padding(start = 62.dp)
                            .fillMaxWidth()
                            .height(1.dp)
                            .background(MaterialTheme.colorScheme.outlineVariant)
                    )
                }
                SocialLinkRow(
                    link = link,
                    onClick = { uriHandler.openUri(link.url) }
                )
            }
        }

        Spacer(modifier = Modifier.height(36.dp))

        ContinueButton(onClick = onContinue)

        Spacer(modifier = Modifier.height(20.dp))
    }
}

@Composable
private fun SocialLinkRow(link: SocialLink, onClick: () -> Unit) {
    val interactionSource = remember { MutableInteractionSource() }
    val isPressed by interactionSource.collectIsPressedAsState()
    val pressScale by animateFloatAsState(
        targetValue = if (isPressed) 0.985f else 1f,
        animationSpec = RowPressSpec,
        label = "socialRowPress"
    )

    Row(
        modifier = Modifier
            .fillMaxWidth()
            .graphicsLayer {
                scaleX = pressScale
                scaleY = pressScale
            }
            .clickable(
                interactionSource = interactionSource,
                indication = null,
                onClick = onClick
            )
            .padding(horizontal = 16.dp, vertical = 14.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Box(
            modifier = Modifier
                .size(34.dp)
                .neuInset(cornerRadius = 11.dp, depth = 3.dp)
                .clip(RoundedCornerShape(11.dp)),
            contentAlignment = Alignment.Center
        ) {
            Icon(
                imageVector = link.icon,
                contentDescription = null,
                tint = MaterialTheme.colorScheme.onSurfaceVariant,
                modifier = Modifier.size(17.dp)
            )
        }

        Column(
            modifier = Modifier
                .weight(1f)
                .padding(start = 12.dp)
        ) {
            Text(
                text = link.label,
                style = MaterialTheme.typography.bodyLarge,
                color = MaterialTheme.colorScheme.onSurface
            )
            Text(
                text = link.url.displayHost(),
                style = MaterialTheme.typography.bodySmall,
                color = MaterialTheme.colorScheme.onSurfaceVariant,
                maxLines = 1,
                overflow = TextOverflow.Ellipsis
            )
        }

        Icon(
            imageVector = Icons.Filled.OpenInNew,
            contentDescription = null,
            tint = MaterialTheme.colorScheme.onSurfaceVariant,
            modifier = Modifier.size(16.dp)
        )
    }
}

@Composable
private fun ContinueButton(onClick: () -> Unit) {
    val interactionSource = remember { MutableInteractionSource() }
    val isPressed by interactionSource.collectIsPressedAsState()
    val pressScale by animateFloatAsState(
        targetValue = if (isPressed) 0.97f else 1f,
        animationSpec = RowPressSpec,
        label = "continuePress"
    )

    Row(
        modifier = Modifier
            .fillMaxWidth()
            .height(54.dp)
            .graphicsLayer {
                scaleX = pressScale
                scaleY = pressScale
            }
            .then(
                if (isPressed) {
                    Modifier
                        .neuPressed(
                            cornerRadius = 18.dp,
                            depth = 6.dp,
                            fill = Neu.insetFill
                        )
                } else {
                    Modifier
                        .neuRaised(
                            cornerRadius = 18.dp,
                            depth = 6.dp,
                            fill = MaterialTheme.colorScheme.surfaceContainerLow
                        )
                        .border(
                            width = 1.dp,
                            color = MaterialTheme.colorScheme.outlineVariant,
                            shape = RoundedCornerShape(18.dp)
                        )
                }
            )
            .clip(RoundedCornerShape(18.dp))
            .clickable(
                interactionSource = interactionSource,
                indication = null,
                onClick = onClick
            ),
        horizontalArrangement = Arrangement.Center,
        verticalAlignment = Alignment.CenterVertically
    ) {
        Text(
            text = "Continue",
            style = MaterialTheme.typography.titleMedium,
            fontWeight = FontWeight.SemiBold,
            color = MaterialTheme.colorScheme.onSurface
        )
        Spacer(modifier = Modifier.size(10.dp))
        Icon(
            imageVector = Icons.Filled.ArrowForward,
            contentDescription = null,
            tint = MaterialTheme.colorScheme.onSurface,
            modifier = Modifier.size(18.dp)
        )
    }
}



