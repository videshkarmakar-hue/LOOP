package com.videshkarmakar.loop.ui.page.feedback

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
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.Feedback
import androidx.compose.material.icons.outlined.WarningAmber
import androidx.compose.material.icons.rounded.Check
import androidx.compose.material3.Icon
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.SolidColor
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

private val Base = Color(0xFF131416)
private val CardBg = Color(0xFF1B1C20)
private val Border = Color(0xFF25272F)
private val SelectedBg = Color(0xFF242730)
private val SelectedBorder = Color(0xFF434756)
private val Accent = Color(0xFFF75254)
private val AccentHover = Color(0xFFE54345)
private val SubmitInactive = Color(0xFF23252C)
private val SubmitInactiveBorder = Color(0xFF2C2E38)
private val TextPrimary = Color(0xFFFFFFFF)
private val TextSecondary = Color(0xFFE5E7EB)
private val TextMuted = Color(0xFF8E929E)
private val TextOption = Color(0xFFA6ABB7)
private val Placeholder = Color(0xFF585B65)

@Composable
fun ReportFeedbackPage(
    onNavigateBack: () -> Unit
) {
    var selectedCategory by remember { mutableStateOf("") }
    var description by remember { mutableStateOf("") }
    var contactEmail by remember { mutableStateOf("") }
    var submitted by remember { mutableStateOf(false) }

    val categories = listOf(
        "Bug Report",
        "Feature Request",
        "Download Issue",
        "Performance Problem",
        "UI/UX Feedback",
        "Other"
    )

    val canSubmit = selectedCategory.isNotEmpty() && description.isNotBlank()

    Surface(
        modifier = Modifier.fillMaxSize(),
        color = Base
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .verticalScroll(rememberScrollState())
                .padding(horizontal = 20.dp)
                .padding(top = 12.dp, bottom = 112.dp)
        ) {
            Text(
                text = "Report / Feedback",
                fontSize = 25.sp,
                fontWeight = FontWeight.Bold,
                color = TextPrimary,
                letterSpacing = (-0.4).sp
            )
            Spacer(modifier = Modifier.height(8.dp))
            Text(
                text = "Tell us about any issues, suggestions, or feedback you have. We're here to help!",
                fontSize = 13.5.sp,
                lineHeight = 21.sp,
                color = TextMuted
            )

            Spacer(modifier = Modifier.height(24.dp))

            if (submitted) {
                Column(
                    modifier = Modifier
                        .fillMaxWidth()
                        .clip(RoundedCornerShape(16.dp))
                        .background(CardBg)
                        .border(1.dp, Border, RoundedCornerShape(16.dp))
                        .padding(24.dp),
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    Icon(
                        imageVector = Icons.Outlined.Feedback,
                        contentDescription = null,
                        tint = Accent,
                        modifier = Modifier.size(28.dp)
                    )
                    Spacer(modifier = Modifier.height(12.dp))
                    Text(
                        text = "Thank You!",
                        fontSize = 20.sp,
                        fontWeight = FontWeight.Bold,
                        color = TextPrimary
                    )
                    Spacer(modifier = Modifier.height(8.dp))
                    Text(
                        text = "Your report has been submitted successfully. We'll review it and get back to you if needed.",
                        fontSize = 14.sp,
                        lineHeight = 21.sp,
                        color = TextOption
                    )
                    Spacer(modifier = Modifier.height(16.dp))
                    Box(
                        modifier = Modifier
                            .fillMaxWidth()
                            .height(48.dp)
                            .clip(RoundedCornerShape(12.dp))
                            .background(Accent)
                            .clickable {
                                submitted = false
                                selectedCategory = ""
                                description = ""
                                contactEmail = ""
                            },
                        contentAlignment = Alignment.Center
                    ) {
                        Text(
                            text = "Submit Another",
                            fontSize = 14.sp,
                            fontWeight = FontWeight.SemiBold,
                            color = Color.White
                        )
                    }
                }
            } else {
                // Category
                Text(
                    text = "Category",
                    fontSize = 15.sp,
                    fontWeight = FontWeight.Bold,
                    color = TextPrimary
                )
                Spacer(modifier = Modifier.height(12.dp))
                Column(verticalArrangement = Arrangement.spacedBy(10.dp)) {
                    categories.forEach { category ->
                        val selected = selectedCategory == category
                        Row(
                            modifier = Modifier
                                .fillMaxWidth()
                                .clip(RoundedCornerShape(12.dp))
                                .background(if (selected) SelectedBg else CardBg)
                                .border(
                                    1.dp,
                                    if (selected) SelectedBorder else Border,
                                    RoundedCornerShape(12.dp)
                                )
                                .clickable { selectedCategory = category }
                                .padding(horizontal = 16.dp, vertical = 14.dp),
                            verticalAlignment = Alignment.CenterVertically
                        ) {
                            Text(
                                text = category,
                                modifier = Modifier.weight(1f),
                                fontSize = 14.sp,
                                fontWeight = FontWeight.Medium,
                                color = if (selected) TextPrimary else TextOption
                            )
                            if (selected) {
                                Icon(
                                    imageVector = Icons.Rounded.Check,
                                    contentDescription = null,
                                    tint = Accent,
                                    modifier = Modifier.size(16.dp)
                                )
                            }
                        }
                    }
                }

                Spacer(modifier = Modifier.height(24.dp))

                // Description
                Text(
                    text = "Description",
                    fontSize = 15.sp,
                    fontWeight = FontWeight.Bold,
                    color = TextPrimary
                )
                Spacer(modifier = Modifier.height(8.dp))
                Box(
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(120.dp)
                        .clip(RoundedCornerShape(16.dp))
                        .background(CardBg)
                        .border(1.dp, Border, RoundedCornerShape(16.dp))
                        .padding(16.dp)
                ) {
                    if (description.isEmpty()) {
                        Text(
                            text = "Describe your issue or feedback",
                            fontSize = 14.sp,
                            color = Placeholder,
                            lineHeight = 21.sp
                        )
                    }
                    BasicTextField(
                        value = description,
                        onValueChange = { description = it },
                        modifier = Modifier.fillMaxSize(),
                        textStyle = TextStyle(
                            color = TextSecondary,
                            fontSize = 14.sp,
                            lineHeight = 21.sp
                        ),
                        cursorBrush = SolidColor(Accent)
                    )
                }

                Spacer(modifier = Modifier.height(24.dp))

                // Contact Email
                Text(
                    text = buildAnnotatedString {
                        withStyle(SpanStyle(color = TextPrimary, fontWeight = FontWeight.Bold, fontSize = 15.sp)) {
                            append("Contact Email ")
                        }
                        withStyle(SpanStyle(color = TextMuted, fontWeight = FontWeight.Normal, fontSize = 13.sp)) {
                            append("(Optional)")
                        }
                    }
                )
                Spacer(modifier = Modifier.height(8.dp))
                Box(
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(52.dp)
                        .clip(RoundedCornerShape(12.dp))
                        .background(CardBg)
                        .border(1.dp, Border, RoundedCornerShape(12.dp))
                        .padding(horizontal = 16.dp),
                    contentAlignment = Alignment.CenterStart
                ) {
                    if (contactEmail.isEmpty()) {
                        Text(
                            text = "your@email.com",
                            fontSize = 14.sp,
                            color = Placeholder
                        )
                    }
                    BasicTextField(
                        value = contactEmail,
                        onValueChange = { contactEmail = it },
                        modifier = Modifier.fillMaxWidth(),
                        singleLine = true,
                        textStyle = TextStyle(
                            color = TextSecondary,
                            fontSize = 14.sp
                        ),
                        cursorBrush = SolidColor(Accent)
                    )
                }

                Spacer(modifier = Modifier.height(24.dp))

                // Submit
                val submitBg = if (canSubmit) Accent else SubmitInactive
                val submitBorder = if (canSubmit) Color.Transparent else SubmitInactiveBorder
                val submitContent = if (canSubmit) Color.White else Color(0xFF717684)
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(52.dp)
                        .clip(RoundedCornerShape(12.dp))
                        .background(submitBg)
                        .border(1.dp, submitBorder, RoundedCornerShape(12.dp))
                        .clickable(enabled = canSubmit) {
                            if (canSubmit) submitted = true
                        },
                    horizontalArrangement = Arrangement.Center,
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Icon(
                        imageVector = Icons.Outlined.WarningAmber,
                        contentDescription = null,
                        tint = submitContent,
                        modifier = Modifier.size(16.dp)
                    )
                    Spacer(modifier = Modifier.size(8.dp))
                    Text(
                        text = "Submit Report",
                        fontSize = 14.sp,
                        fontWeight = FontWeight.SemiBold,
                        color = submitContent
                    )
                }
            }

            Spacer(modifier = Modifier.height(32.dp))
        }
    }
}
