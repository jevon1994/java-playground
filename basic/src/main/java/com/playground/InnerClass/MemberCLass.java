package com.playground.InnerClass;

/**
 * 成员内部类
 */
public class MemberCLass {

    private int a = 1;


    public class InnerClass {
        private int a = 2;

        public void test() {
            System.out.println(MemberCLass.this.a);
        }

    }


    public static void main(String[] args) {
        MemberCLass.InnerClass innerClass = new MemberCLass().new InnerClass();
        innerClass.test();
    }
}
