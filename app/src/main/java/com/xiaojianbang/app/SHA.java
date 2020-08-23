package com.xiaojianbang.app;

import java.security.MessageDigest;

public class SHA {
    public static String sha_1(String args) throws Exception {
        MessageDigest md = MessageDigest.getInstance("SHA-1", "BC");
        md.update(args.getBytes());
        return Utils.byteToHexString(md.digest());
    }

    public static String sha_2(String args) throws Exception {
        MessageDigest md = MessageDigest.getInstance("SHA-1", "BC");
        md.update(args.getBytes(), 2, 5);
        return Utils.byteToHexString(md.digest("xiaojianbang".getBytes()));
    }
}