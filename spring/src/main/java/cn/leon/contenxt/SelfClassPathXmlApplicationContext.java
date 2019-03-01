package cn.leon.contenxt;

import cn.leon.SelfBeanDefinition;
import cn.leon.factory.SelfAutowireCapableBeanFactory;
import cn.leon.factory.SelfBeanFactory;
import cn.leon.resource.URLResource;
import cn.leon.xml.SelfXmlBeanDefinitionReader;

import java.util.Map;

public class SelfClassPathXmlApplicationContext implements SelfApplicationContext {

    private String configLocation;

    private SelfBeanFactory beanFactory;

    public SelfClassPathXmlApplicationContext(String configLocation){
        this(configLocation, new SelfAutowireCapableBeanFactory());
    }

    public SelfClassPathXmlApplicationContext(String configLocation, SelfBeanFactory beanFactory){
        this.configLocation = configLocation;
        this.beanFactory = beanFactory;
        refresh();
    }

    private void refresh(){
        SelfXmlBeanDefinitionReader xmlBeanDefinitionReader = new SelfXmlBeanDefinitionReader(new URLResource(configLocation));
        for(Map.Entry<String, SelfBeanDefinition> entry : xmlBeanDefinitionReader.getBeanDefinitionMap().entrySet()) {
            this.beanFactory.registerBeanDefinition(entry.getKey(), entry.getValue());
        }
    }

    @Override
    public Object getBean(String name) {
        return beanFactory.getBean(name);
    }
}
