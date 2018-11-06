package datastructure.base;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * 一般背包问题
 */
public class backpack {
    public static void main(String[] args) {
        int[] w = {1, 2, 5, 6, 7, 8, 8, 9, 345, 24, 52, 34, 234, 23, 4, 3, 23, 42, 34, 43, 42, 423, 423, 4, 23423, 2, 2, 2, 3, 2, 2, 2, 2, 2};
        int[] p = {1, 2, 5, 6, 7, 8, 8, 9, 345, 24, 52, 34, 234, 23, 4, 3, 23, 42, 34, 43, 42, 423, 423, 4, 23423, 2, 2, 2, 3, 2, 2, 2, 2, 2};
        int m = 1000000000;
        long start = System.currentTimeMillis();

        List<Body> b = commonPackage(w, p, m);

        long end = System.currentTimeMillis();
        long time = end - start;
        System.out.println("结果为" + b.get(0).price + "时间为 ========" + time + " ms");
    }

    /**
     * @param weight 每个物体重量的数组
     * @param price  每个物体收益的数组
     * @param m      背包载重
     * @return 结果集（放入哪几个物体、每个物体放入多少部分）
     */
    static List<Body> commonPackage(int[] weight, int[] price, int m) {
        // 1.物体对象放入列表
        List<Body> bodyList = new ArrayList<>();
        for (int i = 0; i < weight.length; i++) {
            bodyList.add(new Body(weight[i], price[i]));
        }
        // 2.对性价比排序
        Collections.sort(bodyList, (body1, body2) -> body2.price / body2.weight - body1.price / body1.weight);
        // 3.将物体按照性价比从高到低放入背包
        int rest = m;
        int i = 0;
        List<Body> resultList = new ArrayList<>();
        for (Body body : resultList) {
            if (rest < body.weight) {
                break;
            }
            resultList.add(body);
            rest -= body.weight;
        }
        // 4.计算最后一个物体能放入的部分
        Body last = bodyList.get(i);
        resultList.add(new Body(last.id, rest, (last.price * rest / last.weight)));
        return resultList;
    }
}

class Body {
    int id;
    int weight;
    int price;

    public Body(int weight, int price) {
        this.weight = weight;
        this.price = price;
    }

    public Body(int id, int weight, int price) {
        this.id = id;
        this.weight = weight;
        this.price = price;
    }

    public Body(int id) {
    }
}
