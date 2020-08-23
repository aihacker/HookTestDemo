package com.xiaojianbang.app;

import android.util.Base64;
import javax.crypto.Cipher;
import javax.crypto.SecretKey;
import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.DESedeKeySpec;

public class DESede {
    public static String desede(String args) throws Exception {
        SecretKey secretKey = SecretKeyFactory.getInstance("DESede").generateSecret(new DESedeKeySpec("123456781234567812345678".getBytes()));
        Cipher cipher = Cipher.getInstance("DESede/ECB/PKCS5Padding");
        cipher.init(1, secretKey);
        cipher.update(args.getBytes());
        return Base64.encodeToString(cipher.doFinal("xiaojianbang".getBytes()), 0);
    }
}
