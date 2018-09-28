package exercise.proxy.JdkProxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

//JDK动态代理类
class MyInvocationHandler implements InvocationHandler {
    private Object target = null;

    //绑定委托对象并返回一个代理类
    public Object bind(Object target) {
        this.target = target;
        return Proxy.newProxyInstance(target.getClass().getClassLoader(),
                target.getClass().getInterfaces(), this); //要绑定接口（cglib弥补了这一点）
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        System.out.println("before");
        Object temp = method.invoke(target, args);
        System.out.println("after");
        return temp;
    }
}