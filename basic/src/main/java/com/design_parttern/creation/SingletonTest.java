package com.design_parttern.creation;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class SingletonTest {
    public static void main(String[] args) {

    }
}

// DCL
class SingletonDCL {
    private volatile static SingletonDCL instance;

    private SingletonDCL() {

    }

    public static SingletonDCL getInstance() {
        if (instance == null) {
            synchronized (SingletonDCL.class) {
                if (instance == null) {
                    instance = new SingletonDCL();
                }
            }
        }
        return instance;
    }
}

// 匿名内部类
class SingletonInnerClass {
    private SingletonInnerClass() {
    }

    public static SingletonInnerClass getInstance() {
        return SingletonInner.instance;
    }

    private static class SingletonInner {
        private static final SingletonInnerClass instance = new SingletonInnerClass();
    }
}

// 枚举
enum SingletonEnum {
    INSTACN;
}

// 单例注册表
class SingleRegistor {
    private SingleRegistor() {
    }

    private final static Map<String, Object> manager = new ConcurrentHashMap<>();

    public Object getInstance(String name) {
        synchronized (manager) {
            SingleRegistor single = (SingleRegistor) manager.get(name);
            if (single == null) {
                manager.put(name, single);
            }
            return single != null ? single : null;
        }
    }
}

