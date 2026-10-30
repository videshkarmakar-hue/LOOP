package org.apache.commons.compress.archivers;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;

/* JADX INFO: loaded from: classes18.dex */
public final class Lister {
    private static final ArchiveStreamFactory factory = new ArchiveStreamFactory();

    public static void main(String[] args) throws Exception {
        ArchiveInputStream ais;
        if (args.length == 0) {
            usage();
            return;
        }
        System.out.println("Analysing " + args[0]);
        File f = new File(args[0]);
        if (!f.isFile()) {
            System.err.println(f + " doesn't exist or is a directory");
        }
        InputStream fis = new BufferedInputStream(new FileInputStream(f));
        if (args.length > 1) {
            ais = factory.createArchiveInputStream(args[1], fis);
        } else {
            ais = factory.createArchiveInputStream(fis);
        }
        System.out.println("Created " + ais.toString());
        while (true) {
            ArchiveEntry ae = ais.getNextEntry();
            if (ae != null) {
                System.out.println(ae.getName());
            } else {
                ais.close();
                fis.close();
                return;
            }
        }
    }

    private static void usage() {
        System.out.println("Parameters: archive-name [archive-type]");
    }
}
