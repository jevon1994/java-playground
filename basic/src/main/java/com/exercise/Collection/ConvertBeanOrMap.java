package com.exercise.Collection;


import java.beans.BeanInfo;
import java.beans.Introspector;
import java.beans.PropertyDescriptor;
import java.lang.reflect.Method;
import java.util.Map;
import java.util.TreeMap;

import lombok.Data;

/**
 * @author mujian
 * @Desc
 * @date 2019/8/14 10:16
 */
public class ConvertBeanOrMap {
    public static void main(String[] args) throws IllegalAccessException{
        Self self = new Self();
        self.setAttr("111");
        Map<String,Object> map = ConvertBeanOrMap.beanToMap(self);
        System.out.println(map.size());
    }

    public static Map<String, Object> beanToMap(Object obj) {
        if (obj == null) {
            return null;
        }
        TreeMap<String, Object> map = new TreeMap<>();
        try {
            BeanInfo beanInfo = Introspector.getBeanInfo(obj.getClass());
            PropertyDescriptor[] propertyDescriptors = beanInfo.getPropertyDescriptors();
            for (PropertyDescriptor property : propertyDescriptors) {
                String key = property.getName();
                // 过滤class属性
                if (key.equals("class")) {
                    continue;
                }
                // 得到property对应的getter方法
                Method getter = property.getReadMethod();
                Object value = getter.invoke(obj);

                map.put(key, value);
            }
        } catch (Exception e) {
            System.out.println("transBean2Map Error " + e);
        }
        return map;
    }
}

@Data
class Self {
    private String attr;
    private String attr1;
    private String attr2;
    private String attr3;
    private Long name = 1L;
}
