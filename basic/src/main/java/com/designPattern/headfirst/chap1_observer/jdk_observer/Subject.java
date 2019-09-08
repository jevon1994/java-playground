package com.designPattern.headfirst.chap1_observer.jdk_observer;

/**
 * @author mujian
 * @Desc
 * @date 2019/8/30 13:36
 */
public interface Subject {
    void registerObserver();

    void removeObserver();

    void notifyObserver();
}
