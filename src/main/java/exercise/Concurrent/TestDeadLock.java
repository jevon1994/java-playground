package exercise.Concurrent;

public class TestDeadLock implements Runnable {
    private int flag = 1;
    //加载完静态代码块后再加载
    static Object A = new Object(), B = new Object();

    @Override
    public void run() {

        if (flag == 1) {
            //锁定o1对象
            synchronized (A) {
                try {
                    Thread.sleep(500);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                //锁定o2对象
                synchronized (B) {
                    System.out.println(Thread.currentThread().getName());
                }
            }
        }
        if (flag == 0) {
            //锁定o2对象
            synchronized (B) {
                try {
                    Thread.sleep(500);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                //锁定o1对象
                synchronized (A) {
                    System.out.println(Thread.currentThread().getName());
                }
            }
        }
    }

    public static void main(String[] args) {
        TestDeadLock tt1 = new TestDeadLock();
        TestDeadLock tt2 = new TestDeadLock();
        tt1.flag = 0;
        tt2.flag = 1;
        Thread t1 = new Thread(tt1);
        Thread t2 = new Thread(tt2);
        t1.start();
        t2.start();
    }
}
