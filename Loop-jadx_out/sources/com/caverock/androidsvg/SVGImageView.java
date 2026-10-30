package com.caverock.androidsvg;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Paint;
import android.graphics.Picture;
import android.graphics.drawable.PictureDrawable;
import android.net.Uri;
import android.os.AsyncTask;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.Method;

/* JADX INFO: loaded from: classes.dex */
public class SVGImageView extends ImageView {
    private static Method setLayerTypeMethod;
    private RenderOptions renderOptions;
    private SVG svg;

    static {
        setLayerTypeMethod = null;
        try {
            setLayerTypeMethod = View.class.getMethod("setLayerType", Integer.TYPE, Paint.class);
        } catch (NoSuchMethodException e) {
        }
    }

    public SVGImageView(Context context) {
        super(context);
        this.svg = null;
        this.renderOptions = new RenderOptions();
    }

    public SVGImageView(Context context, AttributeSet attrs) {
        super(context, attrs, 0);
        this.svg = null;
        this.renderOptions = new RenderOptions();
        init(attrs, 0);
    }

    public SVGImageView(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
        this.svg = null;
        this.renderOptions = new RenderOptions();
        init(attrs, defStyle);
    }

    private void init(AttributeSet attrs, int defStyle) {
        if (isInEditMode()) {
            return;
        }
        TypedArray a = getContext().getTheme().obtainStyledAttributes(attrs, C2608R.styleable.SVGImageView, defStyle, 0);
        try {
            String css = a.getString(C2608R.styleable.SVGImageView_css);
            if (css != null) {
                this.renderOptions.css(css);
            }
            int resourceId = a.getResourceId(C2608R.styleable.SVGImageView_svg, -1);
            if (resourceId != -1) {
                setImageResource(resourceId);
                return;
            }
            String url = a.getString(C2608R.styleable.SVGImageView_svg);
            if (url != null) {
                Uri uri = Uri.parse(url);
                if (internalSetImageURI(uri)) {
                    return;
                }
                if (internalSetImageAsset(url)) {
                } else {
                    setFromString(url);
                }
            }
        } finally {
            a.recycle();
        }
    }

    public void setSVG(SVG svg) {
        if (svg == null) {
            throw new IllegalArgumentException("Null value passed to setSVG()");
        }
        this.svg = svg;
        doRender();
    }

    public void setSVG(SVG svg, String css) {
        if (svg == null) {
            throw new IllegalArgumentException("Null value passed to setSVG()");
        }
        this.svg = svg;
        this.renderOptions.css(css);
        doRender();
    }

    public void setCSS(String css) {
        this.renderOptions.css(css);
        doRender();
    }

    @Override // android.widget.ImageView
    public void setImageResource(int resourceId) {
        new LoadResourceTask(getContext(), resourceId).execute(new Integer[0]);
    }

    @Override // android.widget.ImageView
    public void setImageURI(Uri uri) {
        if (!internalSetImageURI(uri)) {
            Log.e("SVGImageView", "File not found: " + uri);
        }
    }

    public void setImageAsset(String filename) {
        if (!internalSetImageAsset(filename)) {
            Log.e("SVGImageView", "File not found: " + filename);
        }
    }

    private boolean internalSetImageURI(Uri uri) {
        try {
            InputStream is = getContext().getContentResolver().openInputStream(uri);
            new LoadURITask().execute(is);
            return true;
        } catch (FileNotFoundException e) {
            return false;
        }
    }

    private boolean internalSetImageAsset(String filename) {
        try {
            InputStream is = getContext().getAssets().open(filename);
            new LoadURITask().execute(is);
            return true;
        } catch (IOException e) {
            return false;
        }
    }

    private void setFromString(String url) {
        try {
            this.svg = SVG.getFromString(url);
            doRender();
        } catch (SVGParseException e) {
            Log.e("SVGImageView", "Could not find SVG at: " + url);
        }
    }

    private class LoadResourceTask extends AsyncTask<Integer, Integer, SVG> {
        private Context context;
        private int resourceId;

        LoadResourceTask(Context context, int resourceId) {
            this.context = context;
            this.resourceId = resourceId;
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // android.os.AsyncTask
        public SVG doInBackground(Integer... params) {
            try {
                return SVG.getFromResource(this.context, this.resourceId);
            } catch (SVGParseException e) {
                Log.e("SVGImageView", String.format("Error loading resource 0x%x: %s", Integer.valueOf(this.resourceId), e.getMessage()));
                return null;
            }
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // android.os.AsyncTask
        public void onPostExecute(SVG svg) {
            SVGImageView.this.svg = svg;
            SVGImageView.this.doRender();
        }
    }

    private class LoadURITask extends AsyncTask<InputStream, Integer, SVG> {
        private LoadURITask() {
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // android.os.AsyncTask
        public SVG doInBackground(InputStream... is) {
            try {
                return SVG.getFromInputStream(is[0]);
            } catch (SVGParseException e) {
                Log.e("SVGImageView", "Parse error loading URI: " + e.getMessage());
                try {
                    return null;
                } catch (IOException e2) {
                    return null;
                }
            } finally {
                try {
                    is[0].close();
                } catch (IOException e3) {
                }
            }
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // android.os.AsyncTask
        public void onPostExecute(SVG svg) {
            SVGImageView.this.svg = svg;
            SVGImageView.this.doRender();
        }
    }

    private void setSoftwareLayerType() {
        if (setLayerTypeMethod == null) {
            return;
        }
        try {
            int LAYER_TYPE_SOFTWARE = View.class.getField("LAYER_TYPE_SOFTWARE").getInt(new View(getContext()));
            setLayerTypeMethod.invoke(this, Integer.valueOf(LAYER_TYPE_SOFTWARE), null);
        } catch (Exception e) {
            Log.w("SVGImageView", "Unexpected failure calling setLayerType", e);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void doRender() {
        if (this.svg == null) {
            return;
        }
        Picture picture = this.svg.renderToPicture(this.renderOptions);
        setSoftwareLayerType();
        setImageDrawable(new PictureDrawable(picture));
    }
}
