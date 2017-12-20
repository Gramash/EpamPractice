package Concurrency;

public class MutliThreadRunnable implements Runnable {
    private Thread t;
//        String name;

    MutliThreadRunnable(String threadName) {
//            name = threadName;

    }

    // point where thread execution starts
    @Override
    public void run() {
        try {
            for (int i = 5; i > 0; i --) {
                System.out.println(t + "is running at " + i ) ;
                Thread.sleep(1000);
            }
        } catch (InterruptedException e) {
            System.out.println("hujpizda");
        }
        System.out.println("thread" + t + "has ended nicely");
    }
}
