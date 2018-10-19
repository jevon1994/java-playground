package Collection.linkedList;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 队列 -- 先进先出(FIFO)
 */
public class QueueDemo {
    public static void main(String[] args) {
        // 父类引用queue指向子类对象
        Queue<String> queue = new LinkedList<String>();
        // offer()方法是往队列加入元素
        queue.offer("xiaoyun");
        queue.offer("yulon");
        queue.offer("羽龙共舞");
        String element = null;
        while((element=queue.poll())!=null){
            System.out.println(element+"\t");
        }
    }
}
