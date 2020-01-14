package com.design_parttern.structural;

/**
 * @ClassName FacadeTest
 * @Description
 * @Author Jevon
 * @Date2020/1/14 17:44
 **/
public class FacadeTest {
    public static void main(String[] args) {
        FacadeTest facadeTest = new FacadeTest();
        facadeTest.facade();
    }

    /**
     * 组合提供对外方法
     */
    public void facade(){
        a();
        b();
    }

    public void a(){
        System.out.println("A do sth");
    }

    public void b(){
        System.out.println("B do sth");
    }
}