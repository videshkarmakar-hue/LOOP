package org.apache.commons.compress.compressors.pack200;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.HashMap;
import java.util.Map;
import java.util.jar.JarFile;
import java.util.jar.JarOutputStream;
import java.util.jar.Pack200;

/* JADX INFO: loaded from: classes18.dex */
public class Pack200Utils {
    private Pack200Utils() {
    }

    public static void normalize(File jar) throws IOException {
        normalize(jar, jar, null);
    }

    public static void normalize(File jar, Map<String, String> props) throws IOException {
        normalize(jar, jar, props);
    }

    public static void normalize(File from, File to) throws IOException {
        normalize(from, to, null);
    }

    public static void normalize(File from, File to, Map<String, String> props) throws IOException {
        if (props == null) {
            props = new HashMap();
        }
        props.put("pack.segment.limit", "-1");
        File f = File.createTempFile("commons-compress", "pack200normalize");
        f.deleteOnExit();
        try {
            OutputStream os = new FileOutputStream(f);
            JarFile j = null;
            try {
                Pack200.Packer p = Pack200.newPacker();
                p.properties().putAll(props);
                p.pack(new JarFile(from), os);
                j = null;
                os.close();
                Pack200.Unpacker u = Pack200.newUnpacker();
                os = new JarOutputStream(new FileOutputStream(to));
                u.unpack(f, (JarOutputStream) os);
                if (0 != 0) {
                    j.close();
                }
                os.close();
                f.delete();
            } catch (Throwable th) {
                if (j != null) {
                    j.close();
                }
                if (os != null) {
                    os.close();
                }
                throw th;
            }
        } catch (Throwable th2) {
            f.delete();
            throw th2;
        }
    }
}
