package ua.nure.garmash.Practice5;


public class Part1 {
    static int i = 0;
    static int j = 0;

    public static class RunnableThread implements Runnable {

        @Override
        public void run() {
            while (i < 6) {
                i++;
                System.out.println(Thread.currentThread().getName());
                try {
                    Thread.currentThread().sleep(500);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public static class B extends Thread {

        @Override
        public void run() {
            while (j < 6) {
                j++;
                System.out.println(this.getName());
                try {
                    sleep(500);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public static void main(String[] args) {
        Thread runnable = new Thread(new RunnableThread());
        B extendThread = new B();
        runnable.start();
        extendThread.start();

    }
}
