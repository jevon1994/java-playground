package exercise.Concurrent;

public class ProducerAndConsumer {
    public static void main(String[] args) {
        SelfFactory selfFactory = new SelfFactory();
        Producer producer = new Producer(selfFactory);
        Consumer consumer = new Consumer(selfFactory);
        new Thread(producer).start();
        new Thread(consumer).start();
    }
}
//产品类
class Product {
    int id;

    public Product(int id) {
        this.id = id;
    }
}
//工厂类
class SelfFactory {
    int index = 0;

    Product[] product = new Product[6];

    public synchronized void push(Product p) {
        while (index == product.length) {
            try {
                this.wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        this.notifyAll();
        product[index] = p;
        index++;
    }

    public synchronized Product pop(Product p) {
        while (index == 0) {
            try {
                this.wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        this.notifyAll();
        index--;
        return product[index];
    }

}
//生产者
class Producer implements Runnable {
    private SelfFactory selfFactory;

    public Producer(SelfFactory selfFactory) {
        this.selfFactory = selfFactory;
    }

    @Override
    public void run() {
        for (int i = 0; i < 20; i++) {
            Product product = new Product(i);
            selfFactory.push(product);
            System.out.println("生产者 ： " + i);
            try {
                Thread.sleep((int) (Math.random() * 100));
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
//消费者
class Consumer implements Runnable {
    private SelfFactory selfFactory;

    public Consumer(SelfFactory selfFactory) {
        this.selfFactory = selfFactory;
    }

    @Override
    public void run() {
        for (int i = 0; i < 20; i++) {
            Product product = new Product(i);
            selfFactory.pop(product);
            System.out.println("消费者 ： " + i);
            try {
                Thread.sleep((int) (Math.random() * 100));
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}