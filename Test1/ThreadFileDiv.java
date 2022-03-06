package Test1;

import java.util.Random;

public class ThreadFileDiv implements Runnable{
    Random rnd;
    int sum;

    public ThreadFileDiv() {
        rnd = new Random();
    }

    @Override
    public void run() {
        System.out.println("Im doing X / Y -->"+Thread.currentThread().getName());
        this.sum = rnd.nextInt(100) / rnd.nextInt(100);
        System.out.println(sum+" "+Thread.currentThread().getName());

    }
}
