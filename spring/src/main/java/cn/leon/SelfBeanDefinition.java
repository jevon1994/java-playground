package cn.leon;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class SelfBeanDefinition {
    private Object bean;

    private Class beanClass;

    private String beanClassName;

    private Map<String, Object> propertyMap = new ConcurrentHashMap<String, Object>();

    public SelfBeanDefinition(String beanClassName){
        setBeanClassName(beanClassName);
    }

    public Object getBean(){
        return this.bean;
    }

    public void setBean(Object bean) {
        this.bean = bean;
    }

    public Class getBeanClass() {
        return beanClass;
    }

    public void setBeanClass(Class beanClass) {
        this.beanClass = beanClass;
    }

    public String getBeanClassName() {
        return beanClassName;
    }

    public void setBeanClassName(String beanClassName) {
        this.beanClassName = beanClassName;
        try{
            this.beanClass = Class.forName(beanClassName);
        }catch (ClassNotFoundException e){
            e.printStackTrace();
        }
    }

    public void setProperty(String name, Object value){
        propertyMap.put(name, value);
    }

    public Map<String, Object> getPropertyMap(){
        return this.propertyMap;
    }
}
