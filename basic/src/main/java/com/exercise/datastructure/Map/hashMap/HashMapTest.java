package com.exercise.datastructure.Map.hashMap;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Random;

public class HashMapTest {
    public static void main(String[] args) {


        Map<String, String> map = new HashMap<String, String>();
        map.put("1", "value1");
        map.put("2", "value2");
        map.put("3", "value3");

        //第一种：普遍使用，二次取值
        System.out.println("通过Map.keySet遍历key和value：");
        for (String key : map.keySet()) {
            System.out.println("key= " + key + " and value= " + map.get(key));
        }

        //第二种
        System.out.println("通过Map.entrySet使用iterator遍历key和value：");
        Iterator<Map.Entry<String, String>> it = map.entrySet().iterator();
        while (it.hasNext()) {
            Map.Entry<String, String> entry = it.next();
            System.out.println("key= " + entry.getKey() + " and value= " + entry.getValue());
        }

        //第三种：推荐，尤其是容量大时
        System.out.println("通过Map.entrySet遍历key和value");
        for (Map.Entry<String, String> entry : map.entrySet()) {
            System.out.println("key= " + entry.getKey() + " and value= " + entry.getValue());
        }

        //第四种
        System.out.println("通过Map.values()遍历所有的value，但不能遍历key");
        for (String v : map.values()) {
            System.out.println("value= " + v);
        }

        testHashMapAPIs();
    }

    private static void testHashMapAPIs() {
        // 初始化随机种子
        Random r = new Random();
        // 新建HashMap
        HashMap map = new HashMap();
        // 添加操作
        map.put("one", r.nextInt(10));
        map.put("two", r.nextInt(10));
        map.put("three", r.nextInt(10));

        // 打印出map
        System.out.println("map:" + map);

        // 通过Iterator遍历key-value
        Iterator iter = map.entrySet().iterator();
        while (iter.hasNext()) {
            Map.Entry entry = (Map.Entry) iter.next();
            System.out.println("next : " + entry.getKey() + " - " + entry.getValue());
        }

        // HashMap的键值对个数
        System.out.println("size:" + map.size());

        // containsKey(Object key) :是否包含键key
        System.out.println("contains key two : " + map.containsKey("two"));
        System.out.println("contains key five : " + map.containsKey("five"));

        // containsValue(Object value) :是否包含值value
        System.out.println("contains value 0 : " + map.containsValue(new Integer(0)));

        // remove(Object key) ： 删除键key对应的键值对
        map.remove("three");

        System.out.println("map:" + map);

        // clear() ： 清空HashMap
        map.clear();

        // isEmpty() : HashMap是否为空
        System.out.println((map.isEmpty() ? "map is empty" : "map is not empty"));
    }
}
