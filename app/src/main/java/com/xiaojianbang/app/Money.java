package com.xiaojianbang.app;

public class Money {
    private String name;
    private int num;
    public Money(String name, int num) {
        this.name = name;
        this.num = num;
    }

    public Money() {
        this.name = "RMB";
        this.num = 100;
    }

    public String getInfo() {
        return "";
    }

    public String name() {
        return name + ":" + num +"元";
    }
}
