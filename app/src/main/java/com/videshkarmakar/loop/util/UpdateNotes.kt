package com.videshkarmakar.loop.util

/**
 * One changelog row on the Software Update screen.
 *
 * [tag] is the release-body heading the line was listed under ("New", "Fixes", ...), upper-cased
 * for the badge; it is null when the body has no headings.
 */
internal data class NoteItem(val tag: String?, val title: String, val body: String)

private val bulletPrefix = Regex("""^\s*(?:[-*•+]|\d+[.)])\s+""")
private val headingPrefix = Regex("""^#{1,6}\s*""")
private val htmlComment = Regex("""^<!--.*-->$""")

/** Headings that only say "these are the notes" and would make a useless badge. */
private val genericHeadings = setOf(
    "WHATS NEW",
    "WHAT'S NEW",
    "CHANGES",
    "CHANGELOG",
    "RELEASE NOTES",
    "NOTES",
    "UPDATES"
)

private const val MAX_TAG_LENGTH = 12
private const val MAX_ITEMS = 24

/**
 * Parse a GitHub release body into display rows.
 *
 * Markdown headings become the badge of every following line, bullets become rows and continuation
 * lines are folded into the row above. The first clause of a row is used as its title when the row
 * carries a separator (`Title: detail` or `Title — detail`), otherwise the whole line is the title.
 */
internal fun parseReleaseNotes(notes: String): List<NoteItem> {
    if (notes.isBlank()) return emptyList()

    val items = mutableListOf<NoteItem>()
    var tag: String? = null
    var pending: Pair<String?, String>? = null

    fun commit() {
        val row = pending ?: return
        pending = null
        val (rowTag, text) = row
        val trimmed = text.trim()
        if (trimmed.isBlank()) return
        val split = splitTitleAndBody(trimmed)
        items += NoteItem(tag = rowTag, title = split.first, body = split.second)
    }

    notes.replace("\r\n", "\n").split('\n').forEach { rawLine ->
        val line = rawLine.trim()
        when {
            line.isBlank() -> commit()

            htmlComment.matches(line) -> Unit

            headingPrefix.containsMatchIn(line) -> {
                commit()
                tag = headingPrefix.replace(line, "")
                    .trim()
                    .trimEnd(':')
                    .takeIf { it.isNotBlank() }
                    ?.toBadge()
            }

            bulletPrefix.containsMatchIn(line) -> {
                commit()
                pending = tag to bulletPrefix.replace(line, "")
            }

            else -> {
                val current = pending
                pending = if (current == null) {
                    tag to line
                } else {
                    current.first to "${current.second} $line"
                }
            }
        }
    }
    commit()

    return items.take(MAX_ITEMS)
}

private fun String.toBadge(): String? {
    val badge = uppercase().replace(Regex("""[^\p{L}\p{N} '&-]"""), "").trim()
    if (badge.isBlank() || badge in genericHeadings) return null
    return badge.take(MAX_TAG_LENGTH)
}

private fun splitTitleAndBody(text: String): Pair<String, String> {
    for (separator in listOf(": ", " — ", " – ")) {
        val index = text.indexOf(separator)
        if (index in 1..80) {
            return text.substring(0, index).trim() to text.substring(index + separator.length).trim()
        }
    }
    return text to ""
}
