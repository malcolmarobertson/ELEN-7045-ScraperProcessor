package aps.application.util;

import aps.domain.exception.ApsException;

import javax.crypto.Cipher;
import javax.crypto.spec.SecretKeySpec;

import static aps.domain.shared.ApplicationConstants.SALT;

public class EncryptionUtility {

    public static String encrypt(String strClearText, String strKey) throws ApsException {
        String strData = "";

        try {
            SecretKeySpec skeyspec = new SecretKeySpec(strKey.getBytes(), SALT);
            Cipher cipher = Cipher.getInstance(SALT);
            cipher.init(Cipher.ENCRYPT_MODE, skeyspec);
            byte[] encrypted = cipher.doFinal(strClearText.getBytes());
            strData = new String(encrypted);

        } catch (Exception e) {
            e.printStackTrace();
            throw new ApsException(e.getMessage());
        }
        return strData;
    }

    public static String decrypt(String strEncrypted, String strKey) throws ApsException {
        String strData = "";

        try {
            SecretKeySpec skeyspec = new SecretKeySpec(strKey.getBytes(), SALT);
            Cipher cipher = Cipher.getInstance(SALT);
            cipher.init(Cipher.DECRYPT_MODE, skeyspec);
            byte[] decrypted = cipher.doFinal(strEncrypted.getBytes());
            strData = new String(decrypted);

        } catch (Exception e) {
            e.printStackTrace();
            throw new ApsException(e.getMessage());
        }
        return strData;
    }
}
