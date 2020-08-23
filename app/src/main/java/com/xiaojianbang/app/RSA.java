package com.xiaojianbang.app;

import android.util.Base64;
import java.security.KeyFactory;
import java.security.PrivateKey;
import java.security.PublicKey;
import java.security.Signature;
import java.security.spec.PKCS8EncodedKeySpec;
import java.security.spec.X509EncodedKeySpec;
import javax.crypto.Cipher;

public class RSA {
    public static String priKey = "MIICdgIBADANBgkqhkiG9w0BAQEFAASCAmAwggJcAgEAAoGBAJWFpHc6vuy5SXAdSXYvLfq5WZuhnf4eGi+iAOMuBET0JtpSiRLZ6oZpUV9vEBTEVOE0O5er98EP5J1SCmmZxmsjDgcww/gC0TaoklAf8rE9aZtcfsu/70KKw209g6W9Yn8YdGp/3HdMEqON4nYKO5XGU8ENfrf4RyKXYlH2SVVrAgMBAAECgYAJ0TeGOI42nsfKm7GqF9juAGN4y3jDKZjQjdN/FxNir6Epboffe/1hC+My3+jvZCCqlLJg+AKRY4jAJ5XVbypO3tHRd9uLFgCjzREJ09J6SWyNj3KFKCkJ4vpaO0jbUAAtFGlLElc6ZtHNKabeJ0ECOgcIvVsfHpP47j1GTRU8oQJBAMXsksEmrIvCJ0l5mdDX73nRJzbxDK6m7jndE4fBe0h3Wl06iBCfuaS2x+PTjmiRWvfFu2B1/9E9Tt0jc4FQS3ECQQDBZUKZjnv6rKtwqBj1EqjIXVF2SAsttW/6vTpg6mhHYITlrqQqrt1NJ5+6PRVQr1FLDxPArNVSdoz6MFIIAiibAkA+3K+Tt0PQM78koAGRijPePea1lYPQqOY67JN6Z6JPVtEVkTSMCx78SK1eF+BAKAJ7dYrYzUGN5Gn65HqYFLeRAkBcBOFWjSxCjwwX03PkkBdNFtHe9NKU0iLQ7F6tpHsvkyZI3vrv8DoOLw9aHxxYQsLscuUUJWhvD0du97TgaJ6HAkEAoRXjsQO2UmgQcddE2e6Uxp5riOuWIEEzoW6YssCW9BznCnwXy/xamrTKhoW2cIHwn6cFx+MFmyaK5T0xAtF5pw==";
    public static String pubKey = "MIGfMA0GCSqGSIb3DQEBAQUAA4GNADCBiQKBgQC9xhBZOWWF5Icw384mJksmaJ53RBLPUbEq5hXWW4Xgf82r6Zj24e3MWOnBTcblDodXYtSsaRJilosdTQVWGetJewebKmyqh1l1lUagS1/dbII9GsGat5zMboMHLWUO9NoBS9VDxqYL2VLppNEj/Xe39gBRHIiSnmtggiHuYsEv8wIDAQAB";

    public static PublicKey getPublicKey(String key) throws Exception {
        return KeyFactory.getInstance("RSA").generatePublic(new X509EncodedKeySpec(Base64.decode(key, 0)));
    }

    public static PrivateKey getPrivateKey(String key) throws Exception {
        return KeyFactory.getInstance("RSA").generatePrivate(new PKCS8EncodedKeySpec(Base64.decode(key, 0)));
    }

    public static String sign(String data) throws Exception {
        PrivateKey priK = getPrivateKey(priKey);
        Signature sig = Signature.getInstance("SHA256withRSA");
        sig.initSign(priK);
        sig.update(data.getBytes());
        return Base64.encodeToString(sig.sign(), 0);
    }

    public static boolean verify(byte[] data, byte[] sign) throws Exception {
        PublicKey pubK = getPublicKey(pubKey);
        Signature sig = Signature.getInstance("SHA256withRSA");
        sig.initVerify(pubK);
        sig.update(data);
        return sig.verify(sign);
    }

    public static byte[] encrypt(byte[] plaintext) throws Exception {
        PublicKey publicKey = getPublicKey(pubKey);
        Cipher cipher = Cipher.getInstance("RSA/None/NoPadding", "BC");
        cipher.init(1, publicKey);
        return cipher.doFinal(plaintext);
    }

    public static byte[] decrypt(byte[] encrypted) throws Exception {
        PrivateKey privateKey = getPrivateKey(priKey);
        Cipher cipher = Cipher.getInstance("RSA/None/PKCS1Padding", "BC");
        cipher.init(2, privateKey);
        return cipher.doFinal(encrypted);
    }

    public static String rsa(String args) throws Exception {
        return Base64.encodeToString(encrypt("xiaojianbang".getBytes()), 0);
    }
}
