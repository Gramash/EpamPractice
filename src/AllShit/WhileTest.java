package AllShit;

public class WhileTest {
    public static boolean condition() {
        double r = Math.random();
        boolean result = r < 0.99;
        System.out.print("random = " + r + " ");
        System.out.println("result = " + result);
        return result;
    }

}
