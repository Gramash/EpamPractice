package ua.nure.garmash.Practice5;

import java.util.Scanner;

public class Spam {
    static long[] interval = {1000, 2000, 3000};
    static String[] messages = {"thread 1 ", "thread 2 ", "thread 3 "};


    public static void main(String[] args) {
        Spam spam = new Spam(interval, messages);
        spam.start();
        Scanner scanner = new Scanner(System.in);
        scanner.nextLine();
        spam.stop();

    }


    public Spam(long[] time, String[] messages) {

    }

    static Thread[] threadArr = new Thread[messages.length];

    static void start() {
        for (int i = 0; i < messages.length; i++) {
            int finalI = i;
            threadArr[i] = new Thread() {
                @Override
                public void run() {
                    try {
                        while (!isInterrupted()) {
                            threadArr[finalI].sleep(interval[finalI]);
                            System.out.println(messages[finalI]);
                        }
                    } catch (InterruptedException e) {
                        return;
                    }
                }

            };
            threadArr[i].start();
        }
    }

    void stop() {
        for (Thread thread : threadArr) {
            thread.interrupt();
        }

    }


}
