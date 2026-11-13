package com.videshkarmakar.loop.ui.component

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.animation.core.tween
import androidx.compose.animation.expandVertically
import androidx.compose.animation.fadeIn
import androidx.compose.animation.fadeOut
import androidx.compose.animation.shrinkVertically
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
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.selection.toggleable
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.ExpandMore
import androidx.compose.material.icons.rounded.OpenInNew
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.rotate
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.platform.LocalUriHandler
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.semantics.Role
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.videshkarmakar.loop.R
import com.videshkarmakar.loop.ui.common.motion.emphasizeEasing
import com.videshkarmakar.loop.ui.theme.neuInset
import com.videshkarmakar.loop.ui.theme.neuRaised

private const val EXPAND_MILLIS = 280
private const val COLLAPSE_MILLIS = 220

/**
 * Settings section listing the developer's other releases, collapsed to a single row by default.
 *
 * Emphasis here is carried by material and tone, not by a highlight effect. A glowing outline or
 * a tinted gradient would be the fastest way to make this look like a call to action, but it
 * would also be the first thing that reads as synthetic -- and it would not match anything else
 * in the app. Instead the card is genuinely raised off the canvas (paired top-left/bottom-right
 * shadows from a single implied light source), one step brighter than its neighbours, and closed
 * with a hairline outline. That is the same vocabulary as every other surface in the theme, which
 * is what makes the emphasis read as deliberate rather than applied.
 */
@Composable
fun OtherProjectsSection(modifier: Modifier = Modifier) {
    val uriHandler = LocalUriHandler.current
    var expanded by rememberSaveable { mutableStateOf(false) }

    Column(modifier = modifier.fillMaxWidth()) {
        // No SettingTitle here on purpose. That composable renders at displaySmall (~36sp) and is
        // meant for a page header, not a section inside Settings -- using it put a 36sp copy of
        // this title directly above the 14sp copy in the card header, which doubled the height of
        // the section and made a 30-character label the loudest thing on the screen. The card
        // header carries the title instead, once, at a size that matches the rows around it.
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 16.dp, vertical = 8.dp)
                .neuRaised(
                    cornerRadius = 18.dp,
                    depth = 5.dp,
                    fill = MaterialTheme.colorScheme.surfaceContainerHigh
                )
                .border(
                    width = 1.dp,
                    color = MaterialTheme.colorScheme.outlineVariant,
                    shape = RoundedCornerShape(18.dp)
                )
                .clip(RoundedCornerShape(18.dp))
        ) {
            // ---- Header: always visible, doubles as the expand control ----
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .toggleable(
                        value = expanded,
                        role = Role.Button,
                        onValueChange = { expanded = it }
                    )
                    .padding(horizontal = 14.dp, vertical = 11.dp),
                verticalAlignment = Alignment.CenterVertically
            ) {
                Image(
                    painter = painterResource(id = R.drawable.ic_project_durga_puja),
                    contentDescription = null,
                    modifier = Modifier
                        .size(34.dp)
                        .clip(RoundedCornerShape(10.dp))
                )

                Column(
                    modifier = Modifier
                        .weight(1f)
                        .padding(start = 11.dp)
                ) {
                    Text(
                        text = stringResource(id = R.string.other_projects_title),
                        style = MaterialTheme.typography.bodySmall,
                        fontWeight = FontWeight.Medium,
                        color = MaterialTheme.colorScheme.onSurface,
                        maxLines = 1,
                        overflow = TextOverflow.Ellipsis
                    )
                    Spacer(modifier = Modifier.height(1.dp))
                    Text(
                        text = stringResource(id = R.string.other_projects_count),
                        style = MaterialTheme.typography.labelSmall,
                        color = MaterialTheme.colorScheme.onSurfaceVariant,
                        maxLines = 1
                    )
                }

                val chevronRotation by animateFloatAsState(
                    targetValue = if (expanded) 180f else 0f,
                    animationSpec = tween(
                        durationMillis = if (expanded) EXPAND_MILLIS else COLLAPSE_MILLIS,
                        easing = emphasizeEasing
                    ),
                    label = "otherProjectsChevron"
                )
                Icon(
                    imageVector = Icons.Rounded.ExpandMore,
                    contentDescription = null,
                    tint = MaterialTheme.colorScheme.onSurfaceVariant,
                    modifier = Modifier.rotate(chevronRotation)
                )
            }

            // ---- Body ----
            AnimatedVisibility(
                visible = expanded,
                enter = expandVertically(
                    animationSpec = tween(EXPAND_MILLIS, easing = emphasizeEasing),
                    expandFrom = Alignment.Top
                ) + fadeIn(animationSpec = tween(EXPAND_MILLIS, easing = emphasizeEasing)),
                exit = shrinkVertically(
                    animationSpec = tween(COLLAPSE_MILLIS, easing = emphasizeEasing),
                    shrinkTowards = Alignment.Top
                ) + fadeOut(animationSpec = tween(COLLAPSE_MILLIS, easing = emphasizeEasing))
            ) {
                Column(modifier = Modifier.padding(start = 16.dp, end = 16.dp, bottom = 16.dp)) {
                    Box(
                        modifier = Modifier
                            .fillMaxWidth()
                            .height(1.dp)
                            .background(MaterialTheme.colorScheme.outlineVariant)
                    )
                    Spacer(modifier = Modifier.height(14.dp))

                    Row(verticalAlignment = Alignment.CenterVertically) {
                        Image(
                            painter = painterResource(id = R.drawable.ic_project_durga_puja),
                            contentDescription = stringResource(
                                id = R.string.project_durga_puja_title
                            ),
                            modifier = Modifier
                                .size(48.dp)
                                .clip(RoundedCornerShape(14.dp))
                        )

                        Column(
                            modifier = Modifier
                                .weight(1f)
                                .padding(start = 13.dp)
                        ) {
                            Text(
                                text = stringResource(id = R.string.project_durga_puja_title),
                                style = MaterialTheme.typography.titleSmall,
                                fontWeight = FontWeight.SemiBold,
                                color = MaterialTheme.colorScheme.onSurface,
                                maxLines = 2,
                                overflow = TextOverflow.Ellipsis
                            )
                            Spacer(modifier = Modifier.height(3.dp))
                            Text(
                                text = stringResource(id = R.string.project_durga_puja_bengali),
                                style = MaterialTheme.typography.bodyMedium,
                                color = MaterialTheme.colorScheme.onSurfaceVariant,
                                maxLines = 1
                            )
                        }
                    }

                    Spacer(modifier = Modifier.height(12.dp))

                    Text(
                        text = stringResource(id = R.string.project_durga_puja_desc),
                        style = MaterialTheme.typography.bodySmall,
                        color = MaterialTheme.colorScheme.onSurfaceVariant,
                        lineHeight = 18.sp
                    )

                    Spacer(modifier = Modifier.height(12.dp))

                    ProjectLinkWell(
                        label = stringResource(id = R.string.project_durga_puja_link_one),
                        onClick = { uriHandler.openUri("https://pujavromon.vercel.app/") }
                    )
                    Spacer(modifier = Modifier.height(8.dp))
                    ProjectLinkWell(
                        label = stringResource(id = R.string.project_durga_puja_link_two),
                        onClick = { uriHandler.openUri("https://pujovromon.ai.studio/") }
                    )
                }
            }
        }
    }
}

