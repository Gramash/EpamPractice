package Concurrency;

import java.util.Date;

public class MainThread {
    public static void main(String[] args) {
//        Thread t = Thread.currentThread();
//        SleepTest sleepTestInstance = new SleepTest();
//        System.out.println("current Thread name: " + t);
//        t.setName("H00L1GUN");
//        System.out.println("new Thread name: " + t);
//        sleepTestInstance.sleepThread();

        new MutliThreadRunnable("first");
        new MutliThreadRunnable("second");
        new MutliThreadRunnable("third");

        new Thread(new MutliThreadRunnable("first")).start(); // create new thread
        System.out.println("new thread named: created");
        new Thread(new Runnable() {
            @Override
            public void run() {

            }
        }).start();
//        t.start(); // execute the thread

//        try {
//            Thread.sleep(10000);
//        } catch (InterruptedException e) {
//            System.out.println("hujpizda");
//        }
    }
}
