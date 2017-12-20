package AllShit;

public class FindPrimeNumber {
    public static void prinmeFinder(int limit) {
        boolean flag = true;
        for (int i = 1; i <= limit; i++) {
            if (flag == true) {
                System.out.println("Prime number " + (i-1));
            } else {
                System.out.println("Not prime " + (i-1));
                flag = true;
            }
            for (int j = 2; j < i; j++) {
                if (i % j == 0 && j!=i) {
                    flag = false;
                    break;
                }
            }
        }
    }
}

