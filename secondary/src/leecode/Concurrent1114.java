package leecode;

/**
 * https://leetcode-cn.com/problems/print-in-order/
 */
public class Concurrent1114 {

    public static void main(String[] args) {

    }

    private volatile int flag = 1;

    public void first(Runnable printFirst) throws InterruptedException {

        // printFirst.run() outputs "first". Do not change or remove this line.
        printFirst.run();
        flag = 2;
    }

    public void second(Runnable printSecond) throws InterruptedException {
        while(flag != 2);
        // printSecond.run() outputs "second". Do not change or remove this line.
        printSecond.run();
        flag = 3;
    }

    public void third(Runnable printThird) throws InterruptedException {
        while(flag != 3);
        // printThird.run() outputs "third". Do not change or remove this line.
        printThird.run();
    }


}
