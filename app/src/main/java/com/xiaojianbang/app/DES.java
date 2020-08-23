package com.xiaojianbang.app;

import android.util.Base64;
import java.security.spec.AlgorithmParameterSpec;
import javax.crypto.Cipher;
import javax.crypto.SecretKey;
import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.DESKeySpec;
import javax.crypto.spec.IvParameterSpec;

public class DES {
    public static String des_1(String args) throws Exception {
        SecretKey secretKey = SecretKeyFactory.getInstance("DES").generateSecret(new DESKeySpec("12345678".getBytes()));
        AlgorithmParameterSpec iv = new IvParameterSpec("87654321".getBytes());
        Cipher cipher = Cipher.getInstance("DES/CBC/PKCS5Padding");
        cipher.init(1, secretKey, iv);
        cipher.update(args.getBytes());
        return Base64.encodeToString(cipher.doFinal(), 0);
    }

    public static String des_2(String args) throws Exception {
        SecretKey secretKey = SecretKeyFactory.getInstance("DES").generateSecret(new DESKeySpec("12345678".getBytes()));
        AlgorithmParameterSpec iv = new IvParameterSpec("87654321".getBytes());
        Cipher cipher = Cipher.getInstance("DES/CBC/PKCS5Padding");
        cipher.init(1, secretKey, iv);
        return Base64.encodeToString(cipher.doFinal(args.getBytes()), 0);
    }
}