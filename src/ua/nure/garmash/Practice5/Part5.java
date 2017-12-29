package ua.nure.garmash.Practice5;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;

public class Part5 extends Thread {
    private static long[] startPosition = {0, 22, 44, 66, 88, 110, 132, 154, 176, 198};
    private static Writer writer = new Writer();
    private static Thread threads[] = new Thread[10];

    public static void main(String[] args) throws IOException, InterruptedException {
        for (int i = 0; i < 10; i++) {
            int finalI = i;
            threads[i] = new Thread() {
                long startPos = startPosition[finalI];
                public void run() {
                    for (int j = 0; j < 20; j++) {
                        startPos = writer.write(startPos, finalI, j==19);
                    }
                }
            };
            threads[i].start();
        }
        for (Thread t : threads) {
            t.join();
        }
    }

    private static class Writer {
        RandomAccessFile raf;

        public Writer() {
            try {
                raf = new RandomAccessFile("Practice5Part5.txt", "rws");
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            }
        }

        public synchronized long write(long startPos, int data, boolean endLine) {
            System.out.println(currentThread() + String.valueOf(data));
            try {
                raf.seek(startPos);
                raf.write('0' + data);
                sleep(50);
                if (endLine) {
                    raf.write(System.lineSeparator().getBytes());
                }
                return raf.getFilePointer();
            } catch (Exception e) {
                e.printStackTrace();
            }
            throw new Error("cant write to file");
        }

    }

}
