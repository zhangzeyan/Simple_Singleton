package com.simple.singleton.model;

/**
 * 单例模式，懒汉式（线性不安全）
 * Created by zhangzeyan on 16/11/3.
 */

public class SingletonLanHan {

    private static SingletonLanHan instance;

    private SingletonLanHan() {
    }

    public static synchronized SingletonLanHan getInstance() {
        if (instance == null) {
            instance = new SingletonLanHan();
        }
        return instance;
    }
}