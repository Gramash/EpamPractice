package AllShit;

import java.util.Random;

public class randm25int {
    public static int generateRandom1(){
            int result  = 0;
        for (int i=0; i <= 25; i ++) {
           Random random1 = new Random();
           result = Math.abs(random1.nextInt()  );
           System.out.println ("randomInt1 = " + result);
        }
        return result;
    }


}
