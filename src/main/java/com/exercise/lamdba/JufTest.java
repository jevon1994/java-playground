package com.exercise.lamdba;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;
import java.util.stream.Stream;

/**
 * 测试java.util.function的函数式接口的支持lambda表达式的api
 */
public class JufTest {
    public static void main(String[] args) {
        List<Person> lisiList = new ArrayList<>();
        Consumer<Person> consumer  = x -> {
            if (x.getName().equals("lisi")){
                lisiList.add(x);
            }
        };

        new JufTest().acceptTest(s ->{
            s.setAge(1);
            s.setName("mj");
            lisiList.add(s);
        });
//        new JufTest().andThenTest(consumer,lisiList);

        System.out.println(lisiList);
    }

    /**
     * 对给定参数执行默认操作
     * @param consumer
     */
    public void acceptTest(Consumer<Person> consumer){
        consumer.accept(new Person());
//        Stream.of(
//                new Person(21,"zhangsan"),
//                new Person(22,"lisi"),
//                new Person(23,"wangwu"),
//                new Person(24,"wangwu"),
//                new Person(23,"lisi"),
//                new Person(26,"lisi"),
//                new Person(26,"zhangsan")
//        ).forEach(consumer);

    }

    /**
     * 执行操作后再继续执行after定义的操作
     * @param consumer
     * @param lisiList
     */
    public void andThenTest(Consumer<Person> consumer,List<Person> lisiList){
        consumer = consumer.andThen(
                x -> lisiList.removeIf(y -> y.getAge() < 23)
        );

        Stream.of(
                new Person(21,"zhangsan"),
                new Person(22,"lisi"),
                new Person(23,"wangwu"),
                new Person(24,"wangwu"),
                new Person(23,"lisi"),
                new Person(26,"lisi"),
                new Person(26,"zhangsan")
        ).forEach(consumer);
    }


}
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
class Person{
    private Integer age;
    private String name;
}