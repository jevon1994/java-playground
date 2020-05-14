package com.design_parttern.creation;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;

import java.util.HashMap;
import java.util.Map;

/**
 * @ClassName PrototypeTest
 * @Description
 * @Author Jevon
 * @Date2020/1/7 9:02
 **/
@Slf4j
public class PrototypeTest {
    public static void main(String[] args) throws CloneNotSupportedException {
        Prototype prototypeA = new Prototype("A", new HashMap<>());
        Prototype prototypeB = prototypeA.clone();
        log.info("A:{},B:{},result:{}", prototypeA, prototypeB, prototypeA.getMap() == prototypeB.getMap());
    }
}

/**
 * 浅拷贝
 * 对象内的引用也被复制时为深拷贝
 */
@Data
@AllArgsConstructor
class Prototype implements Cloneable {
    private String name;
    private Map<String, String> map;


    @Override
    public Prototype clone() throws CloneNotSupportedException {
        Prototype prototype = (Prototype) super.clone();
        prototype.map = map;
        prototype.name = name;
        return prototype;
    }
}


