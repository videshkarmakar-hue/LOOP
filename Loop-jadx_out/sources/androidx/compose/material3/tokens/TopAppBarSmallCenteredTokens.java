package androidx.compose.material3.tokens;

import androidx.compose.p001ui.unit.C1979Dp;
import androidx.constraintlayout.widget.ConstraintLayout;
import kotlin.Metadata;

/* JADX INFO: compiled from: TopAppBarSmallCenteredTokens.kt */
/* JADX INFO: loaded from: classes17.dex */
@Metadata(m194d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0018\u0002\n\u0002\b\u000f\bÀ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u0011\u0010\u0003\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006R\u0019\u0010\u0007\u001a\u00020\bø\u0001\u0000ø\u0001\u0001¢\u0006\n\n\u0002\u0010\u000b\u001a\u0004\b\t\u0010\nR\u0011\u0010\f\u001a\u00020\r¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u0019\u0010\u0010\u001a\u00020\bø\u0001\u0000ø\u0001\u0001¢\u0006\n\n\u0002\u0010\u000b\u001a\u0004\b\u0011\u0010\nR\u0019\u0010\u0012\u001a\u00020\bø\u0001\u0000ø\u0001\u0001¢\u0006\n\n\u0002\u0010\u000b\u001a\u0004\b\u0013\u0010\nR\u0011\u0010\u0014\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0006R\u0011\u0010\u0016\u001a\u00020\r¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u000fR\u0011\u0010\u0018\u001a\u00020\r¢\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u000fR\u0011\u0010\u001a\u001a\u00020\u001b¢\u0006\b\n\u0000\u001a\u0004\b\u001c\u0010\u001dR\u0011\u0010\u001e\u001a\u00020\r¢\u0006\b\n\u0000\u001a\u0004\b\u001f\u0010\u000fR\u0019\u0010 \u001a\u00020\bø\u0001\u0000ø\u0001\u0001¢\u0006\n\n\u0002\u0010\u000b\u001a\u0004\b!\u0010\nR\u0011\u0010\"\u001a\u00020\r¢\u0006\b\n\u0000\u001a\u0004\b#\u0010\u000fR\u0019\u0010$\u001a\u00020\bø\u0001\u0000ø\u0001\u0001¢\u0006\n\n\u0002\u0010\u000b\u001a\u0004\b%\u0010\nR\u0011\u0010&\u001a\u00020\r¢\u0006\b\n\u0000\u001a\u0004\b'\u0010\u000fR\u0019\u0010(\u001a\u00020\bø\u0001\u0000ø\u0001\u0001¢\u0006\n\n\u0002\u0010\u000b\u001a\u0004\b)\u0010\n\u0082\u0002\u000b\n\u0005\b¡\u001e0\u0001\n\u0002\b!¨\u0006*"}, m195d2 = {"Landroidx/compose/material3/tokens/TopAppBarSmallCenteredTokens;", "", "()V", "AvatarShape", "Landroidx/compose/material3/tokens/ShapeKeyTokens;", "getAvatarShape", "()Landroidx/compose/material3/tokens/ShapeKeyTokens;", "AvatarSize", "Landroidx/compose/ui/unit/Dp;", "getAvatarSize-D9Ej5fM", "()F", "F", "ContainerColor", "Landroidx/compose/material3/tokens/ColorSchemeKeyTokens;", "getContainerColor", "()Landroidx/compose/material3/tokens/ColorSchemeKeyTokens;", "ContainerElevation", "getContainerElevation-D9Ej5fM", "ContainerHeight", "getContainerHeight-D9Ej5fM", "ContainerShape", "getContainerShape", "ContainerSurfaceTintLayerColor", "getContainerSurfaceTintLayerColor", "HeadlineColor", "getHeadlineColor", "HeadlineFont", "Landroidx/compose/material3/tokens/TypographyKeyTokens;", "getHeadlineFont", "()Landroidx/compose/material3/tokens/TypographyKeyTokens;", "LeadingIconColor", "getLeadingIconColor", "LeadingIconSize", "getLeadingIconSize-D9Ej5fM", "OnScrollContainerColor", "getOnScrollContainerColor", "OnScrollContainerElevation", "getOnScrollContainerElevation-D9Ej5fM", "TrailingIconColor", "getTrailingIconColor", "TrailingIconSize", "getTrailingIconSize-D9Ej5fM", "material3_release"}, m196k = 1, m197mv = {1, 8, 0}, m199xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
public final class TopAppBarSmallCenteredTokens {
    public static final int $stable = 0;
    public static final TopAppBarSmallCenteredTokens INSTANCE = new TopAppBarSmallCenteredTokens();
    private static final ShapeKeyTokens AvatarShape = ShapeKeyTokens.CornerFull;
    private static final float AvatarSize = C1979Dp.m6801constructorimpl((float) 30.0d);
    private static final ColorSchemeKeyTokens ContainerColor = ColorSchemeKeyTokens.Surface;
    private static final float ContainerElevation = ElevationTokens.INSTANCE.m3273getLevel0D9Ej5fM();
    private static final float ContainerHeight = C1979Dp.m6801constructorimpl((float) 64.0d);
    private static final ShapeKeyTokens ContainerShape = ShapeKeyTokens.CornerNone;
    private static final ColorSchemeKeyTokens ContainerSurfaceTintLayerColor = ColorSchemeKeyTokens.SurfaceTint;
    private static final ColorSchemeKeyTokens HeadlineColor = ColorSchemeKeyTokens.OnSurface;
    private static final TypographyKeyTokens HeadlineFont = TypographyKeyTokens.TitleLarge;
    private static final ColorSchemeKeyTokens LeadingIconColor = ColorSchemeKeyTokens.OnSurface;
    private static final float LeadingIconSize = C1979Dp.m6801constructorimpl((float) 24.0d);
    private static final ColorSchemeKeyTokens OnScrollContainerColor = ColorSchemeKeyTokens.SurfaceContainer;
    private static final float OnScrollContainerElevation = ElevationTokens.INSTANCE.m3275getLevel2D9Ej5fM();
    private static final ColorSchemeKeyTokens TrailingIconColor = ColorSchemeKeyTokens.OnSurfaceVariant;
    private static final float TrailingIconSize = C1979Dp.m6801constructorimpl((float) 24.0d);

