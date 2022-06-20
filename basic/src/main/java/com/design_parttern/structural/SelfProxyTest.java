package com.design_parttern.structural;

import lombok.AllArgsConstructor;
import lombok.SneakyThrows;
import net.sf.cglib.core.DebuggingClassWriter;
import net.sf.cglib.proxy.Enhancer;
import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.Properties;

public class SelfProxyTest {
    public static void main(String[] args) {
//        staticProxy();
        System.getProperties().put("sun.misc.ProxyGenerator.saveGeneratedFiles","true");
//        jdkProxy();

        cglibProxy();

    }

    public static void staticProxy() {
        SelfProxy SelfProxy = new SelfProxy();
        SelfProxy.invoke();
    }

    /**
     * 1. 类加载器:生成类和其调用类必须通过同一个类加载器加载，否则它们之间无法相互调用,尽管它们都存储在共享的方法区域中，但它们只能使用由自身及其父级加载的类
     * 2. 接口类数组: 接口类, 被代理的对象
     * 3. InvocationHandler: 针对接口方法进行增强, 获取sql , 执行 sql
     */
    public static void jdkProxy() {
        Source source = (Source) Proxy.newProxyInstance(Source.class.getClassLoader(),
                new Class[]{Source.class},
                new JdkProxy(new Sourceable()));
        source.invoke();
    }

    /**
     * 1. 生成字节码
     * 2. 根据字节码生成代理类 Class.forName
     * 3. 调用
     */
    public static void cglibProxy() {
        saveGeneratedCGlibProxyFiles("com/design_parttern/structural");

        Enhancer enhancer = new Enhancer();
        enhancer.setSuperclass(ProxyTarget.class);
        enhancer.setCallback(new CglibProxy());
        ProxyTarget proxyTarget = (ProxyTarget) enhancer.create();
        System.out.println(proxyTarget);
        proxyTarget.invoke();
    }
    @SneakyThrows
    public static void saveGeneratedCGlibProxyFiles(String dir){
        Field field = System.class.getDeclaredField("props");
        field.setAccessible(true);
        Properties props = (Properties) field.get(null);
        System.setProperty(DebuggingClassWriter.DEBUG_LOCATION_PROPERTY, dir);
        props.put("net.sf.cglib.core.DebuggingClassWriter.traceEnabled", "true");
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
