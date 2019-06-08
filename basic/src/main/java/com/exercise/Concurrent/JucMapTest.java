package com.exercise.Concurrent;

import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.*;
import java.util.stream.Collectors;

public class JucMapTest {
    public static void main(String[] args) {
        List<Model> list1 = Collections.synchronizedList(new ArrayList<>());
        list1.add(Model.builder().age("11").name("M").sex("0").build());
        list1.add(Model.builder().age("13").name("L").sex("0").build());
        list1.add(Model.builder().age("14").name("L").sex("0").build());
        list1.add(Model.builder().age("12").name("M").sex("1").build());
        Map<String, List<Model>> map1 = list1.stream().collect(Collectors.groupingBy(Model::getName));

        for (int i = 0; i < 3; i++) {
            new JucMapTest().sort(map1);
        }
    }

    public void sort(Map<String, List<Model>> map){
        new Thread(() ->{
            for(Map.Entry<String,List<Model>> entry : map.entrySet()){
                Collections.sort(entry.getValue(), new Comparator<Model>() {
                    @Override
                    public int compare(Model o1, Model o2) {
                        return o2.getAge().compareTo(o1.getAge());
                    }
                });
            }
//            for(ConcurrentHashMap.Entry<String,List<Model>> entry : map.entrySet()){
//                list.add(entry.getValue().get(0));
//            }
//            }
        }).start();

    }


}


@Data
@Builder
@NoArgsConstructor
class Model implements Comparable<Model> {
    private String name;
    private String age;
    private String sex;

    public Model(String name, String age, String sex) {
        this.name = name;
        this.age = age;
        this.sex = sex;
    }

    @Override
    public int compareTo(Model o) {
        return this.getAge().compareTo(o.getAge());
    }
}