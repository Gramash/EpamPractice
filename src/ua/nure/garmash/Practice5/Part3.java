package ua.nure.garmash.Practice5;


import static ua.nure.garmash.Practice5.Part3.Counter.counter;


public class Part3 extends Thread {


    public static void main(String[] args) {

        Thread th1 = new Part3();
        Thread th2 = new Part3();
        th1.start();
        th2.start();


    }

    @Override
    public void run() {
        while (true) {
            synchronized (counter) {
                System.out.println(counter.counter1 == counter.counter2);
                counter.counter1++;
                try {
                    sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                counter.counter2++;
            }
        }
    }

    public static class Counter {
        int counter1;
        int counter2;
        static Counter counter = new Counter();
    }


}
