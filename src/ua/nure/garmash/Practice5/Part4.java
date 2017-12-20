package ua.nure.garmash.Practice5;

import java.util.Random;

public class Part4 {


    public static void main(String[] args) throws InterruptedException {

        final int[] max = new int[1];
        fillMatrix();
        for (int[] row : matrix) {
            printMultiDimArr(row);
        }
        for (int j = 0; j < 4; j++) {
            int finalJ = j;
            threadArr[j] = new Thread() {
                @Override
                public void run() {
                    int temp = 0;
                    for (int i = 0; i < 100; i++) {
//                        System.out.println(Thread.currentThread().getName() + "iteration " + i);
                        if (matrix[finalJ][i] > temp) {
                            temp = matrix[finalJ][i];
                        }
                    }
                    System.out.println(temp);
                    synchronized (this) {
                        max[0] = max[0] < temp ? temp : max[0];
                    }
                }
            };
            threadArr[j].start();
        }
        for (Thread t : threadArr) {
            t.join();
        }
        System.out.println("Max values is: " + max[0]);

    }

    static Thread threadArr[] = new Thread[4];
    static int[][] matrix = new int[4][100];

    public static void fillMatrix() {
        Random rand = new Random();
        for (int i = 0; i < 4; i++) {
            for (int j = i; j < 100; j++) {
                matrix[i][j] = rand.nextInt(1000);
            }
        }
    }

    public static void printMultiDimArr(int[] row) {
        for (int i : row) {
            System.out.print(i);
            System.out.print("\t");
        }
        System.out.println();
    }
}
