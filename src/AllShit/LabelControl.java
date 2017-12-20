package AllShit;

public class LabelControl {

    public static void testLabels(int[] f) {
        outer:
        for (; true; ) {
            inner:
            for (int j = 0; j < f.length; j++) {
                if (f[j] == 2) {
                    System.out.println("inner out, outer countinues");
                    continue inner;
                } else System.out.println(f[j]);
                if (f[j] == 13) {
                    System.out.println("break out");
                    break outer;
                }
            }
        }
    }
}
