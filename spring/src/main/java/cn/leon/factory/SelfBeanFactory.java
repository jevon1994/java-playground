package cn.leon.factory;

import cn.leon.SelfBeanDefinition;

public interface SelfBeanFactory {

    Object getBean(String name);

    void registerBeanDefinition(String name, SelfBeanDefinition beanDefinition);
}
