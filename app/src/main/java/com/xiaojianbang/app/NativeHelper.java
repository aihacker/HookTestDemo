package com.xiaojianbang.app;

public class NativeHelper {
    public static native int add(int i, int i2, int i3);

    public static native String encode(String str);

    public static native String helloFromC();

    static {
        System.loadLibrary("native-lib");
    }
}