/**
 * A recessed well rather than a filled button. Recessing is what makes it read as pressable
 * without needing a colour fill or a glow to announce interactivity.
 */
@Composable
private fun ProjectLinkWell(label: String, onClick: () -> Unit) {
    val interactionSource = remember { MutableInteractionSource() }
    val isPressed by interactionSource.collectIsPressedAsState()
    val pressScale by animateFloatAsState(
        targetValue = if (isPressed) 0.985f else 1f,
        animationSpec = tween(durationMillis = 120),
        label = "projectLinkPress"
    )

    Row(
        modifier = Modifier
            .fillMaxWidth()
            .graphicsLayer {
                scaleX = pressScale
                scaleY = pressScale
            }
            .neuInset(cornerRadius = 14.dp, depth = 4.dp)
            .clickable(
                interactionSource = interactionSource,
                indication = null,
                onClick = onClick
            )
            .padding(horizontal = 16.dp, vertical = 13.dp),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.SpaceBetween
    ) {
        Text(
            text = label,
            style = MaterialTheme.typography.bodyMedium,
            color = MaterialTheme.colorScheme.onSurface,
            maxLines = 1,
            overflow = TextOverflow.Ellipsis
        )
        Box(
            modifier = Modifier
                .padding(start = 12.dp)
                .size(18.dp),
            contentAlignment = Alignment.Center
        ) {
            Icon(
                imageVector = Icons.Rounded.OpenInNew,
                contentDescription = null,
                tint = MaterialTheme.colorScheme.onSurfaceVariant,
                modifier = Modifier.size(15.dp)
            )
        }
    }
}

