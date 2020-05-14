package com.design_parttern.structural;

import lombok.AllArgsConstructor;
import net.sf.cglib.proxy.Enhancer;
import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public class SelfProxyTest {
    public static void main(String[] args) {
        staticProxy();

        jdkProxy();

        cglibProxy();

    }

    public static void staticProxy() {
        SelfProxy SelfProxy = new SelfProxy();
        SelfProxy.invoke();
    }

    public static void jdkProxy() {
        Source source = (Source) Proxy.newProxyInstance(Source.class.getClassLoader(),
                new Class[]{Source.class},
                new JdkProxy(new Sourceable()));
        source.invoke();
    }

    public static void cglibProxy() {
        Enhancer enhancer = new Enhancer();
        enhancer.setSuperclass(ProxyTarget.class);
        enhancer.setCallback(new CglibProxy());
        ProxyTarget proxyTarget = (ProxyTarget) enhancer.create();
        proxyTarget.invoke();
    }
}

interface Source {
    void invoke();
}

class Sourceable implements Source {

    @Override
    public void invoke() {
        System.out.println("real invoke");
    }
}

// 静态代理
class SelfProxy implements Source {

    @Override
    public void invoke() {
        before();
        Sourceable sourceable = new Sourceable();
        sourceable.invoke();
        after();
    }

    private void after() {
        System.out.println("after");
    }

    private void before() {
        System.out.println("before");
    }
}

/**
 * jdk动态代理
 */

@AllArgsConstructor
class JdkProxy implements InvocationHandler {
    private Object target;

    @Override
    public Object invoke(Object SelfProxy, Method method, Object[] args) throws Throwable {
        System.out.println("before");
        Object result = method.invoke(target, args);
        System.out.println("after");
        return result;
    }
}

class ProxyTarget {

    public void invoke() {
        System.out.println("real invoke");
    }
}


class CglibProxy implements MethodInterceptor {

    @Override
    public Object intercept(Object o, Method method, Object[] objects, MethodProxy methodProxy) throws Throwable {
        System.out.println("before");
        Object result = methodProxy.invokeSuper(o, objects);
        System.out.println("after");
        return result;
    }
}
