package com.videshkarmakar.loop.ui.component

import androidx.compose.animation.animateColorAsState
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
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
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
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.AsyncImage

/** Corner radius of a navigation row. Rounded, but not a pill -- a pill at this height reads as a chip. */
private val RowShape = RoundedCornerShape(12.dp)

private val HeaderShape = CircleShape

private const val PressMillis = 110
private const val TintMillis = 180

/**
 * Profile block that opens the settings panel: portrait, name, role line.
 *
 * The portrait carries a hairline ring in the primary tone. It is the only place in this panel
 * where the brand colour touches a static element, so the ring reads as identity rather than as
 * an accent competing with the selected row further down.
 */
@Composable
fun SettingsProfileHeader(
    portraitUrl: String,
    name: String,
    subtitle: String,
    modifier: Modifier = Modifier
) {
    Row(
        modifier = modifier
            .fillMaxWidth()
            .padding(start = 20.dp, end = 20.dp, top = 20.dp, bottom = 24.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        AsyncImage(
            model = portraitUrl,
            contentDescription = name,
            modifier = Modifier
                .size(52.dp)
                .border(2.dp, MaterialTheme.colorScheme.primary, HeaderShape)
                .clip(HeaderShape)
        )

        Column(modifier = Modifier.padding(start = 14.dp)) {
            Text(
                text = name,
                style = MaterialTheme.typography.titleMedium,
                fontWeight = FontWeight.Bold,
                color = MaterialTheme.colorScheme.onSurface,
                maxLines = 1,
                overflow = TextOverflow.Ellipsis
            )
            Spacer(modifier = Modifier.height(2.dp))
            Text(
                text = subtitle,
                style = MaterialTheme.typography.bodySmall,
                color = MaterialTheme.colorScheme.onSurfaceVariant,
                fontSize = 12.sp,
                maxLines = 1,
                overflow = TextOverflow.Ellipsis
            )
        }
    }
}

/**
 * One row of the settings panel.
 *
 * Selection is a filled pill in the primary tone with [MaterialTheme.colorScheme.onPrimary] text,
 * matching how the panel reads at a glance: exactly one row carries the fill, so "where am I"
 * needs no label and no arrow. Unselected rows stay flat -- an outline or a tint on every row
 * would give the panel eight equally loud entries and no hierarchy.
 *
 * [badge] is for state the user cannot otherwise see from the panel itself, e.g. that audio
 * extraction is switched on. It is a flat chip, not a filled badge, so it never competes with the
 * selected pill.
 */
@Composable
fun SettingsNavRow(
    title: String,
    icon: ImageVector,
    selected: Boolean,
    onClick: () -> Unit,
    modifier: Modifier = Modifier,
    badge: SettingsBadge? = null
) {
    val interactionSource = remember { MutableInteractionSource() }
    val isPressed by interactionSource.collectIsPressedAsState()

    val pressScale by animateFloatAsState(
        targetValue = if (isPressed) 0.985f else 1f,
        animationSpec = tween(PressMillis),
        label = "settingsRowPress"
    )

    val container by animateColorAsState(
        targetValue = when {
            selected -> MaterialTheme.colorScheme.primary
            isPressed -> MaterialTheme.colorScheme.surfaceContainerHigh
            else -> MaterialTheme.colorScheme.surface
        },
        animationSpec = tween(TintMillis),
        label = "settingsRowContainer"
    )

    val contentColor by animateColorAsState(
        targetValue = if (selected) MaterialTheme.colorScheme.onPrimary
        else MaterialTheme.colorScheme.onSurface,
        animationSpec = tween(TintMillis),
        label = "settingsRowContent"
    )

    val supportingColor by animateColorAsState(
        targetValue = if (selected) MaterialTheme.colorScheme.onPrimary.copy(alpha = 0.7f)
        else MaterialTheme.colorScheme.onSurfaceVariant,
        animationSpec = tween(TintMillis),
        label = "settingsRowSupporting"
    )

    Row(
        modifier = modifier
            .fillMaxWidth()
            .padding(horizontal = 20.dp, vertical = 2.dp)
            .graphicsLayer {
                scaleX = pressScale
                scaleY = pressScale
            }
            .clip(RowShape)
            .background(container)
            .clickable(
                interactionSource = interactionSource,
                indication = null
            ) { onClick() }
            .padding(horizontal = 14.dp, vertical = 13.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Icon(
            imageVector = icon,
            contentDescription = null,
            modifier = Modifier.size(18.dp),
            tint = supportingColor
        )
        Text(
            text = title,
            modifier = Modifier
                .weight(1f)
                .padding(start = 14.dp, end = 10.dp),
            style = MaterialTheme.typography.bodyMedium,
            fontWeight = if (selected) FontWeight.SemiBold else FontWeight.Medium,
            color = contentColor,
            maxLines = 1,
            overflow = TextOverflow.Ellipsis
        )
        badge?.let { b ->
            Row(
                modifier = Modifier
                    .clip(RoundedCornerShape(6.dp))
                    .background(supportingColor.copy(alpha = 0.14f))
                    .padding(horizontal = 7.dp, vertical = 3.dp),
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.spacedBy(4.dp)
            ) {
                Icon(
                    imageVector = b.icon,
                    contentDescription = null,
                    modifier = Modifier.size(11.dp),
                    tint = supportingColor
                )
                Text(
                    text = b.label,
                    style = MaterialTheme.typography.labelSmall,
                    fontSize = 10.sp,
                    fontWeight = FontWeight.Medium,
                    color = supportingColor,
                    maxLines = 1
                )
            }
        }
    }
}

/** State a row cannot show on its own, e.g. that audio extraction is switched on. */
data class SettingsBadge(
    val label: String,
    val icon: ImageVector
)

/**
 * Hairline between two groups of rows.
 *
 * Inset to the row's text edge rather than run edge to edge, so the divider groups the rows instead
 * of cutting the panel into bands.
 */
@Composable
fun SettingsGroupDivider(modifier: Modifier = Modifier) {
    Box(
        modifier = modifier
            .fillMaxWidth()
            .padding(start = 48.dp, end = 20.dp)
            .height(1.dp)
            .background(MaterialTheme.colorScheme.outlineVariant)
    )
}

/**
 * Compact social row for the settings panel.
 *
 * Circles rather than text labels: five words in a row cannot fit the panel width without
 * wrapping, and the glyphs already carry the meaning for anyone who recognises them.
 */
@Composable
fun SettingsSocialRow(
    links: List<SettingsSocialLink>,
    modifier: Modifier = Modifier
) {
    val uriHandler = LocalUriHandler.current
    Row(
        modifier = modifier
            .fillMaxWidth()
            .padding(horizontal = 20.dp, vertical = 4.dp),
        horizontalArrangement = Arrangement.spacedBy(10.dp)
    ) {
        links.forEach { link ->
            val interactionSource = remember { MutableInteractionSource() }
            val isPressed by interactionSource.collectIsPressedAsState()
            val pressScale by animateFloatAsState(
                targetValue = if (isPressed) 0.90f else 1f,
                animationSpec = tween(PressMillis),
                label = "socialPress"
            )

            Box(
                modifier = Modifier
                    .size(40.dp)
                    .graphicsLayer {
                        scaleX = pressScale
                        scaleY = pressScale
                    }
                    .clip(CircleShape)
                    .background(MaterialTheme.colorScheme.surfaceContainerHigh)
                    .clickable(
                        interactionSource = interactionSource,
                        indication = null
                    ) { uriHandler.openUri(link.url) },
                contentAlignment = Alignment.Center
            ) {
                Icon(
                    imageVector = link.icon,
                    contentDescription = link.label,
                    modifier = Modifier.size(18.dp),
                    tint = MaterialTheme.colorScheme.onSurfaceVariant
                )
            }
        }
    }
}

data class SettingsSocialLink(
    val icon: ImageVector,
    val label: String,
    val url: String
)