package androidx.compose.ui.geometry;

import androidx.compose.ui.util.MathHelpersKt;
import androidx.constraintlayout.widget.ConstraintLayout;
import kotlin.Metadata;

/* JADX INFO: compiled from: RoundRect.kt */
/* JADX INFO: loaded from: classes17.dex */
@Metadata(d1 = {"\u0000.\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0007\n\u0002\u0010\u0007\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0019\u001a \u0010\u0019\u001a\u00020\u00022\u0006\u0010\u001a\u001a\u00020\u00012\u0006\u0010\u001b\u001a\u00020\u001cø\u0001\u0000¢\u0006\u0004\b\u001d\u0010\u001e\u001a@\u0010\u0019\u001a\u00020\u00022\u0006\u0010\u001a\u001a\u00020\u00012\b\b\u0002\u0010\u001f\u001a\u00020\u001c2\b\b\u0002\u0010 \u001a\u00020\u001c2\b\b\u0002\u0010!\u001a\u00020\u001c2\b\b\u0002\u0010\"\u001a\u00020\u001cø\u0001\u0000¢\u0006\u0004\b#\u0010$\u001a\u001e\u0010\u0019\u001a\u00020\u00022\u0006\u0010\u001a\u001a\u00020\u00012\u0006\u0010%\u001a\u00020\u00122\u0006\u0010&\u001a\u00020\u0012\u001a8\u0010\u0019\u001a\u00020\u00022\u0006\u0010'\u001a\u00020\u00122\u0006\u0010(\u001a\u00020\u00122\u0006\u0010)\u001a\u00020\u00122\u0006\u0010*\u001a\u00020\u00122\u0006\u0010\u001b\u001a\u00020\u001cø\u0001\u0000¢\u0006\u0004\b+\u0010,\u001a6\u0010\u0019\u001a\u00020\u00022\u0006\u0010'\u001a\u00020\u00122\u0006\u0010(\u001a\u00020\u00122\u0006\u0010)\u001a\u00020\u00122\u0006\u0010*\u001a\u00020\u00122\u0006\u0010%\u001a\u00020\u00122\u0006\u0010&\u001a\u00020\u0012\u001a\u001e\u0010-\u001a\u00020\u00022\u0006\u0010.\u001a\u00020\u00022\u0006\u0010/\u001a\u00020\u00022\u0006\u00100\u001a\u00020\u0012\u001a\u001c\u00101\u001a\u00020\u0002*\u00020\u00022\u0006\u00102\u001a\u00020\u0006ø\u0001\u0000¢\u0006\u0004\b3\u00104\"\u0015\u0010\u0000\u001a\u00020\u0001*\u00020\u00028F¢\u0006\u0006\u001a\u0004\b\u0003\u0010\u0004\"\u0015\u0010\u0005\u001a\u00020\u0006*\u00020\u00028F¢\u0006\u0006\u001a\u0004\b\u0007\u0010\b\"\u0015\u0010\t\u001a\u00020\n*\u00020\u00028F¢\u0006\u0006\u001a\u0004\b\t\u0010\u000b\"\u0015\u0010\f\u001a\u00020\n*\u00020\u00028F¢\u0006\u0006\u001a\u0004\b\f\u0010\u000b\"\u0015\u0010\r\u001a\u00020\n*\u00020\u00028F¢\u0006\u0006\u001a\u0004\b\r\u0010\u000b\"\u0015\u0010\u000e\u001a\u00020\n*\u00020\u00028F¢\u0006\u0006\u001a\u0004\b\u000e\u0010\u000b\"\u0015\u0010\u000f\u001a\u00020\n*\u00020\u00028F¢\u0006\u0006\u001a\u0004\b\u000f\u0010\u000b\"\u0015\u0010\u0010\u001a\u00020\n*\u00020\u00028F¢\u0006\u0006\u001a\u0004\b\u0010\u0010\u000b\"\u0015\u0010\u0011\u001a\u00020\u0012*\u00020\u00028F¢\u0006\u0006\u001a\u0004\b\u0013\u0010\u0014\"\u0015\u0010\u0015\u001a\u00020\u0012*\u00020\u00028F¢\u0006\u0006\u001a\u0004\b\u0016\u0010\u0014\"\u0015\u0010\u0017\u001a\u00020\u0001*\u00020\u00028F¢\u0006\u0006\u001a\u0004\b\u0018\u0010\u0004\u0082\u0002\u0007\n\u0005\b¡\u001e0\u0001¨\u00065"}, d2 = {"boundingRect", "Landroidx/compose/ui/geometry/Rect;", "Landroidx/compose/ui/geometry/RoundRect;", "getBoundingRect", "(Landroidx/compose/ui/geometry/RoundRect;)Landroidx/compose/ui/geometry/Rect;", "center", "Landroidx/compose/ui/geometry/Offset;", "getCenter", "(Landroidx/compose/ui/geometry/RoundRect;)J", "isCircle", "", "(Landroidx/compose/ui/geometry/RoundRect;)Z", "isEllipse", "isEmpty", "isFinite", "isRect", "isSimple", "maxDimension", "", "getMaxDimension", "(Landroidx/compose/ui/geometry/RoundRect;)F", "minDimension", "getMinDimension", "safeInnerRect", "getSafeInnerRect", "RoundRect", "rect", "cornerRadius", "Landroidx/compose/ui/geometry/CornerRadius;", "RoundRect-sniSvfs", "(Landroidx/compose/ui/geometry/Rect;J)Landroidx/compose/ui/geometry/RoundRect;", "topLeft", "topRight", "bottomRight", "bottomLeft", "RoundRect-ZAM2FJo", "(Landroidx/compose/ui/geometry/Rect;JJJJ)Landroidx/compose/ui/geometry/RoundRect;", "radiusX", "radiusY", "left", "top", "right", "bottom", "RoundRect-gG7oq9Y", "(FFFFJ)Landroidx/compose/ui/geometry/RoundRect;", "lerp", "start", "stop", "fraction", "translate", "offset", "translate-Uv8p0NA", "(Landroidx/compose/ui/geometry/RoundRect;J)Landroidx/compose/ui/geometry/RoundRect;", "ui-geometry_release"}, k = 2, mv = {1, 8, 0}, xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
public final class RoundRectKt {
    public static final RoundRect RoundRect(float left, float top, float right, float bottom, float radiusX, float radiusY) {
        long radius = CornerRadiusKt.CornerRadius(radiusX, radiusY);
        return new RoundRect(left, top, right, bottom, radius, radius, radius, radius, null);
    }

    /* JADX INFO: renamed from: RoundRect-gG7oq9Y, reason: not valid java name */
    public static final RoundRect m3855RoundRectgG7oq9Y(float left, float top, float right, float bottom, long cornerRadius) {
        return RoundRect(left, top, right, bottom, CornerRadius.m3776getXimpl(cornerRadius), CornerRadius.m3777getYimpl(cornerRadius));
    }

    public static final RoundRect RoundRect(Rect rect, float radiusX, float radiusY) {
        return RoundRect(rect.getLeft(), rect.getTop(), rect.getRight(), rect.getBottom(), radiusX, radiusY);
    }

    /* JADX INFO: renamed from: RoundRect-sniSvfs, reason: not valid java name */
    public static final RoundRect m3856RoundRectsniSvfs(Rect rect, long cornerRadius) {
        return RoundRect(rect, CornerRadius.m3776getXimpl(cornerRadius), CornerRadius.m3777getYimpl(cornerRadius));
    }

    /* JADX INFO: renamed from: RoundRect-ZAM2FJo, reason: not valid java name */
    public static final RoundRect m3853RoundRectZAM2FJo(Rect rect, long topLeft, long topRight, long bottomRight, long bottomLeft) {
        return new RoundRect(rect.getLeft(), rect.getTop(), rect.getRight(), rect.getBottom(), topLeft, topRight, bottomRight, bottomLeft, null);
    }

    /* JADX INFO: renamed from: translate-Uv8p0NA, reason: not valid java name */
    public static final RoundRect m3857translateUv8p0NA(RoundRect $this$translate_u2dUv8p0NA, long offset) {
        return new RoundRect(Offset.m3801getXimpl(offset) + $this$translate_u2dUv8p0NA.getLeft(), Offset.m3802getYimpl(offset) + $this$translate_u2dUv8p0NA.getTop(), Offset.m3801getXimpl(offset) + $this$translate_u2dUv8p0NA.getRight(), Offset.m3802getYimpl(offset) + $this$translate_u2dUv8p0NA.getBottom(), $this$translate_u2dUv8p0NA.m3851getTopLeftCornerRadiuskKHJgLs(), $this$translate_u2dUv8p0NA.m3852getTopRightCornerRadiuskKHJgLs(), $this$translate_u2dUv8p0NA.m3850getBottomRightCornerRadiuskKHJgLs(), $this$translate_u2dUv8p0NA.m3849getBottomLeftCornerRadiuskKHJgLs(), null);
    }

    public static final Rect getBoundingRect(RoundRect $this$boundingRect) {
        return new Rect($this$boundingRect.getLeft(), $this$boundingRect.getTop(), $this$boundingRect.getRight(), $this$boundingRect.getBottom());
    }

    public static final Rect getSafeInnerRect(RoundRect $this$safeInnerRect) {
        float leftRadius = Math.max(CornerRadius.m3776getXimpl($this$safeInnerRect.m3849getBottomLeftCornerRadiuskKHJgLs()), CornerRadius.m3776getXimpl($this$safeInnerRect.m3851getTopLeftCornerRadiuskKHJgLs()));
        float topRadius = Math.max(CornerRadius.m3777getYimpl($this$safeInnerRect.m3851getTopLeftCornerRadiuskKHJgLs()), CornerRadius.m3777getYimpl($this$safeInnerRect.m3852getTopRightCornerRadiuskKHJgLs()));
        float rightRadius = Math.max(CornerRadius.m3776getXimpl($this$safeInnerRect.m3852getTopRightCornerRadiuskKHJgLs()), CornerRadius.m3776getXimpl($this$safeInnerRect.m3850getBottomRightCornerRadiuskKHJgLs()));
        float bottomRadius = Math.max(CornerRadius.m3777getYimpl($this$safeInnerRect.m3850getBottomRightCornerRadiuskKHJgLs()), CornerRadius.m3777getYimpl($this$safeInnerRect.m3849getBottomLeftCornerRadiuskKHJgLs()));
        return new Rect($this$safeInnerRect.getLeft() + (leftRadius * 0.29289323f), $this$safeInnerRect.getTop() + (topRadius * 0.29289323f), $this$safeInnerRect.getRight() - (rightRadius * 0.29289323f), $this$safeInnerRect.getBottom() - (bottomRadius * 0.29289323f));
    }

    public static final boolean isEmpty(RoundRect $this$isEmpty) {
        return $this$isEmpty.getLeft() >= $this$isEmpty.getRight() || $this$isEmpty.getTop() >= $this$isEmpty.getBottom();
    }

    public static final boolean isFinite(RoundRect $this$isFinite) {
        float left = $this$isFinite.getLeft();
        if ((Float.isInfinite(left) || Float.isNaN(left)) ? false : true) {
            float top = $this$isFinite.getTop();
            if ((Float.isInfinite(top) || Float.isNaN(top)) ? false : true) {
                float right = $this$isFinite.getRight();
                if ((Float.isInfinite(right) || Float.isNaN(right)) ? false : true) {
                    float bottom = $this$isFinite.getBottom();
                    if ((Float.isInfinite(bottom) || Float.isNaN(bottom)) ? false : true) {
                        return true;
                    }
                }
            }
        }
        return false;
    }

    /* JADX WARN: Code duplicated, block: B:12:0x0025  */
    /* JADX WARN: Code duplicated, block: B:14:0x0031  */
    /* JADX WARN: Code duplicated, block: B:15:0x0033  */
    /* JADX WARN: Code duplicated, block: B:17:0x0036  */
    /* JADX WARN: Code duplicated, block: B:19:0x0042  */
    /* JADX WARN: Code duplicated, block: B:20:0x0044  */
    /* JADX WARN: Code duplicated, block: B:22:0x0047  */
    /* JADX WARN: Code duplicated, block: B:24:0x0053  */
    /* JADX WARN: Code duplicated, block: B:25:0x0055  */
    /* JADX WARN: Code duplicated, block: B:27:0x0058  */
    /* JADX WARN: Code duplicated, block: B:29:0x0064  */
    /* JADX WARN: Code duplicated, block: B:30:0x0066  */
    /* JADX WARN: Code duplicated, block: B:32:0x0069  */
    /* JADX WARN: Code duplicated, block: B:34:0x0075  */
    /* JADX WARN: Code duplicated, block: B:35:0x0077  */
    /* JADX WARN: Code duplicated, block: B:37:0x007a  */
    /* JADX WARN: Code duplicated, block: B:39:0x0086  */
    /* JADX WARN: Code duplicated, block: B:40:0x0088  */
    /* JADX WARN: Code duplicated, block: B:45:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:46:? A[RETURN, SYNTHETIC] */
    public static final boolean isRect(RoundRect $this$isRect) {
        boolean z;
        boolean z2;
        boolean z3;
        boolean z4;
        boolean z5;
        boolean z6;
        if (CornerRadius.m3776getXimpl($this$isRect.m3851getTopLeftCornerRadiuskKHJgLs()) == 0.0f) {
            if (CornerRadius.m3776getXimpl($this$isRect.m3852getTopRightCornerRadiuskKHJgLs()) == 0.0f) {
                z = true;
            } else {
                z = false;
            }
            if (z) {
                if (CornerRadius.m3776getXimpl($this$isRect.m3849getBottomLeftCornerRadiuskKHJgLs()) == 0.0f) {
                    z2 = true;
                } else {
                    z2 = false;
                }
                if (z2) {
                    if (CornerRadius.m3776getXimpl($this$isRect.m3850getBottomRightCornerRadiuskKHJgLs()) == 0.0f) {
                        z3 = true;
                    } else {
                        z3 = false;
                    }
                    if (!z3) {
                        return true;
                    }
                    if (CornerRadius.m3777getYimpl($this$isRect.m3850getBottomRightCornerRadiuskKHJgLs()) == 0.0f) {
                        z4 = true;
                    } else {
                        z4 = false;
                    }
                    if (z4) {
                        return true;
                    }
                } else {
                    if (CornerRadius.m3777getYimpl($this$isRect.m3849getBottomLeftCornerRadiuskKHJgLs()) == 0.0f) {
                        z5 = true;
                    } else {
                        z5 = false;
                    }
                    if (z5) {
                        if (CornerRadius.m3776getXimpl($this$isRect.m3850getBottomRightCornerRadiuskKHJgLs()) == 0.0f) {
                            z3 = true;
                        } else {
                            z3 = false;
                        }
                        if (!z3) {
                            return true;
                        }
                        if (CornerRadius.m3777getYimpl($this$isRect.m3850getBottomRightCornerRadiuskKHJgLs()) == 0.0f) {
                            z4 = true;
                        } else {
                            z4 = false;
                        }
                        if (z4) {
                            return true;
                        }
                    }
                }
            } else {
                if (CornerRadius.m3777getYimpl($this$isRect.m3852getTopRightCornerRadiuskKHJgLs()) == 0.0f) {
                    z6 = true;
                } else {
                    z6 = false;
                }
                if (z6) {
                    if (CornerRadius.m3776getXimpl($this$isRect.m3849getBottomLeftCornerRadiuskKHJgLs()) == 0.0f) {
                        z2 = true;
                    } else {
                        z2 = false;
                    }
                    if (z2) {
                        if (CornerRadius.m3776getXimpl($this$isRect.m3850getBottomRightCornerRadiuskKHJgLs()) == 0.0f) {
                            z3 = true;
                        } else {
                            z3 = false;
                        }
                        if (!z3) {
                            return true;
                        }
                        if (CornerRadius.m3777getYimpl($this$isRect.m3850getBottomRightCornerRadiuskKHJgLs()) == 0.0f) {
                            z4 = true;
                        } else {
                            z4 = false;
                        }
                        if (z4) {
                            return true;
                        }
                    } else {
                        if (CornerRadius.m3777getYimpl($this$isRect.m3849getBottomLeftCornerRadiuskKHJgLs()) == 0.0f) {
                            z5 = true;
                        } else {
                            z5 = false;
                        }
                        if (z5) {
                            if (CornerRadius.m3776getXimpl($this$isRect.m3850getBottomRightCornerRadiuskKHJgLs()) == 0.0f) {
                                z3 = true;
                            } else {
                                z3 = false;
                            }
                            if (!z3) {
                                return true;
                            }
                            if (CornerRadius.m3777getYimpl($this$isRect.m3850getBottomRightCornerRadiuskKHJgLs()) == 0.0f) {
                                z4 = true;
                            } else {
                                z4 = false;
                            }
                            if (z4) {
                                return true;
                            }
                        }
                    }
                }
            }
        } else {
            if (CornerRadius.m3777getYimpl($this$isRect.m3851getTopLeftCornerRadiuskKHJgLs()) == 0.0f) {
                if (CornerRadius.m3776getXimpl($this$isRect.m3852getTopRightCornerRadiuskKHJgLs()) == 0.0f) {
                    z = true;
                } else {
                    z = false;
                }
                if (z) {
                    if (CornerRadius.m3776getXimpl($this$isRect.m3849getBottomLeftCornerRadiuskKHJgLs()) == 0.0f) {
                        z2 = true;
                    } else {
                        z2 = false;
                    }
                    if (z2) {
                        if (CornerRadius.m3776getXimpl($this$isRect.m3850getBottomRightCornerRadiuskKHJgLs()) == 0.0f) {
                            z3 = true;
                        } else {
                            z3 = false;
                        }
                        if (!z3) {
                            return true;
                        }
                        if (CornerRadius.m3777getYimpl($this$isRect.m3850getBottomRightCornerRadiuskKHJgLs()) == 0.0f) {
                            z4 = true;
                        } else {
                            z4 = false;
                        }
                        if (z4) {
                            return true;
                        }
                    } else {
                        if (CornerRadius.m3777getYimpl($this$isRect.m3849getBottomLeftCornerRadiuskKHJgLs()) == 0.0f) {
                            z5 = true;
                        } else {
                            z5 = false;
                        }
                        if (z5) {
                            if (CornerRadius.m3776getXimpl($this$isRect.m3850getBottomRightCornerRadiuskKHJgLs()) == 0.0f) {
                                z3 = true;
                            } else {
                                z3 = false;
                            }
                            if (!z3) {
                                return true;
                            }
                            if (CornerRadius.m3777getYimpl($this$isRect.m3850getBottomRightCornerRadiuskKHJgLs()) == 0.0f) {
                                z4 = true;
                            } else {
                                z4 = false;
                            }
                            if (z4) {
                                return true;
                            }
                        }
                    }
                } else {
                    if (CornerRadius.m3777getYimpl($this$isRect.m3852getTopRightCornerRadiuskKHJgLs()) == 0.0f) {
                        z6 = true;
                    } else {
                        z6 = false;
                    }
                    if (z6) {
                        if (CornerRadius.m3776getXimpl($this$isRect.m3849getBottomLeftCornerRadiuskKHJgLs()) == 0.0f) {
                            z2 = true;
                        } else {
                            z2 = false;
                        }
                        if (z2) {
                            if (CornerRadius.m3776getXimpl($this$isRect.m3850getBottomRightCornerRadiuskKHJgLs()) == 0.0f) {
                                z3 = true;
                            } else {
                                z3 = false;
                            }
                            if (!z3) {
                                return true;
                            }
                            if (CornerRadius.m3777getYimpl($this$isRect.m3850getBottomRightCornerRadiuskKHJgLs()) == 0.0f) {
                                z4 = true;
                            } else {
                                z4 = false;
                            }
                            if (z4) {
                                return true;
                            }
                        } else {
                            if (CornerRadius.m3777getYimpl($this$isRect.m3849getBottomLeftCornerRadiuskKHJgLs()) == 0.0f) {
                                z5 = true;
                            } else {
                                z5 = false;
                            }
                            if (z5) {
                                if (CornerRadius.m3776getXimpl($this$isRect.m3850getBottomRightCornerRadiuskKHJgLs()) == 0.0f) {
                                    z3 = true;
                                } else {
                                    z3 = false;
                                }
                                if (!z3) {
                                    return true;
                                }
                                if (CornerRadius.m3777getYimpl($this$isRect.m3850getBottomRightCornerRadiuskKHJgLs()) == 0.0f) {
                                    z4 = true;
                                } else {
                                    z4 = false;
                                }
                                if (z4) {
                                    return true;
                                }
                            }
                        }
                    }
                }
            }
        }
        return false;
    }

    public static final boolean isEllipse(RoundRect $this$isEllipse) {
        if (CornerRadius.m3776getXimpl($this$isEllipse.m3851getTopLeftCornerRadiuskKHJgLs()) == CornerRadius.m3776getXimpl($this$isEllipse.m3852getTopRightCornerRadiuskKHJgLs())) {
            if (CornerRadius.m3777getYimpl($this$isEllipse.m3851getTopLeftCornerRadiuskKHJgLs()) == CornerRadius.m3777getYimpl($this$isEllipse.m3852getTopRightCornerRadiuskKHJgLs())) {
                if (CornerRadius.m3776getXimpl($this$isEllipse.m3852getTopRightCornerRadiuskKHJgLs()) == CornerRadius.m3776getXimpl($this$isEllipse.m3850getBottomRightCornerRadiuskKHJgLs())) {
                    if (CornerRadius.m3777getYimpl($this$isEllipse.m3852getTopRightCornerRadiuskKHJgLs()) == CornerRadius.m3777getYimpl($this$isEllipse.m3850getBottomRightCornerRadiuskKHJgLs())) {
                        if (CornerRadius.m3776getXimpl($this$isEllipse.m3850getBottomRightCornerRadiuskKHJgLs()) == CornerRadius.m3776getXimpl($this$isEllipse.m3849getBottomLeftCornerRadiuskKHJgLs())) {
                            if ((CornerRadius.m3777getYimpl($this$isEllipse.m3850getBottomRightCornerRadiuskKHJgLs()) == CornerRadius.m3777getYimpl($this$isEllipse.m3849getBottomLeftCornerRadiuskKHJgLs())) && $this$isEllipse.getWidth() <= ((double) CornerRadius.m3776getXimpl($this$isEllipse.m3851getTopLeftCornerRadiuskKHJgLs())) * 2.0d && $this$isEllipse.getHeight() <= ((double) CornerRadius.m3777getYimpl($this$isEllipse.m3851getTopLeftCornerRadiuskKHJgLs())) * 2.0d) {
                                return true;
                            }
                        }
                    }
                }
            }
        }
        return false;
    }

    public static final boolean isCircle(RoundRect $this$isCircle) {
        return (($this$isCircle.getWidth() > $this$isCircle.getHeight() ? 1 : ($this$isCircle.getWidth() == $this$isCircle.getHeight() ? 0 : -1)) == 0) && isEllipse($this$isCircle);
    }

    public static final float getMinDimension(RoundRect $this$minDimension) {
        return Math.min(Math.abs($this$minDimension.getWidth()), Math.abs($this$minDimension.getHeight()));
    }

    public static final float getMaxDimension(RoundRect $this$maxDimension) {
        return Math.max(Math.abs($this$maxDimension.getWidth()), Math.abs($this$maxDimension.getHeight()));
    }

    public static final long getCenter(RoundRect $this$center) {
        return OffsetKt.Offset($this$center.getLeft() + ($this$center.getWidth() / 2.0f), $this$center.getTop() + ($this$center.getHeight() / 2.0f));
    }

    public static final boolean isSimple(RoundRect $this$isSimple) {
        if (CornerRadius.m3776getXimpl($this$isSimple.m3851getTopLeftCornerRadiuskKHJgLs()) == CornerRadius.m3777getYimpl($this$isSimple.m3851getTopLeftCornerRadiuskKHJgLs())) {
            if (CornerRadius.m3776getXimpl($this$isSimple.m3851getTopLeftCornerRadiuskKHJgLs()) == CornerRadius.m3776getXimpl($this$isSimple.m3852getTopRightCornerRadiuskKHJgLs())) {
                if (CornerRadius.m3776getXimpl($this$isSimple.m3851getTopLeftCornerRadiuskKHJgLs()) == CornerRadius.m3777getYimpl($this$isSimple.m3852getTopRightCornerRadiuskKHJgLs())) {
                    if (CornerRadius.m3776getXimpl($this$isSimple.m3851getTopLeftCornerRadiuskKHJgLs()) == CornerRadius.m3776getXimpl($this$isSimple.m3850getBottomRightCornerRadiuskKHJgLs())) {
                        if (CornerRadius.m3776getXimpl($this$isSimple.m3851getTopLeftCornerRadiuskKHJgLs()) == CornerRadius.m3777getYimpl($this$isSimple.m3850getBottomRightCornerRadiuskKHJgLs())) {
                            if (CornerRadius.m3776getXimpl($this$isSimple.m3851getTopLeftCornerRadiuskKHJgLs()) == CornerRadius.m3776getXimpl($this$isSimple.m3849getBottomLeftCornerRadiuskKHJgLs())) {
                                if (CornerRadius.m3776getXimpl($this$isSimple.m3851getTopLeftCornerRadiuskKHJgLs()) == CornerRadius.m3777getYimpl($this$isSimple.m3849getBottomLeftCornerRadiuskKHJgLs())) {
                                    return true;
                                }
                            }
                        }
                    }
                }
            }
        }
        return false;
    }

    public static final RoundRect lerp(RoundRect start, RoundRect stop, float fraction) {
        return new RoundRect(MathHelpersKt.lerp(start.getLeft(), stop.getLeft(), fraction), MathHelpersKt.lerp(start.getTop(), stop.getTop(), fraction), MathHelpersKt.lerp(start.getRight(), stop.getRight(), fraction), MathHelpersKt.lerp(start.getBottom(), stop.getBottom(), fraction), CornerRadiusKt.m3787lerp3Ry4LBc(start.m3851getTopLeftCornerRadiuskKHJgLs(), stop.m3851getTopLeftCornerRadiuskKHJgLs(), fraction), CornerRadiusKt.m3787lerp3Ry4LBc(start.m3852getTopRightCornerRadiuskKHJgLs(), stop.m3852getTopRightCornerRadiuskKHJgLs(), fraction), CornerRadiusKt.m3787lerp3Ry4LBc(start.m3850getBottomRightCornerRadiuskKHJgLs(), stop.m3850getBottomRightCornerRadiuskKHJgLs(), fraction), CornerRadiusKt.m3787lerp3Ry4LBc(start.m3849getBottomLeftCornerRadiuskKHJgLs(), stop.m3849getBottomLeftCornerRadiuskKHJgLs(), fraction), null);
    }
}
