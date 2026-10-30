package com.caverock.androidsvg;

import android.content.res.AssetManager;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Typeface;
import android.util.Log;
import coil.util.Utils;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.nio.charset.Charset;
import java.util.HashSet;
import java.util.Set;
import org.apache.commons.compress.utils.CharsetNames;

/* JADX INFO: loaded from: classes.dex */
public class SimpleAssetResolver extends SVGExternalFileResolver {
    private static final String TAG = "SimpleAssetResolver";
    private static final Set<String> supportedFormats = new HashSet(8);
    private AssetManager assetManager;

    public SimpleAssetResolver(AssetManager assetManager) {
        this.assetManager = assetManager;
    }

    static {
        supportedFormats.add("image/svg+xml");
        supportedFormats.add(Utils.MIME_TYPE_JPEG);
        supportedFormats.add("image/png");
        supportedFormats.add("image/pjpeg");
        supportedFormats.add("image/gif");
        supportedFormats.add("image/bmp");
        supportedFormats.add("image/x-windows-bmp");
        supportedFormats.add(Utils.MIME_TYPE_WEBP);
    }

    @Override // com.caverock.androidsvg.SVGExternalFileResolver
    public Typeface resolveFont(String fontFamily, int fontWeight, String fontStyle) {
        Log.i(TAG, "resolveFont(" + fontFamily + "," + fontWeight + "," + fontStyle + ")");
        try {
            return Typeface.createFromAsset(this.assetManager, fontFamily + ".ttf");
        } catch (RuntimeException e) {
            try {
                return Typeface.createFromAsset(this.assetManager, fontFamily + ".otf");
            } catch (RuntimeException e2) {
                return null;
            }
        }
    }

    @Override // com.caverock.androidsvg.SVGExternalFileResolver
    public Bitmap resolveImage(String filename) {
        Log.i(TAG, "resolveImage(" + filename + ")");
        try {
            InputStream istream = this.assetManager.open(filename);
            return BitmapFactory.decodeStream(istream);
        } catch (IOException e) {
            return null;
        }
    }

    @Override // com.caverock.androidsvg.SVGExternalFileResolver
    public boolean isFormatSupported(String mimeType) {
        return supportedFormats.contains(mimeType);
    }

    @Override // com.caverock.androidsvg.SVGExternalFileResolver
    public String resolveCSSStyleSheet(String url) {
        Log.i(TAG, "resolveCSSStyleSheet(" + url + ")");
        return getAssetAsString(url);
    }

    private String getAssetAsString(String url) {
        InputStream is = null;
        try {
            is = this.assetManager.open(url);
            Reader r = new InputStreamReader(is, Charset.forName(CharsetNames.UTF_8));
            char[] buffer = new char[4096];
            StringBuilder sb = new StringBuilder();
            for (int len = r.read(buffer); len > 0; len = r.read(buffer)) {
                sb.append(buffer, 0, len);
            }
            return sb.toString();
        } catch (IOException e) {
            if (is != null) {
                try {
                    return null;
                } catch (IOException e2) {
                    return null;
                }
            }
            return null;
        } finally {
            if (is != null) {
                try {
                    is.close();
                } catch (IOException e3) {
                }
            }
        }
    }
}
