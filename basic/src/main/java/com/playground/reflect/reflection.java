package com.playground.reflect;


import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.reflect.InvocationTargetException;

/**
 * 获取注解的值
 */
public class reflection {
    public static void main(String[] args) throws ClassNotFoundException, NoSuchMethodException, InvocationTargetException, IllegalAccessException {
        try {
            // 根据“类名”获取 对应的Class对象
            Class<?> cls = Class.forName("com.playground.reflect.Person");

            // 获取“Person类”的注解
            int myann = cls.getAnnotation(MyAnnotation.class).value();

            System.out.println("myann=" + myann);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}


@Retention(RetentionPolicy.RUNTIME)
@interface MyAnnotation {
    int value() default 1;
}

/**
 * MyAnnotation 是Person的注解。
 */
@MyAnnotation(value = 2)
class Person {
}
