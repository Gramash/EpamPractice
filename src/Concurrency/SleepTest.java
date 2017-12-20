package Concurrency;

import java.util.Date;

import static java.lang.Thread.currentThread;

public class SleepTest {
    public void sleepThread() {
        int count = 5;
        try {
            do {
                --count;
                Date date = new Date();
                System.out.println("current thread name + " + Thread.currentThread() + " " + date);
                Thread.sleep(1000);
            } while (count > 0);
            System.out.println("ur thread + " + Thread.currentThread() + " has drowned in the embrace of sweet oblivion");
        } catch (InterruptedException e) {
            System.out.println("ur thread + " + Thread.currentThread() + " has drowned in the embrace of sweet oblivion");
        }
    }
}
