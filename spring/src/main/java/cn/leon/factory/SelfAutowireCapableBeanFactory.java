package cn.leon.factory;

import cn.leon.SelfBeanDefinition;
import cn.leon.SelfBeanReference;

import java.lang.reflect.Field;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class SelfAutowireCapableBeanFactory implements SelfBeanFactory {
    /**
     * 存放name和BeanDefinition的对应关系
     */
    private Map<String, SelfBeanDefinition> beanDefinitionMap = new ConcurrentHashMap<String, SelfBeanDefinition>();

    /**
     * 1.先获取bean
     * @param name
     * @return
     */
    @Override
    public Object getBean(String name) {
        SelfBeanDefinition beanDefinition = beanDefinitionMap.get(name);
        Object bean = beanDefinition.getBean();
        if (null == bean) {
            bean = doCreateBean(beanDefinition);
        }
        return bean;
    }

    /**
     * 2.再注入属性，解决循环依赖问题
     * @param name
     * @param beanDefinition
     */
    @Override
    public void registerBeanDefinition(String name, SelfBeanDefinition beanDefinition) {
        beanDefinitionMap.put(name, beanDefinition);
    }

    private Object doCreateBean(SelfBeanDefinition beanDefinition) {
        Object bean = null;
        try {
            bean = beanDefinition.getBeanClass().newInstance();
        } catch (Exception e) {
            e.printStackTrace();
        }
        //先设置bean，再注入属性，否则会产生循环依赖
        beanDefinition.setBean(bean);
        applyPropertyValues(bean, beanDefinition.getPropertyMap());
        return bean;
    }

    private void applyPropertyValues(Object bean, Map<String, Object> propertyMap) {

        for (Map.Entry<String, Object> entry : propertyMap.entrySet()) {
            try {
                Field field = bean.getClass().getDeclaredField(entry.getKey());
                field.setAccessible(true);
                Object value = entry.getValue();
                /**
                 * 判断是否为另一个bean的引用
                 */
                if (value instanceof SelfBeanReference) {
                    field.set(bean, this.getBean(((SelfBeanReference) value).getRef()));
                } else {
                    String type = field.getType().getName();
                    if (type.equals("java.lang.String")) {
                        field.set(bean, entry.getValue());
                    } else if (type.equals("java.lang.Integer") || type.equals("int")) {
                        field.set(bean, Integer.valueOf((String) entry.getValue()));
                    }
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}
