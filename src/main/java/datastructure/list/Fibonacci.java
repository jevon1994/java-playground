package datastructure.list;

/**
 * 递归
 */
public class Fibonacci {
    public static void main(String[] args) {
        int f = Fib(5);
        System.out.println(f);
    }

    public static int Fib(int index) {
        // F(0) = F(1) = 1
        if (index == 1 || index == 2) {
            return 1;
        } else {
            // F(n) = F(n-1) + F(n - 2)
            return Fib(index - 1) + Fib(index - 2);
        }
    }
}
