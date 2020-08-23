package com.xiaojianbang.app;

public class Utils {
    public static int getCalc(int a, int b){
        return a + b;
    }

    public static int _getCalc(int a, int b, int c){
        return a + b + c;
    }

    public static Money getMoney(){
        return new Money("RMB", 100);
    }
    public static String test(){
        return "资源共享吧";
    }

    public static String test(int num){
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("www.zygx8.com");
        stringBuilder.append(num);
        return stringBuilder.toString();
    }

    public static String test(Money money){
        return money.getInfo();
    }

    public String myPrint(String[] strArr){
        StringBuilder stringBuilder = new StringBuilder();
        for(String str : strArr){
            stringBuilder.append(str);
        }
        return stringBuilder.toString();
    }

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
