package com.atom.healthcare.util;
import java.security.spec.KeySpec;
import javax.crypto.Cipher;
import javax.crypto.SecretKey;
import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.DESedeKeySpec;
import org.apache.commons.codec.binary.Base64;

public class EncryptAndDecryptKey{

    private static final String UNICODE_FORMAT = "UTF8";
    public static final String DESEDE_ENCRYPTION_SCHEME = "DESede";
    private KeySpec kSpec;
    private SecretKeyFactory secretKFac;
    private Cipher cipher;
    byte[] arrayBytes;
    private String encryptionKey;
    private String encryptionScheme;
    SecretKey key;

    public EncryptAndDecryptKey() throws Exception {
    	encryptionKey = "AnsydtebGHAdetAJsrAOIIDSFRH";
    	encryptionScheme = DESEDE_ENCRYPTION_SCHEME;
        arrayBytes = encryptionKey.getBytes(UNICODE_FORMAT);
        kSpec = new DESedeKeySpec(arrayBytes);
        secretKFac = SecretKeyFactory.getInstance(encryptionScheme);
        cipher = Cipher.getInstance(encryptionScheme);
        key = secretKFac.generateSecret(kSpec);
    }

    public String getEncrypt(String unencryptedString) {
        String encryptedString = null;
        try {
            cipher.init(Cipher.ENCRYPT_MODE, key);
            byte[] plainText = unencryptedString.getBytes(UNICODE_FORMAT);
            byte[] encryptedText = cipher.doFinal(plainText);
            encryptedString = new String(Base64.encodeBase64(encryptedText));
        } catch (Exception e) {
            e.printStackTrace();
        }
        return encryptedString;
    }

    public String getDecrypt(String encryptedString) {
        String decryptedText=null;
        try {
            cipher.init(Cipher.DECRYPT_MODE, key);
            byte[] encryptedText = Base64.decodeBase64(encryptedString);
            byte[] plainText = cipher.doFinal(encryptedText);
            decryptedText= new String(plainText);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return decryptedText;
    }

}