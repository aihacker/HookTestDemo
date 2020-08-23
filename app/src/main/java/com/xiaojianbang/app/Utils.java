package com.xiaojianbang.app;

public class Utils {
    public static String byteToHexString(byte[] by) {
        StringBuffer SB = new StringBuffer();
        for (byte b : by) {
            int j = b;
            if (b < 0) {
                j = b + 256;
            }
            if (j < 16) {
                SB.append("0");
            }
            SB.append(Integer.toHexString(j));
        }
        return SB.toString();
    }

    public static byte[] hexStringToByte(byte[] b) {
        if (b.length % 2 != 0) {
            throw new IllegalArgumentException("长度不是偶数");
        }
        byte[] b2 = new byte[(b.length / 2)];
        for (int n = 0; n < b.length; n += 2) {
            b2[n / 2] = (byte) Integer.parseInt(new String(b, n, 2), 16);
        }
        return b2;
    }
}
