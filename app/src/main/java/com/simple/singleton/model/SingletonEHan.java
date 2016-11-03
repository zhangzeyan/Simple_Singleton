package com.simple.singleton.model;

/**
 * 单例模式，饿汉式（）
 * Created by zhangzeyan on 16/11/3.
 */

public class SingletonEHan {

    private static SingletonEHan instance = new SingletonEHan();

    private SingletonEHan() {
    }

    public static synchronized SingletonEHan getInstance() {
        return instance;
    }
}