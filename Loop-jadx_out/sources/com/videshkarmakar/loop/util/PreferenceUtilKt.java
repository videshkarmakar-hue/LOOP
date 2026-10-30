package com.videshkarmakar.loop.util;

import androidx.constraintlayout.widget.ConstraintLayout;
import com.kyant.monet.PaletteStyle;
import com.tencent.mmkv.MMKV;
import com.videshkarmakar.loop.C3070R;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.TuplesKt;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: PreferenceUtil.kt */
/* JADX INFO: loaded from: classes10.dex */
@Metadata(m194d1 = {"\u00008\n\u0000\n\u0002\u0010\u000e\n\u0002\b\n\n\u0002\u0010$\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u000e\n\u0002\u0010\t\n\u0002\bY\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0004\u001a\u000b\u0010\u0082\u0001\u001a\u00020\u0001*\u00020\u0001\"\u000e\u0010\u0000\u001a\u00020\u0001X\u0086T¢\u0006\u0002\n\u0000\"\u000e\u0010\u0002\u001a\u00020\u0001X\u0086T¢\u0006\u0002\n\u0000\"\u000e\u0010\u0003\u001a\u00020\u0001X\u0086T¢\u0006\u0002\n\u0000\"\u000e\u0010\u0004\u001a\u00020\u0001X\u0086T¢\u0006\u0002\n\u0000\"\u000e\u0010\u0005\u001a\u00020\u0001X\u0086T¢\u0006\u0002\n\u0000\"\u000e\u0010\u0006\u001a\u00020\u0001X\u0086T¢\u0006\u0002\n\u0000\"\u000e\u0010\u0007\u001a\u00020\u0001X\u0086T¢\u0006\u0002\n\u0000\"\u000e\u0010\b\u001a\u00020\u0001X\u0086T¢\u0006\u0002\n\u0000\"\u000e\u0010\t\u001a\u00020\u0001X\u0086T¢\u0006\u0002\n\u0000\"\u000e\u0010\n\u001a\u00020\u0001X\u0086T¢\u0006\u0002\n\u0000\"\u001a\u0010\u000b\u001a\u000e\u0012\u0004\u0012\u00020\u0001\u0012\u0004\u0012\u00020\r0\fX\u0082\u0004¢\u0006\u0002\n\u0000\"\u000e\u0010\u000e\u001a\u00020\u0001X\u0086T¢\u0006\u0002\n\u0000\"\u000e\u0010\u000f\u001a\u00020\u0001X\u0086T¢\u0006\u0002\n\u0000\"\u000e\u0010\u0010\u001a\u00020\u0001X\u0086T¢\u0006\u0002\n\u0000\"\u000e\u0010\u0011\u001a\u00020\u0001X\u0086T¢\u0006\u0002\n\u0000\"\u000e\u0010\u0012\u001a\u00020\u0013X\u0086T¢\u0006\u0002\n\u0000\"\u000e\u0010\u0014\u001a\u00020\u0013X\u0086T¢\u0006\u0002\n\u0000\"\u000e\u0010\u0015\u001a\u00020\u0013X\u0086T¢\u0006\u0002\n\u0000\"\u000e\u0010\u0016\u001a\u00020\u0013X\u0086T¢\u0006\u0002\n\u0000\"\u000e\u0010\u0017\u001a\u00020\u0013X\u0086T¢\u0006\u0002\n\u0000\"\u000e\u0010\u0018\u001a\u00020\u0001X\u0086T¢\u0006\u0002\n\u0000\"\u000e\u0010\u0019\u001a\u00020\u0013X\u0086T¢\u0006\u0002\n\u0000\"\u000e\u0010\u001a\u001a\u00020\u0001X\u0086T¢\u0006\u0002\n\u0000\"\u000e\u0010\u001b\u001a\u00020\u0001X\u0086T¢\u0006\u0002\n\u0000\"\u000e\u0010\u001c\u001a\u00020\u0001X\u0086T¢\u0006\u0002\n\u0000\"\u000e\u0010\u001d\u001a\u00020\u0001X\u0086T¢\u0006\u0002\n\u0000\"\u000e\u0010\u001e\u001a\u00020\u0001X\u0086T¢\u0006\u0002\n\u0000\"\u000e\u0010\u001f\u001a\u00020\u0001X\u0086T¢\u0006\u0002\n\u0000\"\u000e\u0010 \u001a\u00020\u0013X\u0086T¢\u0006\u0002\n\u0000\"\u000e\u0010!\u001a\u00020\"X\u0086T¢\u0006\u0002\n\u0000\"\u000e\u0010#\u001a\u00020\u0001X\u0086T¢\u0006\u0002\n\u0000\"\u000e\u0010$\u001a\u00020\u0001X\u0086T¢\u0006\u0002\n\u0000\"\u000e\u0010%\u001a\u00020\u0001X\u0086T¢\u0006\u0002\n\u0000\"\u000e\u0010&\u001a\u00020\u0001X\u0082T¢\u0006\u0002\n\u0000\"\u000e\u0010'\u001a\u00020\u0001X\u0086T¢\u0006\u0002\n\u0000\"\u000e\u0010(\u001a\u00020\u0001X\u0086T¢\u0006\u0002\n\u0000\"\u000e\u0010)\u001a\u00020\u0001X\u0086T¢\u0006\u0002\n\u0000\"\u000e\u0010*\u001a\u00020\u0001X\u0086T¢\u0006\u0002\n\u0000\"\u000e\u0010+\u001a\u00020\u0001X\u0086T¢\u0006\u0002\n\u0000\"\u000e\u0010,\u001a\u00020\u0013X\u0086T¢\u0006\u0002\n\u0000\"\u000e\u0010-\u001a\u00020\u0013X\u0086T¢\u0006\u0002\n\u0000\"\u000e\u0010.\u001a\u00020\u0001X\u0086T¢\u0006\u0002\n\u0000\"\u000e\u0010/\u001a\u00020\u0001X\u0086T¢\u0006\u0002\n\u0000\"\u000e\u00100\u001a\u00020\u0001X\u0086T¢\u0006\u0002\n\u0000\"\u000e\u00101\u001a\u00020\u0013X\u0086T¢\u0006\u0002\n\u0000\"\u000e\u00102\u001a\u00020\u0001X\u0082T¢\u0006\u0002\n\u0000\"\u000e\u00103\u001a\u00020\"X\u0082T¢\u0006\u0002\n\u0000\"\u000e\u00104\u001a\u00020\"X\u0082T¢\u0006\u0002\n\u0000\"\u000e\u00105\u001a\u00020\"X\u0082T¢\u0006\u0002\n\u0000\"\u001a\u00106\u001a\u000e\u0012\u0004\u0012\u00020\u0001\u0012\u0004\u0012\u00020\u00130\fX\u0082\u0004¢\u0006\u0002\n\u0000\"\u000e\u00107\u001a\u00020\u0001X\u0086T¢\u0006\u0002\n\u0000\"\u000e\u00108\u001a\u00020\u0001X\u0082T¢\u0006\u0002\n\u0000\"\u000e\u00109\u001a\u00020\u0013X\u0086T¢\u0006\u0002\n\u0000\"\u001a\u0010:\u001a\u000e\u0012\u0004\u0012\u00020\u0001\u0012\u0004\u0012\u00020\"0\fX\u0082\u0004¢\u0006\u0002\n\u0000\"\u000e\u0010;\u001a\u00020\u0013X\u0086T¢\u0006\u0002\n\u0000\"\u000e\u0010<\u001a\u00020\u0001X\u0086T¢\u0006\u0002\n\u0000\"\u000e\u0010=\u001a\u00020\u0001X\u0086T¢\u0006\u0002\n\u0000\"\u000e\u0010>\u001a\u00020\u0013X\u0086T¢\u0006\u0002\n\u0000\"\u000e\u0010?\u001a\u00020\u0001X\u0086T¢\u0006\u0002\n\u0000\"\u000e\u0010@\u001a\u00020\u0001X\u0086T¢\u0006\u0002\n\u0000\"\u000e\u0010A\u001a\u00020\u0013X\u0086T¢\u0006\u0002\n\u0000\"\u000e\u0010B\u001a\u00020\u0001X\u0086T¢\u0006\u0002\n\u0000\"\u000e\u0010C\u001a\u00020\u0013X\u0086T¢\u0006\u0002\n\u0000\"\u000e\u0010D\u001a\u00020\u0013X\u0086T¢\u0006\u0002\n\u0000\"\u000e\u0010E\u001a\u00020\u0013X\u0086T¢\u0006\u0002\n\u0000\"\u000e\u0010F\u001a\u00020\u0001X\u0086T¢\u0006\u0002\n\u0000\"\u000e\u0010G\u001a\u00020\u0001X\u0086T¢\u0006\u0002\n\u0000\"\u000e\u0010H\u001a\u00020\u0001X\u0086T¢\u0006\u0002\n\u0000\"\u000e\u0010I\u001a\u00020\u0013X\u0086T¢\u0006\u0002\n\u0000\"\u000e\u0010J\u001a\u00020\u0001X\u0086T¢\u0006\u0002\n\u0000\"\u000e\u0010K\u001a\u00020\u0001X\u0086T¢\u0006\u0002\n\u0000\"\u000e\u0010L\u001a\u00020\u0001X\u0086T¢\u0006\u0002\n\u0000\"\u000e\u0010M\u001a\u00020\u0001X\u0086T¢\u0006\u0002\n\u0000\"\u000e\u0010N\u001a\u00020\u0001X\u0086T¢\u0006\u0002\n\u0000\"\u000e\u0010O\u001a\u00020\u0001X\u0086T¢\u0006\u0002\n\u0000\"\u000e\u0010P\u001a\u00020\u0001X\u0086T¢\u0006\u0002\n\u0000\"\u000e\u0010Q\u001a\u00020\u0001X\u0086T¢\u0006\u0002\n\u0000\"\u000e\u0010R\u001a\u00020\u0001X\u0086T¢\u0006\u0002\n\u0000\"\u000e\u0010S\u001a\u00020\u0001X\u0086T¢\u0006\u0002\n\u0000\"\u000e\u0010T\u001a\u00020\u0001X\u0086T¢\u0006\u0002\n\u0000\"\u000e\u0010U\u001a\u00020\u0001X\u0086T¢\u0006\u0002\n\u0000\"\u000e\u0010V\u001a\u00020\u0013X\u0086T¢\u0006\u0002\n\u0000\"\u000e\u0010W\u001a\u00020\u0013X\u0086T¢\u0006\u0002\n\u0000\"\u000e\u0010X\u001a\u00020\u0013X\u0086T¢\u0006\u0002\n\u0000\"\u000e\u0010Y\u001a\u00020\u0013X\u0086T¢\u0006\u0002\n\u0000\"\u000e\u0010Z\u001a\u00020\u0013X\u0086T¢\u0006\u0002\n\u0000\"\u000e\u0010[\u001a\u00020\u0013X\u0086T¢\u0006\u0002\n\u0000\"\u000e\u0010\\\u001a\u00020\u0001X\u0086T¢\u0006\u0002\n\u0000\"\u000e\u0010]\u001a\u00020\u0001X\u0086T¢\u0006\u0002\n\u0000\"\u000e\u0010^\u001a\u00020\u0001X\u0086T¢\u0006\u0002\n\u0000\"\u000e\u0010_\u001a\u00020\u0001X\u0086T¢\u0006\u0002\n\u0000\"\u000e\u0010`\u001a\u00020\u0013X\u0086T¢\u0006\u0002\n\u0000\"\u001a\u0010a\u001a\u000e\u0012\u0004\u0012\u00020\u0001\u0012\u0004\u0012\u00020\u00010\fX\u0082\u0004¢\u0006\u0002\n\u0000\"\u000e\u0010b\u001a\u00020\u0001X\u0086T¢\u0006\u0002\n\u0000\"\u000e\u0010c\u001a\u00020\u0001X\u0086T¢\u0006\u0002\n\u0000\"\u000e\u0010d\u001a\u00020\u0001X\u0086T¢\u0006\u0002\n\u0000\"\u000e\u0010e\u001a\u00020\u0001X\u0082T¢\u0006\u0002\n\u0000\"\u000e\u0010f\u001a\u00020\u0001X\u0086T¢\u0006\u0002\n\u0000\"\u000e\u0010g\u001a\u00020\u0013X\u0086T¢\u0006\u0002\n\u0000\"\u000e\u0010h\u001a\u00020\u0001X\u0086T¢\u0006\u0002\n\u0000\"\u000e\u0010i\u001a\u00020\u0001X\u0086T¢\u0006\u0002\n\u0000\"\u000e\u0010j\u001a\u00020\u0001X\u0086T¢\u0006\u0002\n\u0000\"\u000e\u0010k\u001a\u00020\u0013X\u0086T¢\u0006\u0002\n\u0000\"\u001d\u0010l\u001a\u000e\u0012\u0004\u0012\u00020\"\u0012\u0004\u0012\u00020\u00130\f¢\u0006\b\n\u0000\u001a\u0004\bm\u0010n\"\u000e\u0010o\u001a\u00020\u0001X\u0086T¢\u0006\u0002\n\u0000\"\u000e\u0010p\u001a\u00020\u0001X\u0086T¢\u0006\u0002\n\u0000\"\u000e\u0010q\u001a\u00020\u0001X\u0086T¢\u0006\u0002\n\u0000\"\u000e\u0010r\u001a\u00020\u0001X\u0086T¢\u0006\u0002\n\u0000\"\u000e\u0010s\u001a\u00020\u0001X\u0086T¢\u0006\u0002\n\u0000\"\u000e\u0010t\u001a\u00020\u0001X\u0086T¢\u0006\u0002\n\u0000\"\u000e\u0010u\u001a\u00020\u0013X\u0086T¢\u0006\u0002\n\u0000\"\u000e\u0010v\u001a\u00020\u0013X\u0086T¢\u0006\u0002\n\u0000\"\u000e\u0010w\u001a\u00020\u0001X\u0086T¢\u0006\u0002\n\u0000\"\u000e\u0010x\u001a\u00020\u0001X\u0086T¢\u0006\u0002\n\u0000\"\u000e\u0010y\u001a\u00020\u0001X\u0086T¢\u0006\u0002\n\u0000\"\u000e\u0010z\u001a\u00020\u0001X\u0086T¢\u0006\u0002\n\u0000\"\u000e\u0010{\u001a\u00020|X\u0082\u0004¢\u0006\u0002\n\u0000\"\u0019\u0010}\u001a\b\u0012\u0004\u0012\u00020\u007f0~¢\u0006\n\n\u0000\u001a\u0006\b\u0080\u0001\u0010\u0081\u0001¨\u0006\u0083\u0001"}, m195d2 = {"ARIA2C", "", "AUDIO_CONVERSION_FORMAT", "AUDIO_CONVERT", "AUDIO_DIRECTORY", "AUDIO_FORMAT", "AUDIO_QUALITY", "AUTO_SUBTITLE", "AUTO_TRANSLATED_SUBTITLES", "AUTO_UPDATE", "AV1_HARDWARE_ACCELERATED", "BooleanPreferenceDefaults", "", "", "CELLULAR_DOWNLOAD", "COMMAND_DIRECTORY", "CONCURRENT", "CONFIGURE", "CONVERT_ASS", "", "CONVERT_LRC", "CONVERT_M4A", "CONVERT_MP3", "CONVERT_SRT", "CONVERT_SUBTITLE", "CONVERT_VTT", "COOKIES", "CROP_ARTWORK", "CUSTOM_COMMAND", "CUSTOM_OUTPUT_TEMPLATE", "DARK_THEME_VALUE", "DEBUG", "DEFAULT", "DEFAULT_INTERVAL", "", "DISABLE_PREVIEW", "DOWNLOAD_ARCHIVE", "DOWNLOAD_TYPE_INITIALIZATION", "DYNAMIC_COLOR", "EMBED_METADATA", "EMBED_SUBTITLE", "EMBED_THUMBNAIL", "EXTRACT_AUDIO", "FORCE_IPV4", "FORMAT_COMPATIBILITY", "FORMAT_QUALITY", "FORMAT_SELECTION", "FORMAT_SORTING", "HAS_SHOWN_WELCOME", "HIGH", "HIGH_CONTRAST", "INTERVAL_DAY", "INTERVAL_MONTH", "INTERVAL_WEEK", "IntPreferenceDefaults", "KEEP_SUBTITLE_FILES", "LANGUAGE", "LOW", "LongPreferenceDefaults", "M4A", "MAX_FILE_SIZE", "MAX_RATE", "MEDIUM", "MERGE_MULTI_AUDIO_STREAM", "MERGE_OUTPUT_MKV", "NONE", "NOTIFICATION", "NOT_CONVERT", "NOT_SPECIFIED", "OPUS", "OUTPUT_TEMPLATE", "PALETTE_STYLE", "PLAYLIST", "PRE_RELEASE", "PRIVATE_DIRECTORY", "PRIVATE_MODE", "PROXY", "PROXY_URL", "RATE_LIMIT", "RESTRICT_FILENAMES", "SDCARD_DOWNLOAD", "SDCARD_URI", "SHOW_SPONSOR_MSG", "SORTING_FIELDS", "SPONSORBLOCK", "SPONSORBLOCK_CATEGORIES", "STABLE", "STYLE_FRUIT_SALAD", "STYLE_MONOCHROME", "STYLE_SPRITZ", "STYLE_TONAL_SPOT", "STYLE_VIBRANT", "SUBDIRECTORY_EXTRACTOR", "SUBDIRECTORY_PLAYLIST_TITLE", "SUBTITLE", "SUBTITLE_LANGUAGE", "SYSTEM_DEFAULT", "StringPreferenceDefaults", "TEMPLATE_EXAMPLE", "TEMPLATE_ID", "TEMPLATE_SHORTCUTS", "THEME_COLOR", "THUMBNAIL", "ULTRA_LOW", "UPDATE_CHANNEL", "USER_AGENT", "USER_AGENT_STRING", "USE_PREVIOUS_SELECTION", "UpdateIntervalList", "getUpdateIntervalList", "()Ljava/util/Map;", "VIDEO_CLIP", "VIDEO_DIRECTORY", "VIDEO_FORMAT", "VIDEO_QUALITY", "WELCOME_DIALOG", "YT_DLP_AUTO_UPDATE", "YT_DLP_NIGHTLY", "YT_DLP_STABLE", "YT_DLP_UPDATE_CHANNEL", "YT_DLP_UPDATE_INTERVAL", "YT_DLP_UPDATE_TIME", "YT_DLP_VERSION", "kv", "Lcom/tencent/mmkv/MMKV;", "paletteStyles", "", "Lcom/kyant/monet/PaletteStyle;", "getPaletteStyles", "()Ljava/util/List;", "getStringDefault", "app_debug"}, m196k = 2, m197mv = {1, 9, 0}, m199xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
public final class PreferenceUtilKt {
    public static final String ARIA2C = "aria2c";
    public static final String AUDIO_CONVERT = "audio_convert";
    public static final String AUDIO_DIRECTORY = "audio_dir";
    public static final String AUDIO_FORMAT = "audio_format_preferred";
    public static final String AUDIO_QUALITY = "audio_quality";
    public static final String AUTO_SUBTITLE = "auto_subtitle";
    public static final String AUTO_TRANSLATED_SUBTITLES = "translated_subs";
    public static final String AUTO_UPDATE = "auto_update";
    public static final String AV1_HARDWARE_ACCELERATED = "av1_hardware_accelerated";
    public static final String COMMAND_DIRECTORY = "command_directory";
    public static final int CONVERT_ASS = 1;
    public static final int CONVERT_LRC = 2;
    public static final int CONVERT_M4A = 1;
    public static final int CONVERT_MP3 = 0;
    public static final int CONVERT_SRT = 3;
    public static final int CONVERT_VTT = 4;
    public static final String COOKIES = "cookies";
    public static final String CROP_ARTWORK = "crop_artwork";
    public static final String CUSTOM_COMMAND = "custom_command";
    public static final String DEBUG = "debug";
    public static final int DEFAULT = 0;
    public static final long DEFAULT_INTERVAL = 604800000;
    public static final String DISABLE_PREVIEW = "disable_preview";
    public static final String DOWNLOAD_ARCHIVE = "download_archive";
    private static final String DYNAMIC_COLOR = "dynamic_color";
    public static final String EMBED_SUBTITLE = "embed_subtitle";
    public static final String EMBED_THUMBNAIL = "embed_thumbnail";
    public static final String EXTRACT_AUDIO = "extract_audio";
    public static final String FORCE_IPV4 = "force_ipv4";
    public static final int FORMAT_COMPATIBILITY = 1;
    public static final int FORMAT_QUALITY = 2;
    public static final String FORMAT_SORTING = "format_sorting";
    public static final String HAS_SHOWN_WELCOME = "has_shown_welcome";
    public static final int HIGH = 1;
    private static final String HIGH_CONTRAST = "high_contrast";
    private static final long INTERVAL_DAY = 86400000;
    private static final long INTERVAL_WEEK = 604800000;
    public static final String KEEP_SUBTITLE_FILES = "keep_subtitle";
    public static final int LOW = 3;
    public static final int M4A = 2;
    public static final String MAX_FILE_SIZE = "max_file_size";
    public static final int MEDIUM = 2;
    public static final String MERGE_MULTI_AUDIO_STREAM = "multi_audio_stream";
    public static final String MERGE_OUTPUT_MKV = "merge_to_mkv";
    public static final int NONE = 0;
    public static final int NOT_CONVERT = 0;
    public static final int NOT_SPECIFIED = 0;
    public static final int OPUS = 1;
    public static final String PLAYLIST = "playlist";
    public static final int PRE_RELEASE = 1;
    public static final String PRIVATE_DIRECTORY = "private_directory";
    public static final String PRIVATE_MODE = "private_mode";
    public static final String PROXY = "proxy";
    public static final String PROXY_URL = "proxy_url";
    public static final String RATE_LIMIT = "rate_limit";
    public static final String RESTRICT_FILENAMES = "restrict_filenames";
    public static final String SDCARD_DOWNLOAD = "sdcard_download";
    public static final String SDCARD_URI = "sd_card_uri";
    public static final String SORTING_FIELDS = "sorting_fields";
    public static final String SPONSORBLOCK = "sponsorblock";
    public static final int STABLE = 0;
    public static final int STYLE_FRUIT_SALAD = 2;
    public static final int STYLE_MONOCHROME = 4;
    public static final int STYLE_SPRITZ = 1;
    public static final int STYLE_TONAL_SPOT = 0;
    public static final int STYLE_VIBRANT = 3;
    public static final String SUBDIRECTORY_EXTRACTOR = "sub-directory";
    public static final String SUBDIRECTORY_PLAYLIST_TITLE = "subdirectory_playlist_title";
    public static final String SUBTITLE = "subtitle";
    public static final int SYSTEM_DEFAULT = 0;
    public static final String TEMPLATE_EXAMPLE = "--no-mtime -S \"ext\"";
    public static final String TEMPLATE_ID = "template_id";
    public static final String TEMPLATE_SHORTCUTS = "template_shortcuts";
    private static final String THEME_COLOR = "theme_color";
    public static final String THUMBNAIL = "create_thumbnail";
    public static final int ULTRA_LOW = 4;
    public static final String USER_AGENT = "user_agent";
    public static final String USER_AGENT_STRING = "user_agent_string";
    public static final int USE_PREVIOUS_SELECTION = 1;
    public static final String VIDEO_CLIP = "video_clip";
    public static final String VIDEO_DIRECTORY = "download_dir";
    public static final int YT_DLP_NIGHTLY = 1;
    public static final int YT_DLP_STABLE = 0;
    public static final String YT_DLP_UPDATE_TIME = "yt-dlp_last_update";
    public static final String YT_DLP_VERSION = "yt-dlp_init";

    /* JADX INFO: renamed from: kv */
    private static final MMKV f513kv;
    private static final long INTERVAL_MONTH = 2592000000L;
    private static final Map<Long, Integer> UpdateIntervalList = MapsKt.mapOf(TuplesKt.m202to(86400000L, Integer.valueOf(C3070R.string.every_day)), TuplesKt.m202to(604800000L, Integer.valueOf(C3070R.string.every_week)), TuplesKt.m202to(Long.valueOf(INTERVAL_MONTH), Integer.valueOf(C3070R.string.every_month)));
    private static final List<PaletteStyle> paletteStyles = CollectionsKt.listOf((Object[]) new PaletteStyle[]{PaletteStyle.INSTANCE.getTonalSpot(), PaletteStyle.INSTANCE.getSpritz(), PaletteStyle.INSTANCE.getFruitSalad(), PaletteStyle.INSTANCE.getVibrant(), PaletteStyle.INSTANCE.getMonochrome()});
    public static final String SPONSORBLOCK_CATEGORIES = "sponsorblock_categories";
    public static final String MAX_RATE = "max_rate";
    public static final String SUBTITLE_LANGUAGE = "sub_lang";
    public static final String OUTPUT_TEMPLATE = "output_template";
    public static final String CUSTOM_OUTPUT_TEMPLATE = "custom_output_template";
    private static final Map<String, String> StringPreferenceDefaults = MapsKt.mapOf(TuplesKt.m202to(SPONSORBLOCK_CATEGORIES, "default"), TuplesKt.m202to(MAX_RATE, "1000"), TuplesKt.m202to(SUBTITLE_LANGUAGE, "en.*,.*-orig"), TuplesKt.m202to(OUTPUT_TEMPLATE, DownloadUtil.OUTPUT_TEMPLATE_ID), TuplesKt.m202to(CUSTOM_OUTPUT_TEMPLATE, DownloadUtil.OUTPUT_TEMPLATE_ID));
    public static final String FORMAT_SELECTION = "format_selection";
    public static final String CONFIGURE = "configure";
    public static final String CELLULAR_DOWNLOAD = "cellular_download";
    public static final String YT_DLP_AUTO_UPDATE = "yt-dlp_update";
    public static final String NOTIFICATION = "notification";
    public static final String EMBED_METADATA = "embed_metadata";
    private static final Map<String, Boolean> BooleanPreferenceDefaults = MapsKt.mapOf(TuplesKt.m202to(FORMAT_SELECTION, true), TuplesKt.m202to(CONFIGURE, true), TuplesKt.m202to(CELLULAR_DOWNLOAD, false), TuplesKt.m202to(YT_DLP_AUTO_UPDATE, true), TuplesKt.m202to(NOTIFICATION, true), TuplesKt.m202to(EMBED_METADATA, true));
    public static final String CONCURRENT = "concurrent_fragments";
    private static final String LANGUAGE = "language";
    public static final String PALETTE_STYLE = "palette_style";
    public static final String DARK_THEME_VALUE = "dark_theme_value";
    public static final String WELCOME_DIALOG = "welcome_dialog";
    public static final String AUDIO_CONVERSION_FORMAT = "audio_convert_format";
    public static final String VIDEO_QUALITY = "quality";
    public static final String VIDEO_FORMAT = "video_format";
    public static final String UPDATE_CHANNEL = "update_channel";
    public static final String SHOW_SPONSOR_MSG = "sponsor_msg_v1";
    public static final String CONVERT_SUBTITLE = "convert_subtitle";
    public static final String DOWNLOAD_TYPE_INITIALIZATION = "download_type_init";
    public static final String YT_DLP_UPDATE_CHANNEL = "yt-dlp_update_channel";
    private static final Map<String, Integer> IntPreferenceDefaults = MapsKt.mapOf(TuplesKt.m202to("template_id", 0), TuplesKt.m202to(CONCURRENT, 8), TuplesKt.m202to(LANGUAGE, 0), TuplesKt.m202to(PALETTE_STYLE, 0), TuplesKt.m202to(DARK_THEME_VALUE, 1), TuplesKt.m202to(WELCOME_DIALOG, 1), TuplesKt.m202to(AUDIO_CONVERSION_FORMAT, 0), TuplesKt.m202to(VIDEO_QUALITY, 0), TuplesKt.m202to(VIDEO_FORMAT, 2), TuplesKt.m202to(UPDATE_CHANNEL, 0), TuplesKt.m202to(SHOW_SPONSOR_MSG, 0), TuplesKt.m202to(CONVERT_SUBTITLE, 0), TuplesKt.m202to(DOWNLOAD_TYPE_INITIALIZATION, 1), TuplesKt.m202to(YT_DLP_UPDATE_CHANNEL, 1));
    public static final String YT_DLP_UPDATE_INTERVAL = "yt-dlp_update_interval";
    private static final Map<String, Long> LongPreferenceDefaults = MapsKt.mapOf(TuplesKt.m202to(YT_DLP_UPDATE_INTERVAL, 604800000L));

    public static final Map<Long, Integer> getUpdateIntervalList() {
        return UpdateIntervalList;
    }

    static {
        MMKV mmkvDefaultMMKV = MMKV.defaultMMKV();
        Intrinsics.checkNotNullExpressionValue(mmkvDefaultMMKV, "defaultMMKV(...)");
        f513kv = mmkvDefaultMMKV;
    }

    public static final List<PaletteStyle> getPaletteStyles() {
        return paletteStyles;
    }

    public static final String getStringDefault(String $this$getStringDefault) {
        Intrinsics.checkNotNullParameter($this$getStringDefault, "<this>");
        String str = StringPreferenceDefaults.get($this$getStringDefault);
        if (str == null) {
            str = "";
        }
        return str;
    }
}
