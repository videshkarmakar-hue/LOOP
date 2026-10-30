package org.apache.commons.compress.archivers.sevenz;

import java.io.IOException;
import java.io.InputStream;
import java.security.GeneralSecurityException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import javax.crypto.Cipher;
import javax.crypto.CipherInputStream;
import javax.crypto.SecretKey;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;
import org.apache.commons.compress.PasswordRequiredException;

/* JADX INFO: loaded from: classes18.dex */
class AES256SHA256Decoder extends CoderBase {
    AES256SHA256Decoder() {
        super(new Class[0]);
    }

    @Override // org.apache.commons.compress.archivers.sevenz.CoderBase
    InputStream decode(final String archiveName, final InputStream in, long uncompressedLength, final Coder coder, final byte[] passwordBytes) throws IOException {
        return new InputStream() { // from class: org.apache.commons.compress.archivers.sevenz.AES256SHA256Decoder.1
            private boolean isInitialized = false;
            private CipherInputStream cipherInputStream = null;

            private CipherInputStream init() throws IOException {
                byte[] aesKeyBytes;
                if (this.isInitialized) {
                    return this.cipherInputStream;
                }
                int byte0 = coder.properties[0] & 255;
                int numCyclesPower = byte0 & 63;
                int byte1 = coder.properties[1] & 255;
                int ivSize = (byte1 & 15) + ((byte0 >> 6) & 1);
                int saltSize = (byte1 >> 4) + ((byte0 >> 7) & 1);
                if (saltSize + 2 + ivSize > coder.properties.length) {
                    throw new IOException("Salt size + IV size too long in " + archiveName);
                }
                byte[] salt = new byte[saltSize];
                System.arraycopy(coder.properties, 2, salt, 0, saltSize);
                byte[] iv = new byte[16];
                System.arraycopy(coder.properties, saltSize + 2, iv, 0, ivSize);
                if (passwordBytes == null) {
                    throw new PasswordRequiredException(archiveName);
                }
                if (numCyclesPower == 63) {
                    byte[] aesKeyBytes2 = new byte[32];
                    System.arraycopy(salt, 0, aesKeyBytes2, 0, saltSize);
                    System.arraycopy(passwordBytes, 0, aesKeyBytes2, saltSize, Math.min(passwordBytes.length, aesKeyBytes2.length - saltSize));
                    aesKeyBytes = aesKeyBytes2;
                } else {
                    try {
                        MessageDigest digest = MessageDigest.getInstance("SHA-256");
                        byte[] extra = new byte[8];
                        for (long j = 0; j < (1 << numCyclesPower); j++) {
                            digest.update(salt);
                            digest.update(passwordBytes);
                            digest.update(extra);
                            for (int k = 0; k < extra.length; k++) {
                                extra[k] = (byte) (extra[k] + 1);
                                if (extra[k] != 0) {
                                    break;
                                }
                            }
                        }
                        aesKeyBytes = digest.digest();
                    } catch (NoSuchAlgorithmException noSuchAlgorithmException) {
                        throw new IOException("SHA-256 is unsupported by your Java implementation", noSuchAlgorithmException);
                    }
                }
                SecretKey aesKey = new SecretKeySpec(aesKeyBytes, "AES");
                try {
                    Cipher cipher = Cipher.getInstance("AES/CBC/NoPadding");
                    cipher.init(2, aesKey, new IvParameterSpec(iv));
                    this.cipherInputStream = new CipherInputStream(in, cipher);
                    this.isInitialized = true;
                    return this.cipherInputStream;
                } catch (GeneralSecurityException generalSecurityException) {
                    throw new IOException("Decryption error (do you have the JCE Unlimited Strength Jurisdiction Policy Files installed?)", generalSecurityException);
                }
            }

            @Override // java.io.InputStream
            public int read() throws IOException {
                return init().read();
            }

            @Override // java.io.InputStream
            public int read(byte[] b, int off, int len) throws IOException {
                return init().read(b, off, len);
            }

            @Override // java.io.InputStream, java.io.Closeable, java.lang.AutoCloseable
            public void close() {
            }
        };
    }
}
