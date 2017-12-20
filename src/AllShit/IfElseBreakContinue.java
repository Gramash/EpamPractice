package AllShit;

public class IfElseBreakContinue {
    public static void test (int[] f ) {
        for (int i = 0; i<f.length; i++) {
            if (f[i] == 0) {
                System.out.println(i);
                break;
            } else {
                System.out.println("i equals " + i + "not 0");
                break;
            }
        }
    }
}
