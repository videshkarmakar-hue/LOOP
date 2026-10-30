package coil.util;

import androidx.constraintlayout.widget.ConstraintLayout;
import coil.size.Size;
import kotlin.Metadata;

/* JADX INFO: compiled from: HardwareBitmaps.kt */
/* JADX INFO: loaded from: classes.dex */
@Metadata(m194d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0002\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u0010\u0010\u0005\u001a\u00020\u00032\u0006\u0010\u0006\u001a\u00020\u0007H\u0016J\b\u0010\b\u001a\u00020\u0003H\u0016R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\t"}, m195d2 = {"Lcoil/util/ImmutableHardwareBitmapService;", "Lcoil/util/HardwareBitmapService;", "allowHardware", "", "(Z)V", "allowHardwareMainThread", "size", "Lcoil/size/Size;", "allowHardwareWorkerThread", "coil-base_release"}, m196k = 1, m197mv = {1, 9, 0}, m199xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
final class ImmutableHardwareBitmapService implements HardwareBitmapService {
    private final boolean allowHardware;

    public ImmutableHardwareBitmapService(boolean allowHardware) {
        this.allowHardware = allowHardware;
    }

    @Override // coil.util.HardwareBitmapService
    public boolean allowHardwareMainThread(Size size) {
        return this.allowHardware;
    }

    @Override // coil.util.HardwareBitmapService
    /* JADX INFO: renamed from: allowHardwareWorkerThread, reason: from getter */
    public boolean getAllowHardware() {
        return this.allowHardware;
    }
}
