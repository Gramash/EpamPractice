package ua.nure.garmash.Practice3;

/**
 * Created by User on 11/20/2017.
 */
public class Part5 {
    public static void main(String[] args) {
        System.out.println(convert(99));
        System.out.println(convert(4));
        System.out.println(convert(9));
        System.out.println(convert(40));
//        System.out.println(convert(104));
    }

    public static final int[] DECIMAL = {1, 4, 5, 9, 10, 40, 50, 90, 100};
    public static final String[] ROMAN = {"I", "IV", "V", "IX", "X", "XL", "L", "XC", "C"};
//    public static final HashMap<Integer, String> STORE = new HashMap();

    public static String convert(int decimal) {
        if (decimal > 100) {
            throw new IllegalArgumentException("Please specify proper number. Allowed range: 0-100;" +
                    System.lineSeparator() + "Your value: " + decimal);
        }
        if (decimal == 0) return "null";
        StringBuilder result = new StringBuilder().append(decimal).append(" ==> ");
        int i = DECIMAL.length - 1;
        while (decimal != 0) {
            int temp = decimal / DECIMAL[i];
            while (temp != 0) {
                temp--;
                result.append(ROMAN[i]);
            }
            decimal = decimal % DECIMAL[i];
            i--;
        }
        return result.toString();
    }
}