    private TopAppBarSmallCenteredTokens() {
    }

    public final ShapeKeyTokens getAvatarShape() {
        return AvatarShape;
    }

    /* JADX INFO: renamed from: getAvatarSize-D9Ej5fM, reason: not valid java name */
    public final float m3660getAvatarSizeD9Ej5fM() {
        return AvatarSize;
    }

    public final ColorSchemeKeyTokens getContainerColor() {
        return ContainerColor;
    }

    /* JADX INFO: renamed from: getContainerElevation-D9Ej5fM, reason: not valid java name */
    public final float m3661getContainerElevationD9Ej5fM() {
        return ContainerElevation;
    }

    /* JADX INFO: renamed from: getContainerHeight-D9Ej5fM, reason: not valid java name */
    public final float m3662getContainerHeightD9Ej5fM() {
        return ContainerHeight;
    }

    public final ShapeKeyTokens getContainerShape() {
        return ContainerShape;
    }

    public final ColorSchemeKeyTokens getContainerSurfaceTintLayerColor() {
        return ContainerSurfaceTintLayerColor;
    }

    public final ColorSchemeKeyTokens getHeadlineColor() {
        return HeadlineColor;
    }

    public final TypographyKeyTokens getHeadlineFont() {
        return HeadlineFont;
    }

    public final ColorSchemeKeyTokens getLeadingIconColor() {
        return LeadingIconColor;
    }

    /* JADX INFO: renamed from: getLeadingIconSize-D9Ej5fM, reason: not valid java name */
    public final float m3663getLeadingIconSizeD9Ej5fM() {
        return LeadingIconSize;
    }

    public final ColorSchemeKeyTokens getOnScrollContainerColor() {
        return OnScrollContainerColor;
    }

    /* JADX INFO: renamed from: getOnScrollContainerElevation-D9Ej5fM, reason: not valid java name */
    public final float m3664getOnScrollContainerElevationD9Ej5fM() {
        return OnScrollContainerElevation;
    }

    public final ColorSchemeKeyTokens getTrailingIconColor() {
        return TrailingIconColor;
    }

    /* JADX INFO: renamed from: getTrailingIconSize-D9Ej5fM, reason: not valid java name */
    public final float m3665getTrailingIconSizeD9Ej5fM() {
        return TrailingIconSize;
    }
}
