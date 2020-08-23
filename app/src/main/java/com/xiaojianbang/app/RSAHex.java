package com.xiaojianbang.app;

import android.util.Base64;
import java.math.BigInteger;
import java.security.KeyFactory;
import java.security.PublicKey;
import java.security.spec.RSAPublicKeySpec;
import javax.crypto.Cipher;

public class RSAHex {
    public static String E = "010001";
    public static String N = "a32f7530324569c1d86dec45140c21ae0a6950d5331d22c591ab8c2834ecfbdf51682f494bbc07d17d7ff2b634fd13080954d9e145b6389ca3f23da22d52c1f70fdf716e56868cd7a49c3e8a13c30a18bdfd612d685efe8e36723e15d06446f0de4039a7cae690e96a23a3ba9193d80f1ad3afb1b70a76e2a927dba8fb63d6fb";

    public static PublicKey createPublicKey(String stringN, String stringE) throws Exception {
        return KeyFactory.getInstance("RSA").generatePublic(new RSAPublicKeySpec(new BigInteger(stringN, 16), new BigInteger(stringE, 16)));
    }

    public static String createPublicKey(String stringN) throws Exception {
        return Base64.encodeToString(KeyFactory.getInstance("RSA").generatePublic(new RSAPublicKeySpec(new BigInteger(stringN), new BigInteger("65537"))).getEncoded(), 0);
    }

    public static byte[] encrypt(String message, PublicKey key) throws Exception {
        Cipher cipher = Cipher.getInstance("RSA");
        cipher.init(1, key);
        return cipher.doFinal(message.getBytes());
    }

    public static String rsaHex(String args) throws Exception {
        return Base64.encodeToString(encrypt(args, createPublicKey(N, E)), 0);
    }
}
