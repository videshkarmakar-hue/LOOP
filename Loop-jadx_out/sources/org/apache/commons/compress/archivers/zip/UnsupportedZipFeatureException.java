package org.apache.commons.compress.archivers.zip;

import java.util.zip.ZipException;

/* JADX INFO: loaded from: classes18.dex */
public class UnsupportedZipFeatureException extends ZipException {
    private static final long serialVersionUID = 20130101;
    private final ZipArchiveEntry entry;
    private final Feature reason;

    public UnsupportedZipFeatureException(Feature reason, ZipArchiveEntry entry) {
        super("unsupported feature " + reason + " used in entry " + entry.getName());
        this.reason = reason;
        this.entry = entry;
    }

    public UnsupportedZipFeatureException(ZipMethod method, ZipArchiveEntry entry) {
        super("unsupported feature method '" + method.name() + "' used in entry " + entry.getName());
        this.reason = Feature.METHOD;
        this.entry = entry;
    }

    public UnsupportedZipFeatureException(Feature reason) {
        super("unsupported feature " + reason + " used in archive.");
        this.reason = reason;
        this.entry = null;
    }

    public Feature getFeature() {
        return this.reason;
    }

    public ZipArchiveEntry getEntry() {
        return this.entry;
    }

    public static class Feature {
        private final String name;
        public static final Feature ENCRYPTION = new Feature("encryption");
        public static final Feature METHOD = new Feature("compression method");
        public static final Feature DATA_DESCRIPTOR = new Feature("data descriptor");
        public static final Feature SPLITTING = new Feature("splitting");

        private Feature(String name) {
            this.name = name;
        }

        public String toString() {
            return this.name;
        }
    }
}
