package Test1;

import java.util.Random;

public class ThreadFileMinus implements Runnable {
    Random rnd;
    int sum;

    public ThreadFileMinus() {
        rnd = new Random();
    }

    @Override
    public void run() {
        System.out.println("Im doing X - Y -->"+Thread.currentThread().getName());
        this.sum = rnd.nextInt(100) - rnd.nextInt(100);
        System.out.println(sum+" "+Thread.currentThread().getName());

    }
}
