package com.xiaojianbang.app;

import android.util.Base64;
import java.security.spec.AlgorithmParameterSpec;
import javax.crypto.Cipher;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;

public class AES {
    public static String aes(String args) throws Exception {
        SecretKeySpec key = new SecretKeySpec("1234567890abcdef1234567890abcdef".getBytes(), "AES");
        AlgorithmParameterSpec iv = new IvParameterSpec("1234567890abcdef".getBytes());
        Cipher aes = Cipher.getInstance("AES/CBC/PKCS5Padding");
        aes.init(1, key, iv);
        return Base64.encodeToString(aes.doFinal(args.getBytes("UTF-8")), 0);
    }
}