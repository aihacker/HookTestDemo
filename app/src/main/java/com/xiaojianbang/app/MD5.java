package com.xiaojianbang.app;

import java.security.MessageDigest;

public class MD5 {
    public static String md5_1(String args) throws Exception {
        MessageDigest md = MessageDigest.getInstance("MD5", "BC");
        md.update(args.getBytes());
        return Utils.byteToHexString(md.digest());
    }

    public static String md5_2(String args) throws Exception {
        MessageDigest md = MessageDigest.getInstance("MD5", "BC");
        md.update(args.getBytes(), 2, 5);
        return Utils.byteToHexString(md.digest("xiaojianbang".getBytes()));
    }
}
