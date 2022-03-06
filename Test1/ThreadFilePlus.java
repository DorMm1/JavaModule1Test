package Test1;

import java.util.Random;

public class ThreadFilePlus implements Runnable{
    Random rnd;
    int sum;

    public ThreadFilePlus() {
        rnd = new Random();
    }

    @Override
    public void run() {
        System.out.println("Im doing X + Y -->"+Thread.currentThread().getName());
        this.sum = rnd.nextInt(100) + rnd.nextInt(100);
        System.out.println(sum+" "+Thread.currentThread().getName());

    }
}
