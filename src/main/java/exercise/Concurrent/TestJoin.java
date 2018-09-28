package exercise.Concurrent;

class TestJoin implements Runnable {

    private String name;

    public TestJoin(String name) {
        this.name = name;
    }

    @Override
    public void run() {
        for (int i = 0; i < 10; i++) {
            System.out.println(Thread.currentThread().getName() + " " + i);
        }
    }


    public static void main(String[] args) {
        TestJoin test1 = new TestJoin("线程A");
        TestJoin test2 = new TestJoin("线程B");
        //1. 创建状态
        Thread t1 = new Thread(test1);
        Thread t2 = new Thread(test2);
        //2. 就绪状态
        t1.start();
        t2.start();
        for (int i = 0; i < 50; i++) {
            if (i > 10) {
                try {
                    t1.join();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            System.out.println("========================"  + i);
        }
    }
}