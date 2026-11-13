package com.videshkarmakar.loop.database.backup

import com.videshkarmakar.loop.database.objects.CommandTemplate
import com.videshkarmakar.loop.database.objects.DownloadedVideoInfo
import com.videshkarmakar.loop.database.objects.OptionShortcut
import kotlinx.serialization.Serializable

@Serializable
data class Backup(
    val templates: List<CommandTemplate>? = null,
    val shortcuts: List<OptionShortcut>? = null,
    val downloadHistory: List<DownloadedVideoInfo>? = null
)

