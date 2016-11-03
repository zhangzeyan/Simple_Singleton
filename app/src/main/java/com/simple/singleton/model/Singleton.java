package com.simple.singleton.model;

/**
 *
 * 单例模式，双重校验锁（）
 * Created by zhangzeyan on 16/11/3.
 */

public class Singleton {

    private volatile static Singleton singleton;

    private Singleton() {
    }

    public static Singleton getSingleton() {
        if (singleton == null) {
            synchronized (Singleton.class) {
                if (singleton == null) {
                    singleton = new Singleton();
                }
            }
        }
        return singleton;
    }
}
